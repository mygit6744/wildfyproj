package com.injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.injection")
public class AppConfig {
	
	 // Creating the Bean for Principal Class
	@Bean public Principal principalBean()
    {
        return new Principal();
    }
    
	@Bean public College collegeBean()
    {
        return new College(principalBean());
    }
// College x = new College();
	//x.test();
}
