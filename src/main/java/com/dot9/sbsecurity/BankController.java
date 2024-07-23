package com.dot9.sbsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

	@GetMapping("/home")
	public String home() {
		return "Welcome to Java International Bank";
	}
	
	@GetMapping("/deposit")
	public String deposit() {
		return "You have deposited Rs. 2 Lakhs successfully";
	}
	
	@GetMapping("/withdraw")
	public String withdraw() {
		return "you have withdrawn Rs. 1 Lakh successfuly";
	}
	
	@GetMapping("/balance")
	public String balance() {
		return "Your current Account balance is Rs. 10 Lakhs";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "Thanks for contact us";
	}

}
