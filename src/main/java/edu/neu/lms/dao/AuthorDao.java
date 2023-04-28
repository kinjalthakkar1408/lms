package edu.neu.lms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.neu.lms.model.Author;
import javassist.NotFoundException;

@Repository
public class AuthorDao extends DAO{
	
	public AuthorDao() {
	}

	public Author get(long id) throws NotFoundException {

		try {
			// Fetch user object from the database based on id
			begin();
			Author author = getSession().get(Author.class, id);
			commit();
			close();

			return author;
		} catch (HibernateException e) {

			rollback();
			throw new NotFoundException("Exception while fetching author with id: " + id + ", " + e.getMessage());
		}

	}

	public Author create(Author author) throws NotFoundException {
		try {

			// save author object in the database
			begin();
			getSession().save(author);
			commit();
			close();

			return author;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while creating author: " + e.getMessage());
		}
	}
	
	public void deleteAuthorById(int authorId) throws NotFoundException {
	    try {
	        // Fetch the author object with the given ID
	        Author author = getSession().load(Author.class, authorId);
	        if (author != null) {
	            // delete the author object from the database
	            begin();
	            getSession().delete(author);
	            commit();
	        }
	    } catch (HibernateException e) {
	        rollback();
	        throw new NotFoundException("Exception while deleting author with ID " + authorId + ": " + e.getMessage());
	    }
	}


	public void delete(Author author) throws NotFoundException {
		try {
			// save author object in the database
			begin();
			getSession().delete(author);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while deleting author: " + e.getMessage());
		}
	}

	public List<Author> list() throws NotFoundException {
		try {
			// Fetch all author objects from the database
			begin();
			Query query = getSession().createQuery("from Author");
			List<Author> authorList = query.list();
			commit();
			close();

			return authorList;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while getting author list: " + e.getMessage());
		}
	}

	public Author update(Author author) throws NotFoundException {
		try {
	        // Update the existing author object in the database
	        begin();
	        getSession().update(author);
	        commit();
	        close();
	        return author; // Return the updated Author object	
		} catch (HibernateException e) {
	        rollback();
	        throw new NotFoundException("Exception while updating author with id: " + author.getId() + ", "
	                + e.getMessage());
	    }	
	}	
}
