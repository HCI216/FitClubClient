package com.nju.FitClubClient.service;

import com.nju.FitClubClient.Enum.LoginResult;
import com.nju.FitClubClient.Enum.LogoutResult;
import com.nju.FitClubClient.Enum.RegisterResult;

public interface UserService {

	public LoginResult login(String username, String password);

	public RegisterResult register(String username, String password);

	public LogoutResult logout(String username);

	public boolean uploadImage(String url,String username);
	
	public boolean downloadImage(String username);
}
