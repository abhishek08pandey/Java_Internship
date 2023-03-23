package com.rivet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rivet.dao.DAOServiceImpl;
import com.rivet.student.Student;

@WebServlet("/adduser")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// Get url name with id
		String name = request.getParameter("name");
		
// Get id from homepage.jsp		
		int id = Integer.parseInt(request.getParameter("id"));
		
// When call insert records
		if(name.equalsIgnoreCase("createRecords")) {
		request.getRequestDispatcher("WEB-INF//feature//create.html").forward(request, response);
		}	
// When url name = delete
		else if (name.equalsIgnoreCase("DELETE")) {
			DAOServiceImpl.deleteById(id);
			response.sendRedirect("homepage.jsp");}
		
// When url name = update		
		else if (name.equalsIgnoreCase("UPDATE")) {
			Student idDetails = DAOServiceImpl.getIdDetails(id);
			request.setAttribute("idDetails", idDetails);
			request.getRequestDispatcher("WEB-INF//feature//update.jsp").forward(request, response);
			
// when url name = getid Details
		} else if (name.equalsIgnoreCase("GETID")) {
			Student idDetails = DAOServiceImpl.getIdDetails(id);
			request.setAttribute("idDetails", idDetails);
			request.getRequestDispatcher("WEB-INF//feature//getid.jsp").forward(request, response);
			//response.sendRedirect("WEB-INF//feature//getid.jsp");
			//can not use because it will send response not a id   
// Not happen
		} else {
			response.sendRedirect("homepage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String work = request.getParameter("work");
// fetch data from create.html or update.jsp
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			Student student = new Student();
			student.setName(name);
			student.setEmail(email);
			student.setPassword(password);

// If in url work=update than update will continue
			if (work.equalsIgnoreCase("UPDATE")) {
// With id
				int id = Integer.parseInt(request.getParameter("id"));
				student.setId(id);

				DAOServiceImpl.update(student);
				response.sendRedirect("homepage.jsp");
				
// If in url work=create than create will continue				
			} else if (work.equalsIgnoreCase("create")) {
				
// Call Save method of DAOServiceImpl class
				DAOServiceImpl.addStudent(student);
				//request.getRequestDispatcher("homepage.jsp").forward(request, response);
				response.sendRedirect("homepage.jsp");
			}		
		} catch (Exception e) {
			System.out.println("Exception in doPost method");
			e.getStackTrace();
			
			
		}
	}
}
