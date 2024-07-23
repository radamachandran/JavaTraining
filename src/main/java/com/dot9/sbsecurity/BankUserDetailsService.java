package com.dot9.sbsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BankUserDetailsService implements UserDetailsService {

	@Autowired
	BankRepo bankRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BankUser user = bankRepo.findByUsername(username);
		return new BankUserDetails(user);
	}

}
