package com.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
	
	private EmailService emailService;

    private SMSService smsService;
	
    
    @Autowired
    public void setMessageService(EmailService emailService) {
        this.emailService = emailService;
        System.out.println("setter based dependency injection 1");
    }

    @Autowired
    public void setSmsService(SMSService smsService) {
        this.smsService = smsService;
        System.out.println("setter based dependency injection 2");
    }
    
    //@Autowired
	/*
	 * public OrderService(EmailService emailService){ this.emailService =
	 * emailService; System.out.println("constructor based dependency injection 1");
	 * }
	 * 
	 * @Autowired public OrderService(EmailService emailService,SMSService
	 * smsService){ this.emailService = emailService; this.smsService = smsService;
	 * System.out.println("constructor based dependency injection 2"); }
	 */


    public void sendMessage(String message){
        this.emailService.sendMessage(message);
        this.smsService.sendMessage(message);
    }

}
