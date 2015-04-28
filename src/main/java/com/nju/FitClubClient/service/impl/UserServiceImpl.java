package com.nju.FitClubClient.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.client.WebClient;

import com.nju.FitClubClient.model.ImageHelper;
import com.nju.FitClubClient.model.User;
import com.nju.FitClubClient.service.UserService;

public class UserServiceImpl implements UserService {

	private String url = "http://localhost:9999/userservice";

	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
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
		WebClient client = WebClient.create(url);
		User user = new User();
		user.setUserName(username);
		String path = "/logout/" + username;
		Response res = client.path(path).accept("application/xml")
				.type("application/xml").put(user);
		if (res.getStatus() == Status.BAD_REQUEST.getStatusCode())
			return false;
		if (res.getStatus() == Status.BAD_GATEWAY.getStatusCode())
			return false;
		return true;
	}

	public boolean uploadImage(String imagePath, String username) {
		// TODO Auto-generated method stub
		try {
			InputStream ins = new FileInputStream(imagePath);
			byte[] bytes = new byte[1024 * 1024];
			ImageHelper helper = new ImageHelper();
			WebClient client = WebClient.create(url);
			while (true) {
				int size = ins.read(bytes);
				if (size <= 0)
					break;
				byte[] fixBytes = Arrays.copyOfRange(bytes, 0, size);
				helper.setBytes(fixBytes);
				String path = "/uploadimage/" + username;
				client.path(path).accept("application/xml").type("application/xml").post(helper);
				helper.setPosition(helper.getPosition() + fixBytes.length);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(BadRequestException e) {
			e.printStackTrace();
		}
		return true;
	}
}
