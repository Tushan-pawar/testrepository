package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Admin;
import com.springboot.main.model.User;
import com.springboot.main.service.AdminService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@PostMapping("/add")

	public Admin insert(@RequestBody Admin admin) {
		
		/*gets user associated with administrator*/
		User user = admin.getUser();
		/* sets role as administrator for all entries*/
		user.setRole("ADMIN");
		/*saves user information in database*/
		user = userService.insert(user);
		/*sets user in database for administrator*/
		admin.setUser(user);
		/* saves the administrator with user information in the database*/
		return adminService.insert(admin);
	}
	
	
	
	
	
	
	
}
