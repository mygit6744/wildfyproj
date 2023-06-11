package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dto.Book;

public class BookMapper implements RowMapper<Book> {
	   public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Book student = new Book();
	      student.setBookid(rs.getInt("bookid"));
	      student.setBookname(rs.getString("bookname"));
	      student.setAuthor(rs.getString("author"));
	      student.setPrice(rs.getInt("price"));
	      return student;
	   }
	}
