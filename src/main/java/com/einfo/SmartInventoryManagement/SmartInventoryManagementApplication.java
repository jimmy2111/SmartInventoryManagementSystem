package com.einfo.SmartInventoryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.einfo.SmartInventoryManagement.Services.EmailService;

@SpringBootApplication
public class SmartInventoryManagementApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SmartInventoryManagementApplication.class, args);
		
		
	}

}
