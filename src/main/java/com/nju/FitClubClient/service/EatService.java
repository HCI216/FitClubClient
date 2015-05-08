package com.nju.FitClubClient.service;

import java.util.ArrayList;

import com.nju.FitClubClient.model.EatFoodRecord;
import com.nju.FitClubClient.model.EatRecord;
import com.nju.FitClubClient.model.Food;

public interface EatService {

	public boolean addEatRecord(String userID, String time, String timeInDay,
			double calorie, ArrayList<EatFoodRecord> foodList);

	public ArrayList<EatRecord> getEatRecord(String userID, String time);

}
