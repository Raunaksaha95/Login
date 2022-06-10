package com.studentapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOserviceimpl implements DAOservice {

	private Connection con;
	private Statement stmnt;

	@Override
	public void connectDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_demo", "root", "Verma@123");
			stmnt = con.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyCredential(String email, String password) {
		try {
			ResultSet result = stmnt
					.executeQuery("select * from login where email='" + email + "' and password='" + password + "'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRagistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values ('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
