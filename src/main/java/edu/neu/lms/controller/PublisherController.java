package edu.neu.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.lms.dao.PublisherDao;
import edu.neu.lms.model.Publisher;
import jakarta.servlet.http.HttpSession;
import javassist.NotFoundException;

@Controller
@RequestMapping("/lms/publisher")
public class PublisherController {
	
	@Autowired
	private PublisherDao publisherDao;
	
//	
//	@GetMapping
//	public ModelAndView loadPublisherPage() {
//		return new ModelAndView("publisherDetails");
//	}
	
	@GetMapping
	public String publisherDetails(HttpSession httpSession) throws NotFoundException {	
		List<Publisher> publisher = publisherDao.list();
		httpSession.setAttribute("publishers", publisher);		
		return "publisherDetails";
	}

}
