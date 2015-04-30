package com.nju.FitClubClient.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "EatFoodRecord")
public class EatFoodRecord {

	private Food food;
	private double eatAmount;

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public double getEatAmount() {
		return eatAmount;
	}

	public void setEatAmount(double eatAmount) {
		this.eatAmount = eatAmount;
	}

}
