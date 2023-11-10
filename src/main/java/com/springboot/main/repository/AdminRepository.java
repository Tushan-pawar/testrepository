package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	  Admin findByUserId(Long userId);
}
