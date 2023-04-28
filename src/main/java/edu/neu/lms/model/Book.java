package edu.neu.lms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "books")
@JsonIgnoreProperties({"issuances"})
public class Book {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String description;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="book")
    private Set<Issuance> issuances = new HashSet<Issuance>();
    
    private boolean availability; 
    
    private int noOfcopies;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Set<Issuance> getIssuances() {
		return issuances;
	}

	public void setIssuances(Set<Issuance> issuances) {
		this.issuances = issuances;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public int getNoOfcopies() {
		return noOfcopies;
	}

	public void setNoOfcopies(int noOfcopies) {
		this.noOfcopies = noOfcopies;
	}

	public Book() {
	}

	public Book(Long id, String bookName, String isbn, String description, Author author, Publisher publisher,
			Category category, Set<Issuance> issuances , boolean availability , int noOfcopies) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.isbn = isbn;
		this.description = description;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		//this.issuances = issuances;
		this.availability = availability;
		this.noOfcopies = noOfcopies;
	}
//
//	@Override
//	public String toString() {
//		return "Book [id=" + id + ", bookName=" + bookName + ", isbn=" + isbn + ", description=" + description
//				+ ", author=" + author + ", publisher=" + publisher + ", category=" + category + ", issuances="
//				+ issuances + ", availability=" + availability + ", noOfcopies=" + noOfcopies + "]";
//	}

}
