package com.jps.repository;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dto.Book;
import com.jdbc.BookMapper;

@Repository
public class JdbcBookRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Book> findAll() {
		return jdbcTemplate.query("select * from books", new BookMapper());
	}

	public List<Book> findById(Integer id) {
		System.out.println("in repo" + id);
		List<Book> books = jdbcTemplate.query("select * from books where bookid = ?", new BookMapper(),
				new Object[] { id });

		return books;

	}

	public int save(Book book) {
		return jdbcTemplate.update("insert into books (bookid,bookname, author,price) values(?,?,?,?)",
				book.getBookid(), book.getBookname(), book.getAuthor(), book.getPrice());
	}
	
	public String executeStoreProc(String sender,String receiver,BigDecimal amount) throws SQLException {
		System.out.println("executeStoreProc>>>>>start:" + sender + receiver + amount);
		Connection con = null;
		BigDecimal status = null;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			CallableStatement proc = con.prepareCall("call transfer( ? ,?,?,?)");
			proc.setString(1, sender);
			proc.setString(2, receiver);
			proc.setBigDecimal(3, amount);
			proc.registerOutParameter(4, java.sql.Types.DECIMAL);
			proc.execute();
			status = proc.getBigDecimal(4);
			
		} catch (Exception e) {
e.printStackTrace();		}
		finally {
			con.close();
		}
		
		System.out.println("executeStoreProc>>>>>end");
		return "Amount '" + status + "' has been transferred Successfully to '" + receiver + "'";
	}

}
