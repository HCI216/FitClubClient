package com.nju.FitClubClient;

import com.nju.FitClubClient.service.UserService;
import com.nju.FitClubClient.service.impl.UserServiceImpl;

public class Test {

	private static UserService service = new UserServiceImpl();

	public static void main(String[] args) {
//		testLogin();
//		testRegister();
//		testLogout();
		testUploadImage();
	}

	public static void testLogin() {
		boolean ok = service.login("joker", "1234");
		if (ok) {
			System.out.println("OK");
		} else {
			System.out.println("Error");
		}
	}

	public static void testRegister() {
		boolean op = service.register("joker", "1234");
		if (op)
			System.out.println("OK");
		else
			System.out.println("Error");

	}
	
	public static void testLogout() {
		boolean op = service.logout("joker");
		if(op) 
			System.out.println("OK");
		else {
			System.out.println("Error");
		}
	}
	
	public static void testUploadImage() {
		String path = "/home/xxd/ibeyondy/ibeyondy.png";
		service.uploadImage(path, "pl");
	}

}
