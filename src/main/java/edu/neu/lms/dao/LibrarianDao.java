package edu.neu.lms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.neu.lms.model.Librarian;
import javassist.NotFoundException;


@Repository
public class LibrarianDao extends DAO{
	
	public LibrarianDao() {}
	

	public Librarian get(long id) throws NotFoundException {

		try {
			// Fetch librarian object from the database based on id
			begin();
			Librarian librarian = getSession().get(Librarian.class, id);
			commit();
			close();

			return librarian;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while fetching librarian with id: " + id + ", " + e.getMessage());
		}

	}

	public Librarian create(Librarian librarian) throws NotFoundException {
		try {

			// save librarian object in the database
			begin();
			getSession().save(librarian);
			commit();
			close();

			return librarian;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while creating librarian: " + e.getMessage());
		}
	}

	public void delete(Librarian librarian) throws NotFoundException {
		try {
			// save librarian object in the database
			begin();
			getSession().delete(librarian);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while deleting librarian: " + e.getMessage());
		}
	}

	public List<Librarian> list() throws NotFoundException {
		try {
			// Fetch all librarian objects from the database
			begin();
			Query query = getSession().createQuery("from Librarian");
			List<Librarian> librarianList = query.list();
			commit();
			close();

			return librarianList;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while getting librarian list: " + e.getMessage());
		}
	}

	public Librarian update(Librarian librarian) throws NotFoundException {
		try {
	        // Update the existing librarian object in the database
	        begin();
	        getSession().update(librarian);
	        commit();
	        close();
	        return librarian; // Return the updated librarian object	
		} catch (HibernateException e) {
	        rollback();
	        throw new NotFoundException("Exception while updating librarian with id: " + librarian.getId() + ", "
	                + e.getMessage());
	    }	
	}	 

}
