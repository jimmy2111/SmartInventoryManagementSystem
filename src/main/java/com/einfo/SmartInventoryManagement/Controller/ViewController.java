package com.einfo.SmartInventoryManagement.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.einfo.SmartInventoryManagement.Services.BuyerServices;
import com.einfo.SmartInventoryManagement.Services.LoginServices;

@Controller

public class ViewController {

	@Autowired
	LoginServices loginServices;
	
	@Autowired
	BuyerServices buyerServices;
	
//	home page and login page for all
	@RequestMapping("/")
	public String gethomepage() {
		return "buyer/HomePage";
	}
//	@GetMapping
//	public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
//		return oAuth2AuthenticationToken.getPrincipal().getAttributes();
//	}
	
	@RequestMapping("/login")
	public String getLoginPage() {
		return loginServices.getLoginPage();
	}
	
	@RequestMapping("/About")
	public String getAboutPage() {
		return loginServices.getAboutpage();
	}
	
	@RequestMapping("/Home")
	public String getHomePage() {
		return loginServices.gethomepage();
	}
// Buyer side pages	
	
	@RequestMapping("/BuyerHome")
	public String getbuyerService() {
		return buyerServices.getBuyerServices();
	}
	@RequestMapping("/BuyerAbout")
	public String getBuyerAboutPage() {
		return buyerServices.getBuyerAboutpage();
	}
	
	@RequestMapping("/AddProductPage")
	public String getAddProductPage() {
		return buyerServices.getAddProductPage();
	}
	
	@RequestMapping("/OrderHere")
	public String getorderhere() {
		return buyerServices.getorderhere();
	}
	
}