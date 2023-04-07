package com.onerivet.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.Map.Entry;

import com.onerivet.springbootcrud.service.UserService;
import com.onerivet.springbootcrud.user.User;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class UserController {

// Perform DI
	@Autowired
	private UserService userService;

// Create 
	@PostMapping("/add/{idUser}")
	public String addMap(@PathVariable Integer idUser, @RequestBody User user) {

		return userService.addUser(idUser, user);
	}

//Read
	@GetMapping("/get")
	public List<User> getMapUser() {

		return userService.getRecords();
	}

// Read Single User
	@GetMapping("/get/{idUser}")
	public User getById(@PathVariable Integer idUser) {
		
		return userService.getSingleUser(idUser);
	}

// Update
	@PutMapping("/update/{idUser}")
	public String updateUser(@PathVariable Integer idUser, @RequestBody User user) {

		return userService.updateUser(idUser, user);
	}

//Delete 
	@DeleteMapping("/delete/{idUser}")
	public String deleteUser(@PathVariable Integer idUser) {

		return userService.deleteUser(idUser);
	}
}
