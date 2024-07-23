package com.dot9.sbsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BankConfig {

	// Http security

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth-> auth
				.requestMatchers("/home").permitAll()
				.requestMatchers("/contact").permitAll()
				.requestMatchers("/deposit").hasRole("USER")
				.requestMatchers("/withdraw").hasRole("ADMIN")
				.requestMatchers("/balance").hasAnyRole("USER","ADMIN")
				.anyRequest().authenticated())
			.formLogin(formLogin ->formLogin
				//.loginPage("/login")
				.permitAll())
			.logout(logout ->logout
		            .logoutUrl("/logout")
		            .invalidateHttpSession(true)
		            .clearAuthentication(true)
		            .logoutSuccessUrl("/login?logout")
		            .permitAll())
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService getDetails() {
		return new BankUserDetailsService();
	}

	@Bean
	DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
		dap.setUserDetailsService(getDetails());
		dap.setPasswordEncoder(passwordEncoder());
		return dap;
	}

	// UserDetails
//	@Bean
//	UserDetailsService userDetailsService() {
//		
//		UserDetails anand = User.builder()
//				.username("anand")
//				.password(passwordEncoder().encode("anand123"))
//				.roles("user")
//				.build();
//		
//		UserDetails krithika= User.builder()
//				.username("krithika")
//				.password(passwordEncoder().encode("krithika123"))
//				.roles("user")
//				.build();
//
//		UserDetails yuvaraj= User.builder()
//				.username("yuvaraj")
//				.password(passwordEncoder().encode("yuvaraj123"))
//				.roles("user")
//				.build();
//	
//		UserDetails ram= User.builder()
//				.username("ram")
//				.password(passwordEncoder().encode("ram123"))
//				.roles("admin")
//				.build();
//
//		return new InMemoryUserDetailsManager(anand,krithika,yuvaraj,ram);
//	}

}
