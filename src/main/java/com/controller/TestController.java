package com.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/api/foos")
	@ResponseBody
	public String getFoos(@RequestParam List<String> id) {
	    return "IDs are " + id;
	}
	
	@PostMapping("/api/foos")
	@ResponseBody
	public String updateFoos(@RequestParam Map<String,String> allParams) {
	    return "Parameters are " + allParams.entrySet();
	}
	
	@GetMapping("/api/fooss")
	@ResponseBody
	public String getFoos(@RequestParam(defaultValue = "test") String id) {
	    return "ID: " + id;
	}
	
	@GetMapping("/api/foosop")
	@ResponseBody
	public String getFoos(@RequestParam Optional<String> id){
	    return "ID: " + id.orElseGet(() -> "not provided");
	}
	
	@GetMapping("/hello")
	ResponseEntity<String> hello() {
	    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	@GetMapping("/customHeader")
	ResponseEntity<String> customHeader() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Custom-Header", "foo");
	    headers.add("token", "IHLIL789#%$#^%kjhk");
	        
	    return new ResponseEntity<>(
	      "Custom header set", headers, HttpStatus.OK);
	}
	
	@GetMapping("/hellos")
	ResponseEntity<String> hellos() {
	    return ResponseEntity.ok("Hello World!");
	}
	
	@GetMapping("/testing")
	ResponseEntity<String> testing() {
	    return ResponseEntity.ok("Hello World testing!");
	}
	
	@GetMapping("/testJenkins")
	ResponseEntity<String> testJenkins() {
	    return ResponseEntity.ok("Hello World testing Jenkin!");
	}


}
