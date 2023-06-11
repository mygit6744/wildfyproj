package com.injection;


import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class MyJunit {

	public String message = "Guru99";							

    JUnitMessage junitMessage = new JUnitMessage(message);							

    @Ignore		
    @Test		
    public void testJUnitMessage() {					

        System.out.println("Junit Message is printing ");					
        assertEquals(message, junitMessage.printMessage());					

    }		

    @Test		
    public void testJUnitHiMessage() {					
        message="Hi!" +message;							
        System.out.println("Junit Hi Message is printing ");					
        assertEquals(message, junitMessage.printHiMessage());					

    }	
}
