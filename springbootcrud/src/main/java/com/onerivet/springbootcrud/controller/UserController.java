package com.onerivet.springbootcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.onerivet.springbootcrud.user.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private static List<User> list = new ArrayList<User>();

	@GetMapping("/home")
	public String homePage() {
		return "Welcome in client side";
	}

//	@RequestMapping("/add")
//	public String addUser() {
//		list.add(new User(1, "abhi", "abhi@gmail.com", "valsad"));
//		list.add(new User(2, "Jay Patel", "jay@gmail.com", "Vapi"));
//
//		Iterator<User> iterator = list.iterator();
//		User user = iterator.next();
//
//		return "--->Add Successful:  " + user.getName() + "  details";
//	}
	
	@PostMapping("/add")
	public Object addUser(@RequestBody User user) {
		
		return list.add(user);
	}

	@GetMapping("/get")
	public List<User> getUser() {
		return list;
	}

	@GetMapping("/get/{id}")
	public Object getUserById(@PathVariable int id) {

		Iterator<User> iterator = list.iterator();

		while (iterator.hasNext()) {
			User user = (User) iterator.next();

			if (user.getId() == id && user != null) {

				return user;
			}
		}
		return "not found";
	}
	
	private static Map<Integer, User> mapUser = new HashMap<Integer, User>();
	
	@PostMapping("/addmapuser")
	public String addMap(@PathVariable Integer id, @RequestBody User user) {
		
		mapUser.put(id, user);
		
		return "add successful";
	}
	
	@GetMapping("/getmapuser")
	public Object getMapUser() {
		
	List<User> list2 = mapUser.values().stream().toList();
		return list2;
	}
	

}
