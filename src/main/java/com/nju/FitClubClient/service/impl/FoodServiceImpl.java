package com.nju.FitClubClient.service.impl;

import java.util.ArrayList;

import org.apache.cxf.jaxrs.client.WebClient;

import com.nju.FitClubClient.model.Food;
import com.nju.FitClubClient.model.FoodCategoryList;
import com.nju.FitClubClient.model.FoodList;
import com.nju.FitClubClient.model.RunRecordList;
import com.nju.FitClubClient.service.FoodService;

public class FoodServiceImpl implements FoodService {

	private String url = "http://localhost:9999/foodservice";
	
	public ArrayList<String> getSmallCategoryByBigCategory(String bigCategory) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/getSmallCategoryByBigCategory/" + bigCategory;
		FoodCategoryList list = client.path(path).accept("application/xml")
				.type("application/xml").get(FoodCategoryList.class);
		return list.getCategoryList();
	}

	public ArrayList<String> getTraditionalCategoryFromSmallCategory(
			String smallCategory) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/getTraditionalCategoryFromSmallCategory/" + smallCategory;
		FoodCategoryList list = client.path(path).accept("application/xml")
				.type("application/xml").get(FoodCategoryList.class);
		return list.getCategoryList();
	}

	public ArrayList<Food> getFoodByBigCategoryAndSmallCategory(
			String bigCategory, String smallCategory) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/getFoodByBigCategoryAndSmallCategory/" + bigCategory + "/" + smallCategory;
		FoodList list = client.path(path).accept("application/xml")
				.type("application/xml").get(FoodList.class);
		return list.getFoods();
	}

	public ArrayList<Food> getTraditionalFoodBySmallCategory(
			String smallCategory_part1, String smallCategory_part2) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/getTraditionalFoodBySmallCategory/" + smallCategory_part1 + "/" + smallCategory_part2;
		FoodList list = client.path(path).accept("application/xml")
				.type("application/xml").get(FoodList.class);
		return list.getFoods();
	}

	public ArrayList<Food> searchFoodByContent(String content) {
		// TODO Auto-generated method stub
		WebClient client = WebClient.create(url);
		String path = "/searchFood/" + content;
		FoodList list = client.path(path).accept("application/xml")
				.type("application/xml").get(FoodList.class);
		return list.getFoods();
	}

}
