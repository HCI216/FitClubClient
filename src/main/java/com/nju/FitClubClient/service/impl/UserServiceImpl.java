package com.nju.FitClubClient.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import com.nju.FitClubClient.model.User;
import com.nju.FitClubClient.service.UserService;

public class UserServiceImpl implements UserService {

	private String url = "http://localhost:9999/userservice";

	public LoginResult login(String username, String password) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
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
		WebClient client = WebClient.create(url);
		User user = new User();
		user.setUserName(username);
		String path = "/logout/" + username;
		return client.path(path).accept("application/xml")
				.type("application/xml").put(user)
				.readEntity(LogoutResult.class);
	}

	public boolean uploadImage(String imagePath, String username) {
		// TODO Auto-generated method stub
		try {
			InputStream ins = new FileInputStream(imagePath);
			byte[] bytes = new byte[1024 * 1024];
			ImageHelperModel helper = new ImageHelperModel();
			WebClient client = WebClient.create(url);
			String path = "/uploadImage/" + username;
			client = client.path(path).accept("application/xml")
					.type("application/xml");

			while (true) {
				int size = ins.read(bytes);
				if (size <= 0)
					break;
				byte[] fixBytes = Arrays.copyOfRange(bytes, 0, size);
				helper.setBytes(fixBytes);
				client.post(helper);
				helper.setPosition(helper.getPosition() + fixBytes.length);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadRequestException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void main(String[] args) {
		UserService userS = new UserServiceImpl();
		userS.uploadImage("/home/xxd/ibeyondy/client/xxd.png", "xxd");
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

}
