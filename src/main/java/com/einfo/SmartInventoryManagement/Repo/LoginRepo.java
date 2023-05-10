package com.einfo.SmartInventoryManagement.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einfo.SmartInventoryManagement.Model.Login;

public interface LoginRepo extends MongoRepository<Login, String>{




}
