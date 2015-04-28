package com.nju.FitClubClient.service;

<<<<<<< HEAD
public interface UserService {

	public boolean login(String username, String password);

	public boolean register(String username, String password);

	public boolean logout(String username);

	public boolean uploadImage(String url,String username);
=======
import com.nju.FitClubClient.Enum.LoginResult;
import com.nju.FitClubClient.Enum.LogoutResult;
import com.nju.FitClubClient.Enum.RegisterResult;

public interface UserService {

	public LoginResult login(String username, String password);

	public RegisterResult register(String username, String password);

	public LogoutResult logout(String username);

	public boolean uploadImage(String url,String username);
	
	public boolean downloadImage(String username);
>>>>>>> 7ea01633e37424229b2b321896b827c39c885c9d
}
