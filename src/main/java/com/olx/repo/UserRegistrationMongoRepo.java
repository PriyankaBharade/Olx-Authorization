package com.olx.repo;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.olx.entity.UserDocument;

public interface UserRegistrationMongoRepo extends MongoRepository<UserDocument,Integer>{
	UserDocument findByUsername(String username);
}
