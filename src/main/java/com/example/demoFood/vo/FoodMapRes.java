package com.example.demoFood.vo;

import com.example.demoFood.entity.FoodMap;
import com.example.demoFood.entity.FoodMapCity;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodMapRes {

	private FoodMap foodmap;
//	 private FoodMapCity foodmapcity;
	private String message;

//	public FoodMapCity getFoodmapcity() {
//		return foodmapcity;
//	}
//
//	public void setFoodmapcity(FoodMapCity foodmapcity) {
//		this.foodmapcity = foodmapcity;
//	}

	public FoodMap getFoodmap() {
		return foodmap;
	}

	public void setFoodmap(FoodMap foodmap) {
		this.foodmap = foodmap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FoodMapRes() {

	}

	public FoodMapRes(FoodMap foodmap, String message) {
		this.foodmap = foodmap;
		this.message = message;
	}

	public FoodMapRes(String message) {
		this.message = message;
	}

}
