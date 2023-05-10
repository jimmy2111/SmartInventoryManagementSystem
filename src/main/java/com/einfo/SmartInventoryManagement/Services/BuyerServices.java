package com.einfo.SmartInventoryManagement.Services;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.einfo.SmartInventoryManagement.Logger.LoggerImplementation;
import com.einfo.SmartInventoryManagement.Model.Product;
import com.einfo.SmartInventoryManagement.Model.Sender;
import com.einfo.SmartInventoryManagement.Repo.BuyerRepo;
import com.einfo.SmartInventoryManagement.Repo.LoginRepo;
import com.einfo.SmartInventoryManagement.Repo.SenderRepo;

@Service
public class BuyerServices {
	private Logger logger=LoggerImplementation.getLogger(BuyerServices.class);
	
	@Autowired
	BuyerRepo buyerRepo;

	@Autowired
	LoginRepo loginRepo;
	
	@Autowired
	SenderRepo senderRepo;
	
	public String getBuyerServices() {
		return "buyer/HomePage";
	}

	public String getBuyerAboutpage() {
		return "buyer/About1";
	}
	

	public String getAddProductPage() {
		return "buyer/AddProduct";
	}

	public String getAddProduct(Integer product_Id, String product_name, String desc, Integer quantity, Integer threshold,
			String price) {
		String methodname="getAddProduct";
		logger.info(methodname+"Called");
		
		
		Product buyer=new Product(product_Id,product_name,desc,quantity,threshold,price);
		buyerRepo.save(buyer);
		return "buyer/HomePage2";
	}

	public ModelAndView getproductdata() {
		String methodname="getproductdata";
		logger.info(methodname+ " Called ");
		
		ModelAndView mv=new ModelAndView("buyer/viewProduct");
		List<Product> buyer= buyerRepo.findAll();
		mv.addObject("viewproduct", buyer);
		return mv;
	}
	
	

	public ModelAndView getsellerdetail() {
		ModelAndView mv=new ModelAndView("buyer/viewSeller");
		List<Sender> sender=senderRepo.findAll();
		mv.addObject("viewsellerdetail", sender);
		return mv;
	}

	public String getsenderdetailpage() {
		return "buyer/AddSellerDetail";
	}
	
	public String getaddsenderdetail(String sender_name, String shop_name, String address, String contact) {
		Sender sender=new Sender(sender_name,shop_name,address,contact);
		senderRepo.save(sender);
		return "buyer/HomePage";
	}

	public String getorderhere() {
		return "buyer/Order";
	}

	public Product getProductById(Integer Id) {
		return buyerRepo.findById(Id).orElse(null);
		}

}

