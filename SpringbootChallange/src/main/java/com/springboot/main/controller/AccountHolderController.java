package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.AccountHolder;
import com.springboot.main.service.AccountHolderService;

@RestController
@RequestMapping("/account_holders")
public class AccountHolderController {

	@Autowired
	private AccountHolderService accountHolderService;
	

	
	@PostMapping("/insert")
	public AccountHolder insert(@RequestBody AccountHolder accountHolder) {
		return accountHolderService.createAccountHolder(accountHolder);
	}
	
	
}
