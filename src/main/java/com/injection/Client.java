package com.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {

		 String message = "Hi, good morning have a nice day!.";
		 ApplicationContext context
         = new AnnotationConfigApplicationContext(
        		 AppConfig.class);

     // Getting the bean
     College college
         = context.getBean("collegeBean", College.class);

     // Invoking the method
     // inside main() method
     college.test();
	}

}
