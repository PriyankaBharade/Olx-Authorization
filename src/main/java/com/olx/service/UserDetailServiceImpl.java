package com.olx.service;

import com.olx.entity.UserDocument;
import com.olx.entity.UserEntity;
import com.olx.repo.UserRegistrationMongoRepo;
import com.olx.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	    @Autowired
	    PasswordEncoder passwordEncoder;
	   // @Autowired
	   // UserRepository userRepository;
	     @Autowired
	     UserRegistrationMongoRepo userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	        UserDocument userDocument = userRepository.findByUsername(username);
	        if (userDocument == null) {
	            throw new UsernameNotFoundException("User not found.");
	        }

	        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
	        grantedAuthorityList.add(new SimpleGrantedAuthority(userDocument.getRoles()));
	        return new User(userDocument.getUsername(), passwordEncoder.encode(userDocument.getPassword()), grantedAuthorityList);
	    }
	    
	    @Bean
		  public PasswordEncoder getPasswordEncoder() { return
		 PasswordEncoderFactories.createDelegatingPasswordEncoder(); }
		 

}
