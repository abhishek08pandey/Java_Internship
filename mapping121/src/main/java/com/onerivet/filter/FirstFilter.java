package com.onerivet.filter;

import java.io.IOException;
import org.springframework.stereotype.Component;

import com.onerivet.entitydto.EmployeeDto;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//@Component
public class FirstFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String name = request.getParameter("name");
		System.out.println(name.toUpperCase()+ " in filter");
////		EmployeeDto employeeDto = (EmployeeDto) request.getAttribute("employeeDto");
////		System.out.println(employeeDto.getName());
//		//String name = employeeDto.getName().toUpperCase();
//		
//		chain.doFilter(request, response);
		
	}

	

}
