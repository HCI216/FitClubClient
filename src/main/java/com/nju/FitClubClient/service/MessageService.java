package com.nju.FitClubClient.service;

import java.util.ArrayList;

import javax.ws.rs.PathParam;

import com.nju.FitClubClient.model.GetRunMateRecord;
import com.nju.FitClubClient.model.InviteMessage;

public interface MessageService {
	public boolean sendGetRunMateMessage(String userID, String time,
			String place, String content);

	public boolean sendInviteMessage(String userID, String getRunMateRecordID,
			String telephone, String content);

	public ArrayList<GetRunMateRecord> getGetRunMateRecord();

	public ArrayList<InviteMessage> getReceiveMessage(
			@PathParam("userID") String userID);

	public ArrayList<InviteMessage> getSendMessage(
			@PathParam("userID") String userID);

	public boolean readMessage(
			@PathParam("inviteMessageID") String inviteMessageID,
			@PathParam("newState") String newState);

}
