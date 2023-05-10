package com.einfo.SmartInventoryManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.einfo.SmartInventoryManagement.Model.Order;
import com.einfo.SmartInventoryManagement.Services.OrderService;

@Controller
public class OrderController {

//	String MONGODB_CONNECTION_URL =
	
	@Autowired
	OrderService orderService;
	
//	@PostMapping("/orderData")
//	public String getorderdata(@RequestParam long productId,String productName,int productQuantity,String productPrice) {
//		return orderService.addorderdata(productId,productName,productQuantity,productPrice);
//	}
	
	@PostMapping("/data")
	public void processData(@RequestBody Order order) {
        System.out.println("Received message: " + order.toString());
        insertDataToMongoDB(order);
    }
	
	public void insertDataToMongoDB(Order order) {
		
	}
	
}
