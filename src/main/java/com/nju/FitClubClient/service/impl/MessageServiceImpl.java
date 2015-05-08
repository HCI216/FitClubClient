package com.nju.FitClubClient.service.impl;

import java.util.ArrayList;

import org.apache.cxf.jaxrs.client.WebClient;

import com.nju.FitClubClient.Enum.GetRunMateRecordState;
import com.nju.FitClubClient.Enum.InviteMessageState;
import com.nju.FitClubClient.Enum.LoginResult;
import com.nju.FitClubClient.model.GetRunMateRecord;
import com.nju.FitClubClient.model.GetRunMateRecordList;
import com.nju.FitClubClient.model.InviteMessage;
import com.nju.FitClubClient.model.InviteMessageList;
import com.nju.FitClubClient.service.MessageService;

public class MessageServiceImpl implements MessageService {

	private String url = "http://localhost:9999/messageservice";

	public boolean sendGetRunMateMessage(String userID, String time,
			String place, String content) {
		// TODO Auto-generated method stub
		GetRunMateRecord getRunMateRecord = new GetRunMateRecord();
		getRunMateRecord.setContent(content);
		getRunMateRecord.setPlace(place);
		getRunMateRecord.setState(GetRunMateRecordState.process + "");
		getRunMateRecord.setTime(time);
		getRunMateRecord.setUserID(userID);

		WebClient client = WebClient.create(url);
		String path = "/sendGetRunMateMessage";
		return client.path(path).accept("application/xml")
				.type("application/xml").post(getRunMateRecord)
				.readEntity(boolean.class);

	}

	public boolean sendInviteMessage(String userID, String getRunMateRecordID,
			String telephone, String content) {
		// TODO Auto-generated method stub
		InviteMessage inviteMessage = new InviteMessage();
		inviteMessage.setContent(content);
		inviteMessage.setGetRunMateRecordID(getRunMateRecordID);
		inviteMessage.setState(InviteMessageState.unread + "");
		inviteMessage.setTelephone(telephone);
		inviteMessage.setUserID(userID);

		WebClient client = WebClient.create(url);
		String path = "/sendInviteMessage";
		return client.path(path).accept("application/xml")
				.type("application/xml").post(inviteMessage)
				.readEntity(boolean.class);
	}

	public ArrayList<GetRunMateRecord> getGetRunMateRecord() {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/getGetRunMateRecord";
		GetRunMateRecordList list = client.path(path).accept("application/xml")
				.type("application/xml").get(GetRunMateRecordList.class);
		return list.getGetRunMateRecordList();
	}

	public ArrayList<InviteMessage> getReceiveMessage(String userID) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/getReceiveMessage/" + userID;
		InviteMessageList list = client.path(path).accept("application/xml")
				.type("application/xml").get(InviteMessageList.class);
		return list.getInviteMessageList();
	}

	public ArrayList<InviteMessage> getSendMessage(String userID) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/getSendMessage/" + userID;
		InviteMessageList list = client.path(path).accept("application/xml")
				.type("application/xml").get(InviteMessageList.class);
		return list.getInviteMessageList();
	}

	public boolean readMessage(String inviteMessageID, String newState) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/readMessage/" + inviteMessageID + "/" + newState;
		return client.path(path).accept("application/xml")
				.type("application/xml").put("").readEntity(boolean.class);
	}

}
