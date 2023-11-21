package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.BankExecutive;
import com.springboot.main.repository.BankExecutiveRepository;

@Service
public class BankExecutiveService {
	@Autowired
	private BankExecutiveRepository bankExecutiveRepository;

	public BankExecutive save(BankExecutive bankExecutive) {
		// TODO Auto-generated method stub
		return bankExecutiveRepository.save(bankExecutive);
	}
}