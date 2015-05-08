package com.nju.FitClubClient.service;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import com.nju.FitClubClient.model.RunRecord;

public interface RunService {

	public boolean addRunRecord(String userID, String time, double runDistance,
			double runTime, double calorie, double[][] coordinateList);

	public ArrayList<RunRecord> getRunRecord(String userID, String time);

}
