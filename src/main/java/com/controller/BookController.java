package com.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Books;
import com.exception.BookNotFoundException;
import com.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	
	@GetMapping("/bookss")
	   public List<Books> getBooks(){
		System.out.println("hi>>>>>>");
		
		return bookService.getBooks();
	   }
	
	@GetMapping("/bookid/{id}")
	   public Optional<Books> getBooksById(@PathVariable("id") Integer id){
		System.out.println("hi>>>>>>");
		
		return bookService.findById(id);
	   }
	
	@GetMapping("/book/{id}")
	public Optional<Books> getBook(@PathVariable("id") Integer id) {
	  Optional<Books> book = bookService.findById(id);
	  if ( book.isEmpty()) {
	    throw new BookNotFoundException(
	        "Book not found, bookid: " + id);
	  }
	  return book;
	}
	
	@PutMapping("/saveBook")
	public ResponseEntity<Books> postStudent(
	    @RequestBody Books book) {
		System.out.println("hhhhhhhhhh");
	  Books bookk = bookService.save(book);
	  return new ResponseEntity<>(bookk, HttpStatus.CREATED);
	}
	@PutMapping("/updateBooks/{id}")
    public ResponseEntity<Books> updateUser(@PathVariable Integer id,
                                           @RequestBody Books userDetails) {
		Books book = bookService.findById(id)
                .orElseThrow(() -> new BookNotFoundException
                        ("User not exist with id :" + id));
		book.setAuthor(userDetails.getAuthor());
		book.setBookname(userDetails.getBookname());
		book.setPrice(userDetails.getPrice());
        Books updatedUser = bookService.save(book);
        return ResponseEntity.ok(updatedUser);
    }
	
	@PatchMapping("/updateBooks/{id}/{name}")
	public ResponseEntity<Books> updateBooks(@PathVariable Integer id, @PathVariable String name) {
		try {
			Books book = bookService.findById(id).get();
			book.setBookname(name);
			return new ResponseEntity<Books>(bookService.save(book), HttpStatus.OK);
		} catch (Exception e) { 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/transferMoney/{sender}/{receiver}/{amount}")
	public ResponseEntity<String> transferMoney(@PathVariable String sender, 
			@PathVariable String receiver,
			@PathVariable BigDecimal amount) {
		String status = "";
		try {
			System.out.println("transfering.. money>>>>>");
			status = bookService.moneyTransfer(sender, receiver, amount);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
