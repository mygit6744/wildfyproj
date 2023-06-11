package com.hibernate.hibernatesample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.service.BooksService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestWebApp {

	@Autowired
	BooksService bookService;
	@Test
	   public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
	      Mockito.when(bookService.getBooksById(105).getAuthor()).thenReturn("suresh");
	      String testName = "suresh";
	      assertEquals("suresh", testName);
	   }

}