package com.onerivet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class StudentController {

	
	@GetMapping("/add")
	public String get (@RequestAttribute String name) {
		return name;
	}
}
