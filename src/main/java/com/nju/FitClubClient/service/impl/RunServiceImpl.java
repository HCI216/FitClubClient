package com.nju.FitClubClient.service.impl;

import java.util.ArrayList;

import org.apache.cxf.jaxrs.client.WebClient;

import com.nju.FitClubClient.model.CoordinateRecord;
import com.nju.FitClubClient.model.RunRecord;
import com.nju.FitClubClient.model.RunRecordList;
import com.nju.FitClubClient.service.RunService;

public class RunServiceImpl implements RunService {

	private String url = "http://localhost:9999/runservice";

	public boolean addRunRecord(String userID, String time, double runDistance,
			double runTime, double calorie, double[][] coordinateList) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		RunRecord record = new RunRecord();
		record.setUserID(userID);
		record.setTime(time);
		record.setRunDistance(runDistance);
		record.setRunTime(runTime);
		record.setCalorie(calorie);
		ArrayList<CoordinateRecord> cRecordList = new ArrayList<CoordinateRecord>();
		for (int i = 0; i < coordinateList[0].length; i++) {
			CoordinateRecord cRecord = new CoordinateRecord();
			cRecord.setX(coordinateList[0][i]);
			cRecord.setY(coordinateList[1][i]);
			cRecordList.add(cRecord);
		}
		record.setCoordinateRecordList(cRecordList);
		String path = "/addRunRecord";
		return client.path(path).accept("application/xml")
				.type("application/xml").post(record).readEntity(boolean.class);

	}

	public ArrayList<RunRecord> getRunRecord(String userID, String time) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/getRunRecord/" + userID + "/" + time;
		RunRecordList list = client.path(path).accept("application/xml")
				.type("application/xml").get(RunRecordList.class);
		return list.getRecords();
	}

}
