package com.onerivet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/employee")
public class SpringssecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringssecurityApplication.class, args);
	}

	@GetMapping("/get")
	public String get(@RequestAttribute String name) {
		return name;
	}
}
