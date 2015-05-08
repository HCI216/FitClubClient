package com.nju.FitClubClient.service;

import com.nju.FitClubClient.model.Plan;

public interface PlanService {
	
	public Plan askForPlan(String userID);
	
	public Plan getPlan(String userID);
}
