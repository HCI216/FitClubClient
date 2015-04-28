package com.nju.FitClubClient.test;

import com.nju.FitClubClient.Enum.LoginResult;
import com.nju.FitClubClient.Enum.LogoutResult;
import com.nju.FitClubClient.Enum.RegisterResult;
import com.nju.FitClubClient.service.UserService;
import com.nju.FitClubClient.service.impl.UserServiceImpl;

public class UserServiceTest {

	private static UserService userService;

	static {
		userService = new UserServiceImpl();
	}

	public static boolean detect(String result, String wanted) {
		if (result.equals(wanted))
			return true;
		return false;
	}

	public static void testLogin() {

		System.out.println("--------------test Login--------------------");

		int testCase = 1;

		/*
		 * Login Successfully
		 */

		LoginResult result = userService.login("joker", "1234");
		if (detect(result.toString(), LoginResult.SUCCESS.toString()))
			System.out.println("testCase " + testCase++ + " Succeed");
		userService.logout("joker");

		/*
		 * Password Error
		 */

		result = userService.login("joker", "123");
		if (detect(result.toString(),
				LoginResult.USER_PASSWORD_NOT_MATCH.toString()))
			System.out.println("testCase " + testCase++ + " Succeed");

		/*
		 * No Such User
		 */

		result = userService.login("joke", "123");
		if (detect(result.toString(), LoginResult.NO_SUCH_USER.toString()))
			System.out.println("testCase " + testCase++ + " Succeed");

		/*
		 * Login Already
		 */
		result = userService.login("joker", "1234");
		result = userService.login("joker", "1234");

		if (detect(result.toString(), LoginResult.Login_ALREADY.toString()))
			System.out.println("testCase " + testCase++ + " Succeed");
		userService.logout("joker");

	}

	public static void testLogout() {

		System.out.println("--------------test Logout--------------------");

		int testCase = 1;

		/*
		 * Logout Success
		 */

		userService.login("joker", "1234");
		LogoutResult result = userService.logout("joker");
		if (detect(result.toString(), LogoutResult.SUCCESS.toString())) {
			System.out.println("testCase " + testCase++ + " Succeed");
		}

		/*
		 * Logout Already
		 */

		result = userService.logout("joker");
		if (detect(result.toString(), LogoutResult.Logout_ALREADY.toString())) {
			System.out.println("testCase " + testCase++ + " Succeed");
		}

		/*
		 * No Such User
		 */

		result = userService.logout("xxx");
		if (detect(result.toString(), LogoutResult.NO_SUCH_USER.toString())) {
			System.out.println("testCase " + testCase++ + " Succeed");
		}
	}

	public static void testRegister() {
		System.out.println("--------------test Register--------------------");

		int testCase = 1;

		RegisterResult result = userService.register("poke", "12345");

		if (detect(result.toString(), RegisterResult.SUCCESS.toString())) {
			System.out.println("testCase " + testCase++ + " Succeed");
		}

		result = userService.register("xxd", "1234");

		if (detect(result.toString(), RegisterResult.NAME_DULP.toString())) {
			System.out.println("testCase " + testCase++ + " Succeed");
		}

	}

	public static void testUploadImage() {
		System.out
				.println("--------------test UploadImage--------------------");
		userService.uploadImage("/home/xxd/ibeyondy/client/upload.png", "xxd");
	}

	public static void testDownloadImage() {
		System.out
				.println("--------------test DownloadImage--------------------");
		userService.downloadImage("joker");
	}

	public static void main(String[] args) {
		testLogin();
		testLogout();
		testRegister();
		testUploadImage();
		testDownloadImage();
	}

}
