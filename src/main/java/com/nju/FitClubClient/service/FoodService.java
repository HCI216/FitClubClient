package com.nju.FitClubClient.service;

import java.util.ArrayList;

import javax.ws.rs.PathParam;

import com.nju.FitClubClient.model.Food;

public interface FoodService {

	public ArrayList<String> getSmallCategoryByBigCategory(String bigCategory);

	public ArrayList<String> getTraditionalCategoryFromSmallCategory(
			String smallCategory);

	public ArrayList<Food> getFoodByBigCategoryAndSmallCategory(
			String bigCategory, String smallCategory);

	public ArrayList<Food> getTraditionalFoodBySmallCategory(
			String smallCategory_part1, String smallCategory_part2);
	
	public ArrayList<Food> searchFoodByContent(String content);
}
