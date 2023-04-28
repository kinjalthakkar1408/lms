package edu.neu.lms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Issuance> issuances = new HashSet<Issuance>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Issuance> getIssuances() {
		return issuances;
	}

	public void setIssuances(Set<Issuance> issuances) {
		this.issuances = issuances;
	}

	public Library() {

	}

	public Library(String name) {
		this.name = name;
	}

}
