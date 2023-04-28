package edu.neu.lms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.neu.lms.model.Publisher;
import javassist.NotFoundException;

@Repository
public class PublisherDao extends DAO{
	
	public PublisherDao() {
	}

	public Publisher get(long id) throws NotFoundException {

		try {
			// Fetch publisher object from the database based on id
			begin();
			Publisher publisher = getSession().get(Publisher.class, id);
			commit();
			close();

			return publisher;
		} catch (HibernateException e) {

			rollback();
			// throw new AdException("Could not fetch publisher with id: " + id, e);
			throw new NotFoundException("Exception while fetching publisher with id: " + id + ", " + e.getMessage());
		}

	}

	public Publisher create(Publisher publisher) throws NotFoundException {
		try {

			// save publisher object in the database
			begin();
			getSession().save(publisher);
			commit();
			close();

			return publisher;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while creating publisher: " + e.getMessage());
		}
	}

	public void delete(Publisher publisher) throws NotFoundException {
		try {
			// save publisher object in the database
			begin();
			getSession().delete(publisher);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while deleting publisher: " + e.getMessage());
		}
	}

	public List<Publisher> list() throws NotFoundException {
		try {
			// Fetch all publisher objects from the database
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

	public Publisher update(Publisher publisher) throws NotFoundException {
		try {
	        // Update the existing publisher object in the database
	        begin();
	        getSession().update(publisher);
	        commit();
	        close();
	        return publisher; // Return the updated publisher object	
		} catch (HibernateException e) {
	        rollback();
	        throw new NotFoundException("Exception while updating publisher with id: " + publisher.getId() + ", "
	                + e.getMessage());
	    }	
	}	

}
