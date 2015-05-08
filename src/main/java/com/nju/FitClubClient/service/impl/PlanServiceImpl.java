package com.nju.FitClubClient.service.impl;

import org.apache.cxf.jaxrs.client.WebClient;

import com.nju.FitClubClient.model.Plan;
import com.nju.FitClubClient.model.RunRecordList;
import com.nju.FitClubClient.service.PlanService;

public class PlanServiceImpl implements PlanService {

	private String url = "http://localhost:9999/planservice";

	public Plan getPlan(String userID) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/getPlan/" + userID;
		Plan plan = client.path(path).accept("application/xml")
				.type("application/xml").get(Plan.class);
		return plan;
	}

	public Plan askForPlan(String userID) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/askForPlan/" + userID;
		Plan plan = (Plan) client.path(path).accept("application/xml")
				.type("application/xml").post("").getEntity();
		return plan;
	}

}
