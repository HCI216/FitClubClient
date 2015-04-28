package com.nju.FitClubClient.service.impl;

<<<<<<< HEAD
=======
import java.io.File;
>>>>>>> 7ea01633e37424229b2b321896b827c39c885c9d
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
<<<<<<< HEAD
import java.util.Arrays;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.client.WebClient;

import com.nju.FitClubClient.model.ImageHelper;
=======
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Calendar;

import javax.ws.rs.BadRequestException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import com.nju.FitClubClient.Enum.LoginResult;
import com.nju.FitClubClient.Enum.LogoutResult;
import com.nju.FitClubClient.Enum.RegisterResult;
import com.nju.FitClubClient.model.ImageHelperModel;
>>>>>>> 7ea01633e37424229b2b321896b827c39c885c9d
import com.nju.FitClubClient.model.User;
import com.nju.FitClubClient.service.UserService;

public class UserServiceImpl implements UserService {

	private String url = "http://localhost:9999/userservice";

<<<<<<< HEAD
	public boolean login(String username, String password) {
=======
	public LoginResult login(String username, String password) {
>>>>>>> 7ea01633e37424229b2b321896b827c39c885c9d
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
<<<<<<< HEAD
		String path = "/login/" + username;
		Response res = client.path(path).accept("application/xml")
				.type("application/xml").put(user);
		if (res.getStatus() == Status.BAD_REQUEST.getStatusCode())
			return false;
		if (res.getStatus() == Status.BAD_GATEWAY.getStatusCode())
			return false;
		return true;
	}

	public boolean register(String username, String password) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		String path = "/register";
		Response res = client.path(path).accept("application/xml")
				.type("application/xml").post(user);
		if (res.getStatus() == Status.BAD_REQUEST.getStatusCode())
			return false;
		return true;
	}

	public boolean logout(String username) {
		// TODO Auto-generated method stub
=======
		user.setLoginOrNot(false);
		String path = "/login/" + username;
		return client.path(path).accept("application/xml")
				.type("application/xml").put(user)
				.readEntity(LoginResult.class);
	}

	public String getNewUserID() {
		Calendar cal = Calendar.getInstance();
		String year = cal.get(Calendar.YEAR) + "";
		String month = cal.get(Calendar.MONTH) + "";
		String day = cal.get(Calendar.DAY_OF_MONTH) + "";
		String hour = cal.get(Calendar.HOUR_OF_DAY) + "";
		String minutes = cal.get(Calendar.MINUTE) + "";
		String sec = cal.get(Calendar.SECOND) + "";
		return year + month + day + hour + minutes + sec;
	}

	public RegisterResult register(String username, String password) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		User user = new User();
		user.setUserID(getNewUserID());
		user.setUserName(username);
		user.setPassword(password);
		String path = "/register";
		RegisterResult result = (RegisterResult) client.path(path)
				.accept("application/xml").type("application/xml").post(user)
				.readEntity(RegisterResult.class);
		return result;
	}

	public LogoutResult logout(String username) {
>>>>>>> 7ea01633e37424229b2b321896b827c39c885c9d
		WebClient client = WebClient.create(url);
		User user = new User();
		user.setUserName(username);
		String path = "/logout/" + username;
<<<<<<< HEAD
		Response res = client.path(path).accept("application/xml")
				.type("application/xml").put(user);
		if (res.getStatus() == Status.BAD_REQUEST.getStatusCode())
			return false;
		if (res.getStatus() == Status.BAD_GATEWAY.getStatusCode())
			return false;
		return true;
=======
		return client.path(path).accept("application/xml")
				.type("application/xml").put(user)
				.readEntity(LogoutResult.class);
>>>>>>> 7ea01633e37424229b2b321896b827c39c885c9d
	}

	public boolean uploadImage(String imagePath, String username) {
		// TODO Auto-generated method stub
		try {
<<<<<<< HEAD
			InputStream ins = new FileInputStream(imagePath);
			byte[] bytes = new byte[1024 * 1024];
			ImageHelper helper = new ImageHelper();
			WebClient client = WebClient.create(url);
			while (true) {
				int size = ins.read(bytes);
=======
			
			byte[] bytes = new byte[1024 * 1024];
			ImageHelperModel helper = new ImageHelperModel();
			WebClient client = WebClient.create(url);
			String path = "/uploadImage/" + username;
			client = client.path(path).accept("application/xml")
					.type("application/xml");

			while (true) {
				InputStream ins = new FileInputStream(imagePath);
				ins.skip(helper.getPosition());
				int size = ins.read(bytes);
				System.out.println(size);
>>>>>>> 7ea01633e37424229b2b321896b827c39c885c9d
				if (size <= 0)
					break;
				byte[] fixBytes = Arrays.copyOfRange(bytes, 0, size);
				helper.setBytes(fixBytes);
<<<<<<< HEAD
				String path = "/uploadimage/" + username;
				client.path(path).accept("application/xml").type("application/xml").post(helper);
=======
				client.post(helper);
>>>>>>> 7ea01633e37424229b2b321896b827c39c885c9d
				helper.setPosition(helper.getPosition() + fixBytes.length);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
<<<<<<< HEAD
		} catch(BadRequestException e) {
=======
		} catch (BadRequestException e) {
>>>>>>> 7ea01633e37424229b2b321896b827c39c885c9d
			e.printStackTrace();
		}
		return true;
	}
<<<<<<< HEAD
=======

	public static void main(String[] args) {
		UserService userS = new UserServiceImpl();
		userS.downloadImage("xxd");
		// userS.uploadImage("/home/xxd/ibeyondy/pl.png", "xxd");
		// LogoutResult lr = userS.logout("joker");
		// System.out.println(lr);
		// RegisterResult rr = userS.register("xxd", "123456");
		// if(rr.equals(RegisterResult.SUCCESS)) {
		// System.out.println("hello");
		// }else{
		// System.out.println("hi");
		// }
		// LoginResult rs = userS.login("joker", "1234");
		// System.out.println(rs);
		// if (rs.equals(LoginResult.SUCCESS)) {
		// System.out.println("hello");
		// System.out.println("hello");
		// System.out.println("hello");
		// System.out.println("hello");
		// }
		// System.out.println("hi");
	}

	public boolean downloadImage(String username) {
		// TODO Auto-generated method stub
		ImageHelperModel myfile = new ImageHelperModel();
		long position = 0;
		File pic = new File("/home/xxd/ibeyondy/client/" + username + ".png");
		if (!pic.exists()) {
			try {
				pic.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (true) {
			String path = "/downloadImage/" + username + "/" + position;
			WebClient client = WebClient.create(url);
			myfile = client.path(path).accept("application/xml")
					.type("application/xml").get(ImageHelperModel.class);
			if (myfile.getBytes().length <= 0) {
				break;
			}
			OutputStream os = null;
			try {
				if (position != 0) {
					os = FileUtils.openOutputStream(pic, true);
				} else {
					os = FileUtils.openOutputStream(pic, false);
				}
				os.write(myfile.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				IOUtils.closeQuietly(os);
			}
			position += myfile.getBytes().length;
		}
		return true;
	}

>>>>>>> 7ea01633e37424229b2b321896b827c39c885c9d
}
