package com.nju.FitClubClient.service;

import java.util.ArrayList;

import com.nju.FitClubClient.model.CoordinateRecord;
import com.nju.FitClubClient.model.RunRecord;
import com.nju.FitClubClient.service.impl.RunServiceImpl;

public class RunServiceTest {

	private RunService service = new RunServiceImpl();

	public void test() {
		double[][] ss = { { 1, 2, 3, 4 }, { 2, 3, 4, 5 } };
		service.addRunRecord("201504301427", "20150504", 100, 10, 123, ss);
	}

	public void test1() {
		ArrayList<RunRecord> records = service.getRunRecord("201504301427",
				"20150504");
		for (int i = 0; i < records.size(); i++) {
			ArrayList<CoordinateRecord> pp = records.get(i)
					.getCoordinateRecordList();
			System.out.println(records.get(i).getRunRecordID());
			for (int j = 0; j < pp.size(); j++) {
				System.out.println(pp.get(j).getX() + "," + pp.get(j).getY());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunServiceTest test = new RunServiceTest();
//		test.test();
		test.test1();
	}

}
