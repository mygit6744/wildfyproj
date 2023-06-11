package com.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Books;
import com.hibernate.dao.BookDAO;
import com.jps.repository.BooksRepository;
import com.jps.repository.JdbcBookRepository;

@Service
public class BookService {
	@Autowired
	BooksRepository bookRepository;
	
	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	JdbcBookRepository jdbcBookRepository;
	
	   public List<Books> getBooks(){
		System.out.println("hi>>>>>>");
		
		return bookRepository.findAll();
	   }
	   
	   public Optional<Books> findById(Integer id) {
		   return bookRepository.findById(id);
	   }

	public Books save(Books book) {
		return bookRepository.save(book);
	}
	
	
	public String moneyTransfer(String sender, String receiver, BigDecimal amount) throws SQLException {

		return jdbcBookRepository.executeStoreProc(sender, receiver, amount);
	}
}
