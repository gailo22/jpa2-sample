package com.gailo22.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {
	@Column(name = "isbn")
	@Id
	String isbn;

	@Column(name = "book_Name")
	String bookName;

	@Column(name = "publisher_code")
	String publisherCode;

	@Column(name = "publish_date")
	Date publishDate;

	@Column(name = "price")
	Long price;

	public Book(final String isbn, final String bookName, final String publisherCode, final Date publishDate,
			final Long price) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.publisherCode = publisherCode;
		this.publishDate = publishDate;
		this.price = price;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(final String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(final String bookName) {
		this.bookName = bookName;
	}

	public String getPublisherCode() {
		return this.publisherCode;
	}

	public void setPublisherCode(final String publisherCode) {
		this.publisherCode = publisherCode;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(final Date publishDate) {
		this.publishDate = publishDate;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(final Long price) {
		this.price = price;
	}
}
