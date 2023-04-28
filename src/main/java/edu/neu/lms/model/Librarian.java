package edu.neu.lms.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn
@Table(name="librarian")
public class Librarian extends User {
	
	public Librarian() {}

}
