package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Account;
import com.springboot.main.repository.AccountHolderRepository;
import com.springboot.main.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}


}
