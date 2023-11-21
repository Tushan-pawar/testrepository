package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.AccountDetails;
import com.springboot.main.service.AccountDetailsService;

@RestController
@RequestMapping("/AccountDetails")
public class AccountDetailsController {
	@Autowired
	private AccountDetailsService accountDetailsService;
	
	@PostMapping("/insert")
	public AccountDetails insert(@RequestBody AccountDetails accountDetails) {
		return accountDetailsService.save(accountDetails);

	}
   
}