package edu.neu.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.lms.dao.CategoryDao;
import edu.neu.lms.model.Category;
import jakarta.servlet.http.HttpSession;
import javassist.NotFoundException;

@Controller

public class CategoryController {

	@Autowired
	private CategoryDao categoryDao;

	
	@RequestMapping(value = "/lms/category" , method = RequestMethod.GET)
	public String publisherDetails(HttpSession httpSession) throws NotFoundException{
		List<Category> category = categoryDao.list();
		httpSession.setAttribute("category", category);		
		return "categoryDetails";
		
	}
	
}
