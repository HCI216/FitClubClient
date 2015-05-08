package com.nju.FitClubClient.service.impl;

import java.util.ArrayList;

import org.apache.cxf.jaxrs.client.WebClient;

import com.nju.FitClubClient.model.EatFoodRecord;
import com.nju.FitClubClient.model.EatRecord;
import com.nju.FitClubClient.model.EatRecordList;
import com.nju.FitClubClient.model.Food;
import com.nju.FitClubClient.service.EatService;

public class EatServiceImpl implements EatService {

	private String url = "http://localhost:9999/eatservice";

	public boolean addEatRecord(String userID, String time, String timeInDay,
			double calorie, ArrayList<EatFoodRecord> foodList) {
		// TODO Auto-generated method stub
		EatRecord record = new EatRecord();
		record.setCalorie(calorie);
		record.setFoodList(foodList);
		record.setTime(time);
		record.setTimeInDay(timeInDay);
		record.setUserID(userID);
		WebClient client = WebClient.create(url);
		String path = "/addEatRecord";
		return client.path(path).type("application/xml")
				.accept("application/xml").post(record)
				.readEntity(boolean.class);
	}

	public ArrayList<EatRecord> getEatRecord(String userID, String time) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/getEatRecord/"+userID+"/"+time;
		EatRecordList list = client.path(path).type("application/xml")
				.accept("application/xml").get(EatRecordList.class);
		return list.getEatRecordList();
	}

}
