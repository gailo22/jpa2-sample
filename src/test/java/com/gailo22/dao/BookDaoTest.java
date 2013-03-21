package com.gailo22.dao;


import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gailo22.domain.Book;
import com.gailo22.util.SessionManager;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class BookDaoTest {

	private static final String ISBN_1 = "PBN123";

	private static final String ISBN_2 = "PBN456";

	private static final String TITLE_1 = "Spring Recipes";

	private static final String TITLE_2 = "Hibernate Recipes";

	private static final String PUBLISHER_CODE_1 = "001";

	private static final String PUBLISHER_CODE_2 = "002";

	private static final Date PUBLISHER_DATE_1 = new GregorianCalendar(2008, GregorianCalendar.FEBRUARY, 2).getTime();

	private static final Date PUBLISHER_DATE_2 = new GregorianCalendar(2008, GregorianCalendar.NOVEMBER, 2).getTime();

	private static final Long PRICE_1 = new Long(30);

	private static final Long PRICE_2 = new Long(40);

	private BookDao bookDAO;

	@Before
	public void createSampleBooks() {
		this.bookDAO = new BookDao(SessionManager.getEntityManager());
		final Book book1 = new Book(ISBN_1, TITLE_1, PUBLISHER_CODE_1, PUBLISHER_DATE_1, PRICE_1);
		this.bookDAO.saveBook(book1);
		final Book book2 = new Book(ISBN_2, TITLE_2, PUBLISHER_CODE_2, PUBLISHER_DATE_2, PRICE_2);
		this.bookDAO.saveBook(book2);
	}

	@Test
	public void getAllBooksFromDatabase() {
		final List<Book> list = this.bookDAO.getAllBooks();
		assertThat("Number of books", list.size(), is(equalTo(2)));
	}
}
