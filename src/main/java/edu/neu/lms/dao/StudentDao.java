package edu.neu.lms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.neu.lms.model.Student;
import javassist.NotFoundException;

@Repository
public class StudentDao extends DAO {
	
	public StudentDao() {
	}
	
	public Student get(long id) throws NotFoundException {

		try {
			// Fetch user object from the database based on id
			begin();
			Student student = getSession().get(Student.class, id);
			commit();
			close();

			return student;
		} catch (HibernateException e) {

			rollback();
			throw new NotFoundException("Exception while fetching author with id: " + id + ", " + e.getMessage());
		}

	}

	public Student create(Student student) throws NotFoundException {
		try {

			// save student object in the database
			begin();
			getSession().save(student);
			commit();
			close();

			return student;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while creating student: " + e.getMessage());
		}
	}

	public void delete(Student student) throws NotFoundException {
		try {
			// save student object in the database
			begin();
			getSession().delete(student);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while deleting student: " + e.getMessage());
		}
	}

	public List<Student> list() throws NotFoundException {
		try {
			// Fetch all student objects from the database
			begin();
			Query query = getSession().createQuery("from Student");
			List<Student> studentList = query.list();
			commit();
			close();

			return studentList;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException("Exception while getting student list: " + e.getMessage());
		}
	}

	public Student update(Student student) throws NotFoundException {
		try {
	        // Update the existing student object in the database
	        begin();
	        getSession().update(student);
	        commit();
	        close();
	        return student; // Return the updated student object	
		} catch (HibernateException e) {
	        rollback();
	        throw new NotFoundException("Exception while updating student with id: " + student.getId() + ", "
	                + e.getMessage());
	    }	
	}	
	

}
