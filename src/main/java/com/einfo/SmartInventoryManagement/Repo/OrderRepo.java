package com.einfo.SmartInventoryManagement.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einfo.SmartInventoryManagement.Model.Order;

public interface OrderRepo extends MongoRepository<Order, String>{

}
