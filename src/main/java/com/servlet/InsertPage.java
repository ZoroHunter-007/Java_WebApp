package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.Driver_load;
import com.dao.DataDao;

import com.model.User_reg;


/**
 * Servlet implementation class InsertPage
 */
@WebServlet("/InsertPage")
public class InsertPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	     String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        
	        
	     User_reg ur=new User_reg();
	      ur.setEmail(email);
	      ur.setPassword(password);
	      
	      DataDao d=new DataDao();
	      String s=d.VerifyLogin(ur);
	     if("Login".equalsIgnoreCase(s)) {
	    	  RequestDispatcher rd=request.getRequestDispatcher("Burger_home.jsp");
	    	  rd.forward(request, response);
	      }
	      else {
	    	  PrintWriter out=response.getWriter();
	    	  out.println("<script type=\"text/javascript\">");
	    	  out.println("alert('Invalid Email and Password....!');");
	    	  out.println("location='Login_burger.jsp';");
	    	  out.println("</script>");
	      }
	       
		doGet(request, response);
	    }
	}	

