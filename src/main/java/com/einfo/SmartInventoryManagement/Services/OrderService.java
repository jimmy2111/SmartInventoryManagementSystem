package com.einfo.SmartInventoryManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einfo.SmartInventoryManagement.Model.Order;
import com.einfo.SmartInventoryManagement.Model.Product;
import com.einfo.SmartInventoryManagement.Repo.BuyerRepo;
import com.einfo.SmartInventoryManagement.Repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private BuyerRepo buyerRepo;
	
	
//	public String addorderdata(long productId, String productName, int productQuantity, String productPrice) {
//		Order order=new Order(productId,productName,productQuantity,productPrice);
//		orderRepo.save(order);
//		
//		return "buyer/Order";
//	}
	
	
}
