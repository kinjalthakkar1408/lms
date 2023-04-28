package edu.neu.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String authorName;
    
    @Column(nullable = false)
    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Author() {

	}
	
	public Author(Long id, String authorName, String description) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", authorName=" + authorName + ", description=" + description + "]";
	}
 

}
