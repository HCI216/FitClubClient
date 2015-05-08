package com.nju.FitClubClient.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Plan")
public class Plan {
	private String planID;
	private String fromUserID;
	private String toUserID;
	private String startTime;
	private String endTime;
	private String state;

	public String getPlanID() {
		return planID;
	}

	public void setPlanID(String planID) {
		this.planID = planID;
	}

	public String getFromUserID() {
		return fromUserID;
	}

	public void setFromUserID(String fromUserID) {
		this.fromUserID = fromUserID;
	}

	public String getToUserID() {
		return toUserID;
	}

	public void setToUserID(String toUserID) {
		this.toUserID = toUserID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
