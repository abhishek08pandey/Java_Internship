package com.onerivet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.entity.SomeBean;

@RestController  
public class FilteringController   
{  
@RequestMapping("/filtering")  
public SomeBean retrieveSomeBean()  
{  
return new SomeBean("Amit", "9999999999","39000");  
}  
}  
