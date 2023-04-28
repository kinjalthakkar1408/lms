package edu.neu.lms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.neu.lms.enumTypes.Course;
import edu.neu.lms.enumTypes.Department;

@Entity
@PrimaryKeyJoinColumn
@Table(name="students")
@JsonIgnoreProperties("issuances")
public class Student extends User {
	
    @Column(nullable = false, unique = true)
    private String studentId;
    
    @Column(nullable = false)
    private Date dateOfBirth;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Course course;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Department department;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="student")
    private Set<Issuance> issuances = new HashSet<Issuance>();
    
	public Student() {
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", dateOfBirth=" + dateOfBirth + ", course=" + course
				+ ", department=" + department + "]";
	}
	
	public Set<Issuance> getIssuances() {
		return issuances;
	}

	public void setIssuances(Set<Issuance> issuances) {
		this.issuances = issuances;
	}

	

}
