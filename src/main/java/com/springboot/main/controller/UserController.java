package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Resident;
import com.springboot.main.model.User;
import com.springboot.main.service.ResidentService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ResidentService residentService;

	@PostMapping("/add")
	public User insertUser(@RequestBody User user) {
		/* saves user in database */
		User newUser = userService.insert(user);
		/* sets role as user for all entries*/
		user.setRole("USER");
		/* Create a new  resident object*/
		Resident newResident = new Resident();
		/*sets name for resident same as user*/
		newResident.setName(newUser.getName());
		/* sets role as RESIDENT in resident table*/
		newResident.setRole("RESIDENT");
		/* Id is not enabled by defailt*/
		newResident.setEnabled(false);

		/* newly created user is used as user_id for resident */
		newResident.setUser(newUser);

		/* save resident in the database */
		residentService.insert(newResident);
		/* returns user from database*/
		return userService.insert(user);

	}
}
