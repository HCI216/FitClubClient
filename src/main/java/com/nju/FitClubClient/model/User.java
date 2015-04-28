package com.nju.FitClubClient.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "User")
public class User {

	private String userID;
	private String userName;
	private String password;
	private boolean loginOrNot;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoginOrNot() {
		return loginOrNot;
	}

	public void setLoginOrNot(boolean loginOrNot) {
		this.loginOrNot = loginOrNot;
	}
}
