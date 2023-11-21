package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.BankExecutive;
import com.springboot.main.model.User;
import com.springboot.main.service.BankExecutiveService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/BankExecutive")
public class BankExecutiveController {
	@Autowired
	private BankExecutiveService bankExecutiveService;

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public BankExecutive insert(@RequestBody BankExecutive bankExecutive) {
		User user = bankExecutive.getUser();
		user.setRole("EXECUTIVE");
		bankExecutive.setUser(user);
		user = userService.insert(user);
		return bankExecutiveService.save(bankExecutive);
	}

}
