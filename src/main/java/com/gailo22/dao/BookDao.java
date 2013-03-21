package com.gailo22.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gailo22.domain.Book;

public class BookDao {

	private final EntityManager em;

	public BookDao(final EntityManager em) {
		this.em = em;
	}

	public void saveBook(final Book book) {
		this.em.getTransaction().begin();
		this.em.persist(book);
		this.em.getTransaction().commit();
	}

	public List<Book> getAllBooks() {
		this.em.getTransaction().begin();
		final Query query = this.em.createQuery("from Book");
		final List<Book> list = query.getResultList();
		this.em.getTransaction().commit();
		return list;
	}

}
