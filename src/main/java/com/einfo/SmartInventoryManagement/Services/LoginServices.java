package com.einfo.SmartInventoryManagement.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einfo.SmartInventoryManagement.Model.Login;
import com.einfo.SmartInventoryManagement.Repo.LoginRepo;

@Service
public class LoginServices {

	@Autowired
	LoginRepo loginRepo;

	public boolean findByUserEmail(String email) {

//		List<Login> userEmail = loginRepo.findByUser_email(email);

		List<Login> users = loginRepo.findAll();
		for (Login i : users) {
			if (i.getUser_email().equals(email)) {
				return true;
			}
		}
		return false;
	}

	// Home Page
	public String gethomepage() {
		return "Login/Home";
	}

	// Logic for Register
	public String addData(String email, String username, String password) {
		if (!findByUserEmail(email)) {

			Login Signinto = new Login(email, username, password);
			loginRepo.save(Signinto);
			return "Login/Login";
		} else {
			return "Home2";
		}
	}

	// direct Login Page from Home page
	public String getLoginPage() {
		return "Login/Login";
	}

	// Logic for Login
	public String loginData(String email, String password) {
		List<Login> loginList = loginRepo.findAll();

			for (Login i : loginList) {
				if (i.getUser_email().equals(email) && i.getUser_password().equals(password) ) {
					return "buyer/HomePage";
				}
			}
			return "Login/Login";
			
		
	}

	// logic for about page
	public String getAboutpage() {
		return "Login/About";
	}

//	logic from Login page to Home page
	public String getHomePage() {
		return "Login/Home";
	}
}