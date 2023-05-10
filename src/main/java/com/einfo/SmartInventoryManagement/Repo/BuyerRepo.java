package com.einfo.SmartInventoryManagement.Repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.einfo.SmartInventoryManagement.Model.Product;
@Repository
public interface BuyerRepo extends MongoRepository<Product, Integer> {

	Page<Product> findAll(Pageable pageable);

	Page<Product> findByProductname(String productname,Pageable pageable);


	Product findByProductId(int productId);


}