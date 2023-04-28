package edu.neu.lms.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import edu.neu.lms.model.Issuance;
import edu.neu.lms.model.Student;
import javassist.NotFoundException;

@Repository
public class IssuanceDao extends DAO {

	public IssuanceDao() {
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

	public Issuance create(Issuance issuance) throws NotFoundException {
		try {

			// save student object in the database
			begin();
			getSession().save(issuance);
			commit();
			close();

			return issuance;
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

	public List<Issuance> list() throws NotFoundException {
		try {
			// Fetch all student objects from the database
			begin();
			Query query = getSession().createQuery("from Issuance");
			List<Issuance> studentList = query.list();
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
			throw new NotFoundException(
					"Exception while updating student with id: " + student.getId() + ", " + e.getMessage());
		}
	}

	public Set<Issuance> getIssuancesByStudent(long studentId) throws NotFoundException {
		try {
			// Fetch student object from the database based on studentId
			begin();
			Student student = getSession().get(Student.class, studentId);

			Set<Issuance> issuances = new HashSet<>();

			// Iterate through all the issuances in the library and check if the student id
			// matches
			for (Issuance issuance : student.getIssuances()) {
				if (issuance.getStudent().getId() == studentId) {
					issuances.add(issuance);
				}
			}

			commit();
			close();

			return issuances;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException(
					"Exception while fetching issuances for student with id: " + studentId + ", " + e.getMessage());
		}
	}

	public List<Issuance> getIssuancesForUser(long userId) throws NotFoundException {
		try {
			begin();
			Query query = getSession().createQuery("from Issuance where student_id = :userId");
			query.setParameter("userId", userId);
			List<Issuance> issuances = query.list();
			commit();
			close();
			return issuances;
		} catch (HibernateException e) {
			rollback();
			throw new NotFoundException(
					"Exception while fetching issuances for user with id: " + userId + ", " + e.getMessage());
		}
	}
	
}
