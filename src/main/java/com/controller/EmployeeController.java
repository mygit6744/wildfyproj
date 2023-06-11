package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Address;
import com.entity.Books;
import com.entity.Department;
import com.entity.Employees;
import com.exception.ProductNotfoundException;
import com.service.BooksService;
import com.service.EmployeeService;

@RestController
@Validated
public class EmployeeController {
	
	@Autowired
	BooksService bookService;
	
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/books")
	   public List<Books> getBooks(){
		System.out.println("hi>>>>>>");
		return bookService.getAllBooks();
	   }
	
	@GetMapping("/fetchemps")
	   public List<Employees> getEmployeesByDept(@RequestHeader(value = HttpHeaders.ACCEPT_LANGUAGE, 
	            defaultValue = "en") String language){
		System.out.println("language:" + language);
		return employeeService.getEmployeesByDept();
	   }
	
	@GetMapping("/updateBooks/{author}/{bookName}")
	   public int updateBooks(@PathVariable("author") String author,
			   @PathVariable("bookName") String bookName){
		System.out.println("author:" + author);
		return bookService.updateBooks(author,bookName);
	   }
	
	
	 @GetMapping("/print-all-headers")
	    public void getAllheaders(@RequestHeader Map<String,String> headers){
	        headers.forEach((key,value) ->{
	        	System.out.println(key+":"+value);
	        });
	    }
	
	 @GetMapping(path = "/fetchdeps", produces = {MediaType.APPLICATION_JSON_VALUE})
	   public List<Department> getDepartments(){
		System.out.println("hi>>>>>>");
		return employeeService.getDepartments();
	   }

	@GetMapping("/fetchdep/{age}")
	   public List<Employees> getEmployeesByAge(@PathVariable("age") @Min(35) Integer age){
		 System.out.println("-->>>>--"+age);
		return employeeService.getDepartment(age);
	   }
	
	@GetMapping("/save")
	   public void saveEmp(){
		 System.out.println("-->>>>--");
		 List<Address> address = getAddress();
		 Employees emps = getEmployee();
	       emps.setAddress(address);
	       employeeService.saveOrUpdate(emps);
	   }
	
	private static Employees getEmployee() {

		Employees emp = new Employees();
		emp.setEmpid(125);
		emp.setEmpname("peterburgh");
		emp.setCity("New York");
		emp.setAge(25);
		
		return emp;
	}
	
	private static List<Address> getAddress() {
		
		List<Address> deps = new ArrayList<>();
		Address dep = new Address();
		dep.setAddressid(125);
		dep.setColony("see colony");
		dep.setCity("kondapur");
		dep.setPincode(501059);
		deps.add(dep);
		
		Address dep2 = new Address();
		dep2.setAddressid(126);
		dep2.setColony("Ayyappa colony");
		dep2.setCity("madhapur");
		dep2.setPincode(502059);
		deps.add(dep2);
		
	
		
		
		return deps;
	}
	
	@GetMapping("/fetchemployees")
	   public List<Employees> fetchemployees(){
		System.out.println("hi>>>>>>");
		return employeeService.fetchemployees();
	   }

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> updateProduct() { 
	   throw new ProductNotfoundException("No Product Available");
	}
	
	@RequestMapping(value = "/fetchdepskk/{age}", method = RequestMethod.PUT)
	   public List<Employees> fetchdep(@PathVariable("age") Integer age){
		 System.out.println("-->>>>--"+age);
		return employeeService.getDepartment(age);
	   }
}
