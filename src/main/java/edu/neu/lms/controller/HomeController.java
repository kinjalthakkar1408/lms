package edu.neu.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.neu.lms.dao.BookDao;
import edu.neu.lms.dao.IssuanceDao;
import edu.neu.lms.dao.LibraryDao;
import edu.neu.lms.dao.StudentDao;
import edu.neu.lms.dao.UserDao;
import edu.neu.lms.enumTypes.RoleType;
import edu.neu.lms.model.Author;
import edu.neu.lms.model.Book;
import edu.neu.lms.model.Category;
import edu.neu.lms.model.Issuance;
import edu.neu.lms.model.Publisher;
import edu.neu.lms.model.Student;
import edu.neu.lms.model.User;
import jakarta.servlet.http.HttpSession;
import javassist.NotFoundException;

@Controller
@RequestMapping("/lms/home")
public class HomeController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BookDao bookDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private IssuanceDao issuanceDao;

	@Autowired
	private LibraryDao libraryDao;

	@PostMapping
	public String login(User user, HttpSession httpSession) throws Exception {

		// authorize user
		User loggedInUser = userDao.authenticate(user);

		List<Book> books = bookDao.list();
		List<Author> authors = bookDao.listAuthors();
		List<Category> categories = bookDao.listCategory();
		List<Publisher> publishers = bookDao.listPublisher();

		httpSession.setAttribute("books", books);
		httpSession.setAttribute("authors", authors);
		httpSession.setAttribute("category", categories);
		httpSession.setAttribute("publishers", publishers);

		// store authorized user in session
		httpSession.setAttribute("username", loggedInUser.getFirstName());
		httpSession.setAttribute("logedInUserId", loggedInUser.getId());
		httpSession.setAttribute("loggedInUser", loggedInUser);
		httpSession.setAttribute("role", loggedInUser.getRole());

		RoleType role = loggedInUser.getRole();

		if (role.equals(RoleType.Admin)) {
			return "homepage";
		} else if (role.equals(RoleType.Librarian)) {
			return "librarian-dashboard";
		} else {
			return "student-dashboard";
		}
	}

	@GetMapping
	public String bookDetails(HttpSession httpSession) throws NotFoundException {
		return "homepage";
	}

	@GetMapping("/bookListAvailable")
	public String bookDetailsForStudent(HttpSession httpSession) throws NotFoundException {

		return "books-student-page";
	}

	@DeleteMapping("/deleteBook/{id}")
	public String deleteAuthor(@PathVariable("id") int id) {
		try {
			Book book = bookDao.get(id);
			// Delete all books that have this author ID

			bookDao.delete(book);
			return "Book deleted successfully";
		} catch (NotFoundException e) {
			return "Book not found";
		}
	}

	@PutMapping("/update/{bookId}")
	public ResponseEntity<String> updateBook(@PathVariable("bookId") String bookId, @RequestBody Book book)
			throws NumberFormatException, NotFoundException {
		// Check if book with given bookId exists
		Book existingBook = bookDao.get(Long.parseLong(bookId));

		if (existingBook == null) {
			throw new NotFoundException("book not found with ID: " + bookId);
		}

		existingBook.setBookName(book.getBookName());
//		existingBook.setIsbn(book.getIsbn());
		existingBook.setDescription(book.getDescription());
//		existingBook.setAuthor(book.getAuthor());
//		existingBook.setPublisher(book.getPublisher());
//		existingBook.setCategory(book.getCategory());
//		existingBook.setIssuances(book.getIssuances());
//		existingBook.setAvailability(book.isAvailability());
		existingBook.setNoOfcopies(book.getNoOfcopies());
		bookDao.update(existingBook);

		return new ResponseEntity<String>("book updated", HttpStatusCode.valueOf(204));
	}

	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId") String bookId)
			throws NumberFormatException, NotFoundException {
		return new ResponseEntity<Book>(bookDao.get(Long.parseLong(bookId)), HttpStatus.FOUND);
	}

	@PostMapping("/createBook")
	public ResponseEntity<Book> createBook(@RequestBody Book book) throws NotFoundException {
		Book createdBook = bookDao.create(book);
		return new ResponseEntity<>(createdBook, HttpStatus.OK);
	}

	@GetMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/login";
	}

	@PostMapping("/students/{studentId}/issuances")
	public ResponseEntity<Issuance> processIssuance(@PathVariable long studentId, @RequestBody Issuance issuance)
			throws NotFoundException {

		// fetch student
		Student student = studentDao.get(studentId);

		// fetch book
		Book book = bookDao.get(issuance.getBook().getId());

		// check if book is available
		if (book.getNoOfcopies() <= 0 || !book.isAvailability()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		// update issuance with correct values
		issuance.setBook(book);
		issuance.setStudent(student);

		// decrease the number of copies
		book.setNoOfcopies(book.getNoOfcopies() - 1);

		// if there are no more copies, update availability
		if (book.getNoOfcopies() == 0) {
			book.setAvailability(false);
		}

		// send created issuance to librarian
		issuanceDao.create(issuance);
		bookDao.update(book);

		// libraryDao.addIssuance(issuance);

		return new ResponseEntity<>(issuance, HttpStatus.CREATED);
	}

//	@GetMapping("/students/{studentId}/getIssuances")
//	public ResponseEntity<Set<Issuance>> getIssuancesByStudent(@PathVariable long studentId) throws NotFoundException {
//	    Set<Issuance> issuances = issuanceDao.getIssuancesByStudent(studentId);
//	    return new ResponseEntity<>(issuances, HttpStatus.OK);
//	}

//	@GetMapping("/students/getIssuances")
//	public ResponseEntity<List<Issuance>> getIssuancesForCurrentUser( HttpSession httpSession) throws NotFoundException {
//		// authorize user
//		//User loggedInUser = userDao.authenticate(user);
//		
//		//session.setAttribute("loggedInUser", loggedInUser);
//	    // Get the user ID from the session
//		Long userId = (Long) httpSession.getAttribute("logedInUserId");
//	    
//	    // Retrieve the issuances for the current user ID
//	    List<Issuance> issuances = issuanceDao.getIssuancesForUser(userId);
//	    
//	    return new ResponseEntity<>(issuances, HttpStatus.OK);
//	}

	@GetMapping("/students/getIssuances")
	public String getIssuancesForCurrentUser(Model model, HttpSession httpSession) throws NotFoundException {
		// Get the user ID from the session
		Long userId = (Long) httpSession.getAttribute("logedInUserId");

		// Retrieve the issuances for the current user ID
		List<Issuance> issuances = issuanceDao.getIssuancesForUser(userId);

		// Add the issuances list as an attribute to the model
		model.addAttribute("issuances", issuances);

		// Return the name of the JSP file as a string
		return "student-issuance";
	}

}
