package com.nju.FitClubClient.service;

import java.util.ArrayList;

import com.nju.FitClubClient.model.WeightRecord;
import com.nju.FitClubClient.service.impl.UserServiceImpl;

public class UserServiceTest {

	UserService userService = new UserServiceImpl();

	public void recordWeight() {
		userService.recordWeight("201504301427", 100);
	}

	public void getAllWeightRecord() {
		ArrayList<WeightRecord> recordList = userService
				.getAllWeightRecord("201504301427");
		for (int i = 0; i < recordList.size(); i++) {
			WeightRecord record = recordList.get(i);
			System.out.println(record.getWeightRecordID() + " : "
					+ record.getWeight());
		}
	}

	public static void main(String[] args) {
		UserServiceTest test = new UserServiceTest();
		// test.recordWeight();
		test.getAllWeightRecord();
	}

}
