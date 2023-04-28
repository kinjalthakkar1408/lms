package edu.neu.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String publisherName;
    
	public Publisher() {
	}

	public Publisher(Long id, String publisherName) {
		super();
		this.id = id;
		this.publisherName = publisherName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", publisherName=" + publisherName + "]";
	}

}
