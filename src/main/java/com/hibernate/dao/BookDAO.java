package com.hibernate.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Books;
import com.jps.repository.BooksRepository;

@Service
public class BookDAO  {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	private BooksRepository booksRepository;
	
	
	public int updateBooks(String bookName,String author) {
		int count = booksRepository.updateBooks(bookName, author);
		return count;
	}
	
	public Books getBooksById(int id) {
		return booksRepository.findById(id).get();
	}

	
	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
	}
	
	public void delete(int id) {
		booksRepository.deleteById(id);
	}
	
	public void update(Books books, int bookid) {
		booksRepository.save(books);
	}
	public List<Books> getBooksByAuthor(String author) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Books> cq = cb.createQuery(Books.class);
		Root<Books> root = cq.from(Books.class);
		cq.where(cb.equal(root.get("author"), author));
		TypedQuery<Books> q = em.createQuery(cq);
		List<Books> emps = q.getResultList();
		return emps;
	}
	@Transactional
    public void executeStoredProc2(String sender,String receiver,Integer amount){
        this.em.createNativeQuery("call moneytransfer('"+sender+"','"+receiver+"',"+ new BigDecimal(amount)+")").executeUpdate();
    }
	
	public void executeStoredProc(String sender,String receiver,Integer amount){
		booksRepository.executeStoredProc(sender, receiver, amount);
    }
	
	
}
