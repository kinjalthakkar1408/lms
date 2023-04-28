package edu.neu.lms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.neu.lms.enumTypes.Gender;
import edu.neu.lms.enumTypes.RoleType;
import edu.neu.lms.model.User;
import javassist.NotFoundException;

@Repository
public class UserDao extends DAO {
	public UserDao() {
	}

	public User get(long id) throws NotFoundException {

		try {
			// Fetch user object from the database based on id
			begin();
			User user = getSession().get(User.class, id);
			commit();
			close();

			return user;
		} catch (HibernateException e) {

			rollback();
			// throw new AdException("Could not fetch user with id: " + id, e);
			throw new NotFoundException("Exception while fetching user with id: " + id + ", " + e.getMessage());
		}

	}

	public User create(User user) throws NotFoundException {
		try {

			// save user object in the database
			begin();
			getSession().save(user);
			commit();
			close();

			return user;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new NotFoundException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws NotFoundException {
		try {
			// save user object in the database
			begin();
			getSession().delete(user);
			commit();

		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new NotFoundException("Exception while deleting user: " + e.getMessage());
		}
	}

	public List<User> list() throws NotFoundException {
		try {
			// Fetch all user objects from the database
			begin();
			Query query = getSession().createQuery("from User");
			List<User> userList = query.list();
			commit();
			close();

			return userList;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not fetch user list", e);
			throw new NotFoundException("Exception while getting user list: " + e.getMessage());
		}
	}

	public User update(User user) throws NotFoundException {
		try {
			// Update the existing author object in the database
			begin();
			getSession().update(user);
			commit();
			close();
			return user; // Return the updated Author object
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not update user " + existingUser.getId(), e);
			throw new NotFoundException(
					"Exception while updating user with id: " + user.getId() + ", " + e.getMessage());
		}
	}

	public User authenticate(User user) throws NotFoundException {

		try {
			// Fetch user object from the database based on username and password
			begin();
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", user.getUsername());
			q.setString("password", user.getPassword());
			User found = (User) q.uniqueResult();
			close();
			
			// Get the enum values from the database and set them in the User object
			Gender gender = Gender.valueOf(found.getGender().toString());
			RoleType role = RoleType.valueOf(found.getRole().toString());
			found.setGender(gender);
			found.setRole(role);
			
			return found;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while fetching user with id ");
		}
	}
}