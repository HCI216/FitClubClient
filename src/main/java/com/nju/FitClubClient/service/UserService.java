package com.nju.FitClubClient.service;

public interface UserService {

	public boolean login(String username, String password);

	public boolean register(String username, String password);

	public boolean logout(String username);

	public boolean uploadImage(String url,String username);
}
