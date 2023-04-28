package edu.neu.lms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.neu.lms.dao.IssuanceDao;
import edu.neu.lms.dao.LibrarianDao;
import edu.neu.lms.model.Issuance;
import edu.neu.lms.model.Librarian;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import javassist.NotFoundException;

@Controller
@RequestMapping("/lms/librarian")
public class LibrarianController {

	@Autowired
	private LibrarianDao librarianDao;

	@Autowired
	private IssuanceDao issuanceDao;

	@GetMapping
	public String librarianDetails(HttpSession httpSession) throws NotFoundException {
		List<Librarian> librarian = librarianDao.list();
		httpSession.setAttribute("librarian", librarian);
		return "librarianDetails";
	}

	@GetMapping("displayAllIssuances")
	public String getAllIssuances(HttpServletRequest req) throws NotFoundException {
		List<Issuance> issuances = issuanceDao.list();

		req.setAttribute("issuances", issuances);

		if (issuances.isEmpty()) {
			return "librarian-dashboard";
		}
		return "librarian-issuance";
	}

}
