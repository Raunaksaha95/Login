package com.studentapp.model;

public interface DAOservice {
	public void connectDB();
	public boolean verifyCredential(String email,String password);
	public void saveRagistration(String name, String city, String email, String mobile);
	
}
