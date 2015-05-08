package com.nju.FitClubClient.service;

import java.util.ArrayList;

import javax.ws.rs.PathParam;

import com.nju.FitClubClient.model.GetRunMateRecord;
import com.nju.FitClubClient.model.InviteMessage;
import com.nju.FitClubClient.service.impl.MessageServiceImpl;


public class MessageServiceTest {

	private MessageService service = new MessageServiceImpl();

	public void sendGetRunMateMessage() {
		service.sendGetRunMateMessage("201504301427", "20150504", "操场", "跑步额");
	}

	public void sendInviteMessage() {
		service.sendInviteMessage("201504301427", "201544122618", "15805197466", "跑步额");
	}

	public void getGetRunMateRecord() {
		ArrayList<GetRunMateRecord> records = service.getGetRunMateRecord();

		for (int i = 0; i < records.size(); i++) {
			System.out.println(records.get(i).getTime() + ","
					+ records.get(i).getPlace() + " , "
					+ records.get(i).getContent());
		}

	}

	public void getReceiveMessage() {
		ArrayList<InviteMessage> message = service.getReceiveMessage("001");
		for (int i = 0; i < message.size(); i++) {
			System.out.println(message.get(i).getTelephone() + ","
					+ message.get(i).getUserID() + " , "
					+ message.get(i).getContent());
		}
	}

	public void getSendMessage() {
		ArrayList<InviteMessage> message = service.getSendMessage("001");
		for (int i = 0; i < message.size(); i++) {
			System.out.println(message.get(i).getTelephone() + ","
					+ message.get(i).getUserID() + " , "
					+ message.get(i).getContent());
		}
	}
	
	public void testRead(){
		service.readMessage("20154412273","read");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MessageServiceTest test = new MessageServiceTest();
//		 test.sendGetRunMateMessage();
//		 test.sendInviteMessage();
//		 test.getGetRunMateRecord();

//		 test.getReceiveMessage();
//		test.getSendMessage();
		test.testRead();
	}

}
