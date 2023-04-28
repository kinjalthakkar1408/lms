package edu.neu.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.neu.lms.dao.AuthorDao;
import edu.neu.lms.dao.BookDao;
import edu.neu.lms.model.Author;
import edu.neu.lms.model.Book;
import jakarta.servlet.http.HttpSession;
import javassist.NotFoundException;

@Controller
@RequestMapping("/lms/author")
public class AuthorController {
	
	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private BookDao bookDao;
	
	
	@GetMapping
	public String bookDetails(HttpSession httpSession) throws Exception {
		
		List<Author> authors = authorDao.list();
		httpSession.setAttribute("authors", authors);
		return "authorDetails";
	}


}
