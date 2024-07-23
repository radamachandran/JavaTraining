package com.dot9.sbsecurity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BankUserDetails implements UserDetails {

	BankUser user;

	public BankUserDetails(BankUser user) {
	    this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority auth=new SimpleGrantedAuthority(user.getRoles());
		return Arrays.asList(auth);
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
			return user.getUsername();
	}

}
