package edu.neu.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.lms.dao.StudentDao;
import edu.neu.lms.model.Student;
import jakarta.servlet.http.HttpSession;
import javassist.NotFoundException;

@Controller
@RequestMapping("/lms/student")
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;
	

	@GetMapping
	public String studentDetails(HttpSession httpSession) throws NotFoundException {	
		List<Student> students = studentDao.list();
		httpSession.setAttribute("students", students);		
		return "studentDetails";
	}

}
