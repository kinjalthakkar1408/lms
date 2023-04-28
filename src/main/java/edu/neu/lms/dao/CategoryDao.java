package edu.neu.lms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.neu.lms.model.Category;
import javassist.NotFoundException;

@Repository
public class CategoryDao extends DAO{
	
	public CategoryDao() {
	}
	
	public Category get(long id) throws NotFoundException {

		try {
			// Fetch category object from the database based on id
			begin();
			Category category = getSession().get(Category.class, id);
			commit();
			close();

			return category;
		} catch (HibernateException e) {

			rollback();
			throw new NotFoundException("Exception while fetching category with id: " + id + ", " + e.getMessage());
		}

	}

	public Category create(Category category) throws NotFoundException {
		try {

			// save category object in the database
			begin();
			getSession().save(category);
			commit();
			close();

			return category;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while creating Category: " + e.getMessage());
		}
	}

	public void delete(Category category) throws NotFoundException {
		try {
			// save user object in the database
			begin();
			getSession().delete(category);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while deleting category: " + e.getMessage());
		}
	}

	public List<Category> list() throws NotFoundException {
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

	public Category update(Category category) throws NotFoundException {
		try {
	        // Update the existing category object in the database
	        begin();
	        getSession().update(category);
	        commit();
	        close();
	        return category; // Return the updated category object	
		} catch (HibernateException e) {
	        rollback();
	        throw new NotFoundException("Exception while updating category with id: " + category.getId() + ", "
	                + e.getMessage());
	    }	
	}	

}
