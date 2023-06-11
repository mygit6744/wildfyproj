package com.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Books;
import com.hibernate.dao.BookDAO;

@Service
public class BooksService {

	@Autowired
	EntityManager em;
	@Autowired
	BookDAO bookDAO;

	public List<Books> getAllBooks() {
		List<Books> books = bookDAO.getAllBooks();
		return books;
	}

	public Books getBooksById(int id) {
		return bookDAO.getBooksById(id);
	}
	@Transactional
	public void delete(int id) {
		bookDAO.delete(id);
	}
	@Transactional
	public void update(Books books, int bookid) {
		bookDAO.update(books, bookid);
	}

	@Transactional
	public int updateBooks(String author, String bookName) {
		int updateCount = bookDAO.updateBooks(bookName, author);
		return updateCount;
	}

}