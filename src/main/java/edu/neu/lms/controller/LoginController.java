package edu.neu.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.lms.dao.UserDao;
import edu.neu.lms.enumTypes.RoleType;
import edu.neu.lms.model.User;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/lms")
public class LoginController {

	@Autowired
	private UserDao userDao;

	@GetMapping
	public String landingPage() {
		return "login";
	}

	@GetMapping("/signup")
	public String register() {
		return "signup";
	}

	@PostMapping
	public String login(User user, HttpSession httpSession) throws Exception {

		// authorize user
		User loggedInUser = userDao.authenticate(user);

		// store authorized user in session
		httpSession.setAttribute("username", loggedInUser.getFirstName());
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

	@GetMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/lms";
	}

}
