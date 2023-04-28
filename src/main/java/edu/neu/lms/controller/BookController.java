package edu.neu.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.lms.dao.BookDao;
import edu.neu.lms.model.Author;
import edu.neu.lms.model.Book;
import javassist.NotFoundException;


@Controller
@RequestMapping("/lms/addBooks")
public class BookController {
	
	@Autowired
	private BookDao bookDao;
	
	
	@GetMapping
	public ModelAndView loadBookPage() {
		return new ModelAndView("addBooks");
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteAuthor(@PathVariable("id") int id) {
	    try {
	        Book book = bookDao.get(id);
	        // Delete all books that have this author ID

	        bookDao.delete(book);
	        return "Author deleted successfully";
	    } catch (NotFoundException e) {
	        return "Author not found";
	    }
	}
	
	@PutMapping("/update/{bookId}")
	public ResponseEntity<String> updateBook(@PathVariable("bookId") String bookId,@RequestBody Book book) throws NumberFormatException, NotFoundException {
		// Check if book with given bookId exists
		Book existingBook = bookDao.get(Long.parseLong(bookId));
		
		if (existingBook == null) {
			throw new NotFoundException("book not found with ID: " + bookId);
		}
		
		existingBook.setBookName(book.getBookName());
		existingBook.setIsbn(book.getIsbn());
		existingBook.setDescription(book.getDescription());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setPublisher(book.getPublisher());
		existingBook.setCategory(book.getCategory());
		existingBook.setIssuances(book.getIssuances());
		existingBook.setAvailability(book.isAvailability());
		bookDao.update(existingBook);
		
		return new ResponseEntity<String>("book updated", HttpStatusCode.valueOf(204));
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId") String bookId)
			throws NumberFormatException, NotFoundException {
		return new ResponseEntity<Book>(bookDao.get(Long.parseLong(bookId)), HttpStatus.FOUND);
	}
}