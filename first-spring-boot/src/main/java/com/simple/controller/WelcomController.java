package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController {
	
	//Dependency 
	//WelcomeService service=new WelcomeService();
	@Autowired
	JdbcTemplateAutoConfiguration jdbc;
	
	
	@Autowired
	WelcomeService service;
	
	@RequestMapping("/welcome")
	public String welMethod() {
		return service.welService() ;
		
		
	}

}
@Service
//@Component
class WelcomeService{
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	public String welService() {
		//return " Welcome great start to execute first program of spring boot ";
		//complex Method
		return welcomeMessage;
	}
}
