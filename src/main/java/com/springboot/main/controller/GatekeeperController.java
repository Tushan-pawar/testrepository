package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Gatekeeper;
import com.springboot.main.model.User;
import com.springboot.main.service.GatekeeperService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/gatekeeper")
public class GatekeeperController {

	@Autowired
	private GatekeeperService gatekeeperService;
	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public Gatekeeper insertGateKeeper(@RequestBody Gatekeeper gatekeeper) {
	/*makes entry in gateKeeper table along with in user table*/
		/*gets user associated with admin_table*/
		User user = gatekeeper.getUser();
		/* sets role as GATEKEEPER*/
		user.setRole("GATEKEEPER");
		/*gives user input in table*/
		user= userService.insert(user);
		/*associate gateKeeper with user id*/
		gatekeeper.setUser(user);
		/*inserts gateKeeper into table and returns*/
		return gatekeeperService.insert(gatekeeper);
	}

}
