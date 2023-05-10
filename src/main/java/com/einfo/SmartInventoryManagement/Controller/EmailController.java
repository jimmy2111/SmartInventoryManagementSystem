package com.einfo.SmartInventoryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.einfo.SmartInventoryManagement.Model.Product;
import com.einfo.SmartInventoryManagement.Repo.BuyerRepo;
import com.einfo.SmartInventoryManagement.Services.BuyerServices;
import com.einfo.SmartInventoryManagement.Services.EmailService;

@Controller
@Component
@EnableScheduling
public class EmailController {

	@Autowired
	private EmailService emailServices;
	
	@Autowired
	private BuyerRepo buyerRepo;
	@Autowired
	private BuyerServices buyerService;
	
//	@Scheduled(fixedDelay =12*60*60*1000)
//	public void sendEmailForTime() {
//	List<Product> product=buyerRepo.findAll();
//	
//	emailServices.sendEmail("akshatgandhi1111@gmail.com", "all product", "product detail" + product);
//	
//	}
	
	@PostMapping("/sendMail")
	public ResponseEntity<String> sendEmail(){
		try {
		emailServices.sendEmail("akshatgandhi1111@gmail.com", "this is email body...", "email subject");
		return ResponseEntity.ok().body("sent..");
		}
		catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send email: " + e.getMessage());
		}
	}
}
