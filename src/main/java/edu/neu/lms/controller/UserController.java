package edu.neu.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.lms.dao.UserDao;
import edu.neu.lms.model.User;
import javassist.NotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserDao userDao;

	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User user) throws NotFoundException {
		userDao.create(user);
		return new ResponseEntity<String>("user created", HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userId)
			throws NumberFormatException, NotFoundException {
		return new ResponseEntity<User>(userDao.get(Long.parseLong(userId)), HttpStatus.FOUND);
	}

	@GetMapping
	public List<User> getAllUsers() throws NotFoundException {
		return userDao.list();
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("userId") String userId) throws NumberFormatException, NotFoundException {
		User exUser = userDao.get(Long.parseLong(userId));
		userDao.delete(exUser);
		return new ResponseEntity<String>("user deleted", HttpStatusCode.valueOf(204));
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable("userId") String userId,@RequestBody User user) throws NumberFormatException, NotFoundException {
		// Check if user with given userId exists
		User existingUser = userDao.get(Long.parseLong(userId));
		
		if (existingUser == null) {
			throw new NotFoundException("User not found with ID: " + userId);
		}
		
//		existingUser.setFirstName(user.getFirstName());
//		existingUser.setLastName(user.getLastName());
//		existingUser.setGender(user.getGender());
//		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setUsername(user.getUsername());
		existingUser.setRole(user.getRole());
		userDao.update(existingUser);
		
		return new ResponseEntity<String>("user updated", HttpStatusCode.valueOf(204));
	}

}
