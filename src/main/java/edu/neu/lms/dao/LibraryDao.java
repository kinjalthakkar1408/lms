package edu.neu.lms.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import edu.neu.lms.model.Issuance;
import edu.neu.lms.model.Library;
import javassist.NotFoundException;

@Repository
public class LibraryDao extends DAO {
	

	public LibraryDao() {
	}

	public Library getLibraryById(long libraryId) throws NotFoundException {
		try {
			// Fetch Menu object from the database based on menuId
			begin();
			Library library = getSession().get(Library.class, libraryId);
			commit();
			close();
			return library;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while fetching library with id: " + libraryId + ", " + e.getMessage());
		}
	}

	public Library createLibrary(Library library) throws NotFoundException {
		try {
			// Save library object in the database
			begin();
			getSession().save(library);
			commit();
			close();
			return library;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while creating Library: " + e.getMessage());
		}
	}

	public boolean addIssuance(Issuance issuance) throws NotFoundException {
		try {
			// Save MenuItem object in the database
			begin();
			Library library = getSession().get(Library.class, (long) 1);
			
			if (library == null) {
				throw new NotFoundException("Library not found with id: 1");
			}

			library.getIssuances().add(issuance);
			getSession().update(library);
			commit();
			close();
			return true;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while creating library: " + e.getMessage());
		}
	}
	
	public Set<Issuance> getIssuances(long id) throws NotFoundException{
		try {
			// Fetch Menu object from the database based on menuId
			begin();
			Library library = getSession().get(Library.class, id);
			Set<Issuance> ls = library.getIssuances();
			commit();
			close();
			return ls;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while fetching library with id: " + id + ", " + e.getMessage());
		}
	}

}
