package com.nju.FitClubClient.service;

import java.util.ArrayList;

import com.nju.FitClubClient.model.EatFoodRecord;
import com.nju.FitClubClient.model.EatRecord;
import com.nju.FitClubClient.service.impl.EatServiceImpl;

public class EatServiceTest {

	EatService service = new EatServiceImpl();

	public void addEatRecord() {
		ArrayList<EatFoodRecord> foodList = new ArrayList<EatFoodRecord>();
		EatFoodRecord pp = new EatFoodRecord();
		pp.setEatAmount(100);
		pp.setFoodID("1");
		foodList.add(pp);
		service.addEatRecord("201504301427", "20150504", "晚餐", 2, foodList);
	}

	public void getEatRecord() {
		ArrayList<EatRecord> ss = service.getEatRecord("201504301427",
				"20150504");
		for (int i = 0; i < ss.size(); i++) {
			System.out.println(ss.get(i).getTimeInDay());
			ArrayList<EatFoodRecord> sss = ss.get(i).getFoodList();
			for (int j = 0; j < sss.size(); j++) {
				System.out.println(sss.get(j).getFoodID() + "," + sss.get(j).getEatAmount());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EatServiceTest test = new EatServiceTest();
//		test.addEatRecord();
		test.getEatRecord();
	}

}
