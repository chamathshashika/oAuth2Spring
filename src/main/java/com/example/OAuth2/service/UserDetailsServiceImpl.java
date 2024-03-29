package com.example.OAuth2.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.OAuth2.model.User;
import com.example.OAuth2.model.AuthUserDetail;
import com.example.OAuth2.repository.UserDetailRepository;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		Optional<User> optionalUser = userDetailRepository.findByUsername(name);

	 optionalUser.orElseThrow( ()-> new UsernameNotFoundException("Username or Password wrong"));
	 
	 
	 UserDetails userDetails = new AuthUserDetail(optionalUser.get());
	 
	 new AccountStatusUserDetailsChecker().check(userDetails);
	 
	 return userDetails;
	 
	}

}
