package com.onerivet.springbootcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.onerivet.springbootcrud.user.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private static List<User> list = new ArrayList<User>();

	@RequestMapping("/adduser")
	public String form() {
		return "AddUser.html";
	}
	
	@GetMapping("/home")
	public String homePage() {
		
		return "Welcome in client side";
	}
	
	@RequestMapping("/add")
	public String addUser(User user1) {
		list.add(user1);
		list.add(new User(1, "abhi", "abhi@gmail.com", "valsad"));
		list.add(new User(102, "Jay Patel", "jay@gmail.com", "Vapi"));
		
		Iterator<User> iterator = list.iterator();
		User user = iterator.next();

		return "--->Add Successful:  " + user.getName() + "  details";
	}

	@GetMapping("/get")
	public List<User> grtUser() {

		return list;
	}

}
