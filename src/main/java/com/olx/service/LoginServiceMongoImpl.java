package com.olx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.olx.dto.AuthenticationRequest;
import com.olx.dto.User;
import com.olx.entity.BlackListDocument;
import com.olx.entity.UserDocument;
import com.olx.repo.BlackListMongoRepo;
import com.olx.repo.UserRegistrationMongoRepo;

@Service("MONGO_SERVICE")
public class LoginServiceMongoImpl implements LoginService {
	@Autowired
	 ModelMapper modelMapper;
	 @Autowired
	 MatserDataServiceDelegate masterDataDelegate;
	 @Autowired
	 UserRegistrationMongoRepo userRegisterMongoRepo;
	 @Autowired
	 BlackListMongoRepo blackListRepo;
	 
	 @Override
		public User registerUser(User user) {
			UserDocument userEntity = modelMapper.map(user, UserDocument.class);
			userRegisterMongoRepo.save(userEntity);
			User userData  = modelMapper.map(userEntity, User.class);
			return userData;
		}


		@Override
		public ResponseEntity<String> authenticateUser(AuthenticationRequest user) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public User getUserInfo(String authToken,String username) {
			UserDocument userEntiy = userRegisterMongoRepo.findByUsername(username);
			User userData =  modelMapper.map(userEntiy, User.class);
			return userData;
		}
		
		
		@Override
		public boolean logout(String authToken) {
			BlackListDocument blackList = new BlackListDocument();
			blackList.setAuthToken(authToken);
			blackListRepo.save(blackList);
			return false;
		}


		@SuppressWarnings("rawtypes")
		@Override
		public List<Map> getCategory() {
			List<Map> list = masterDataDelegate.getUserAdvertisment();
			return list;
		}


		@Override
		public boolean getBlackListToken(String authToken) {
			List<BlackListDocument> data = new ArrayList<>();
			data = blackListRepo.findAll();
			for(BlackListDocument blackListDocument : data) {
				if(blackListDocument.getAuthToken().equals(authToken)) {
					return true;
				}else {
					return false;
				}	
			}
			return false;
		}
}
