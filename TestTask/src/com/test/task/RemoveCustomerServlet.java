package com.test.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCustomerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private Connection connect = null;

	private String user = null;
	private String passwd = null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Properties properties = new Properties();
		properties.load(getServletContext().getResourceAsStream("/resources/Properties.properties"));
		
		user = properties.getProperty("username");
		passwd = properties.getProperty("password");
		
		response.setContentType("text/html");

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String birthDate = request.getParameter("birthDate");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testtask", user, passwd); 

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();

			String strQuery = "select * from testtask.customer where first_name='"
					+ firstName
					+ "' AND last_name='"
					+ lastName
					+ "' AND birth_date='" + birthDate + "'";
			resultSet = statement.executeQuery(strQuery);
			if(resultSet.next()) {
				// Give an alert telling customer does not exist in the database
				String strRemoveQuery = "delete from customer where first_name='"
						+ firstName
						+ "' AND last_name='"
						+ lastName
						+ "' AND birth_date='" + birthDate + "'";
				statement.executeUpdate(strRemoveQuery);
				request.setAttribute("message", "Customer removed from the database");
				System.out.println("Customer removed from the database");
			} else {
				request.setAttribute("message", "Customer does not exist in the database. No record has been removed");
				System.out.println("Customer does not exist in the database and cannot be removed");
			}

		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		response.sendRedirect("displayCustomers.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("removeCustomer.jsp");
		rd.forward(request, response);
	}
}
