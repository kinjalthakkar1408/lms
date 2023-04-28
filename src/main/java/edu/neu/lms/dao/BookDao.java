package edu.neu.lms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.neu.lms.model.Author;
import edu.neu.lms.model.Book;
import edu.neu.lms.model.Category;
import edu.neu.lms.model.Publisher;
import javassist.NotFoundException;

@Repository
public class BookDao extends DAO {
	
	public BookDao() {
	}

	public Book get(long id) throws NotFoundException {

		try {
			// Fetch book object from the database based on id
			begin();
			Book book = getSession().get(Book.class, id);
			commit();
			close();

			return book;
		} catch (HibernateException e) {

			rollback();
			throw new NotFoundException("Exception while fetching book with id: " + id + ", " + e.getMessage());
		}

	}

	public Book create(Book book) throws NotFoundException {
		try {

			// save book object in the database
			begin();
			getSession().save(book);
			commit();
			close();

			return book;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while creating book: " + e.getMessage());
		}
	}

	public void delete(Book book) throws NotFoundException {
		try {
			// save book object in the database
			begin();
			getSession().delete(book);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while deleting book: " + e.getMessage());
		}
	}

	public List<Book> list() throws NotFoundException {
		try {
			// Fetch all book objects from the database
			begin();
			Query query = getSession().createQuery("from Book");
			List<Book> bookList = query.list();
			commit();
			close();

			return bookList;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while getting book list: " + e.getMessage());
		}
	}

	public Book update(Book book) throws NotFoundException {
		try {
	        // Update the existing author object in the database
	        begin();
	        getSession().update(book);
	        commit();
	        close();
	        return book; // Return the updated book object	
		} catch (HibernateException e) {
	        rollback();
	        throw new NotFoundException("Exception while updating book with id: " + book.getId() + ", "
	                + e.getMessage());
	    }	
	}
	
	public void deleteBookById(int bookId) throws NotFoundException {
	    try {
	        // Fetch the book object with the given ID
	        Book book = getSession().load(Book.class, bookId);
	        if (book != null) {
	            // delete the author object from the database
	            begin();
	            getSession().delete(book);
	            commit();
	        }
	    } catch (HibernateException e) {
	        rollback();
	        throw new NotFoundException("Exception while deleting author with ID " + bookId + ": " + e.getMessage());
	    }
	}
	
	public List<Author> listAuthors() throws NotFoundException {
		try {
			// Fetch all book objects from the database
			begin();
			Query query = getSession().createQuery("from Author");
			List<Author> authorList = query.list();
			commit();
			close();

			return authorList;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while getting book list: " + e.getMessage());
		}
	}
	
	public List<Publisher> listPublisher() throws NotFoundException {
		try {
			// Fetch all book publisher from the database
			begin();
			Query query = getSession().createQuery("from Publisher");
			List<Publisher> publisherList = query.list();
			commit();
			close();

			return publisherList;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while getting publisher list: " + e.getMessage());
		}
	}
	public List<Category> listCategory() throws NotFoundException {
		try {
			// Fetch all category objects from the database
			begin();
			Query query = getSession().createQuery("from Category");
			List<Category> categoryList = query.list();
			commit();
			close();

			return categoryList;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while getting category list: " + e.getMessage());
		}
	}
	
	
}
