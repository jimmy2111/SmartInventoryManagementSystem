package com.einfo.SmartInventoryManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.einfo.SmartInventoryManagement.Services.LoginServices;

@Controller
public class LoginController {

	@Autowired
	LoginServices loginservice;
	
	@PostMapping("/insertData")
	public String insertData(@RequestParam String username,String email,String password) {
		return loginservice.addData(email,username,password);
	}

	
	
	@PostMapping("/LoginData")
	public String loginData(@RequestParam String email,String password) {
		
		
		return loginservice.loginData(email,password);
				
	}
}
