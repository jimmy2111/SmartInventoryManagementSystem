package com.einfo.SmartInventoryManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Login {

	@Id
	private String user_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	private String user_email;
	private String user_name;
	private String user_password;
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	public Login(String user_email, String user_name, String user_password) {
		super();
		this.user_email = user_email;
		this.user_name = user_name;
		this.user_password = user_password;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [user_id=" + user_id + ", user_email=" + user_email + ", user_name=" + user_name
				+ ", user_password=" + user_password + "]";
	}
	
}
