package com.test.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCustomerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
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
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		
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
			if(!resultSet.next()) {
				// Result set get the result of the SQL query
				preparedStatement = connect.prepareStatement("insert into testtask.customer values (?,?,?,?,?)");
				preparedStatement.setString(1, firstName);
				preparedStatement.setString(2, lastName);
				preparedStatement.setString(3, birthDate);
				preparedStatement.setString(4, phoneNumber);
				preparedStatement.setString(5, email);
				preparedStatement.executeUpdate();
				request.setAttribute("message", "Customer added to the database");
				System.out.println("Customer added to the database");
			} else {
				String strUpdateQuery = "update testtask.customer set phone='"
								+ phoneNumber
								+ "', email='"
								+ email
								+ "' where first_name='"
								+ firstName
								+ "' AND last_name='"
								+ lastName
								+ "' AND birth_date='" + birthDate + "'";
				statement.executeUpdate(strUpdateQuery);
				request.setAttribute("message", "Customer already exists in the database. Phone and Email has been updated");
				System.out.println("Customer already exists in the database. Phone and Email has been updated");
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
//		response.sendRedirect("addCustomer.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("addCustomer.jsp");
		rd.forward(request, response);
	}

}
