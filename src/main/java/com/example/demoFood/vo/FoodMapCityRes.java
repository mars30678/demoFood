package com.example.demoFood.vo;

import java.util.List;

import com.example.demoFood.entity.FoodMapCity;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodMapCityRes {

	private FoodMapCity foodmapcity;

	private String message;

	private List<String> list;

	private List<FoodMapVo> foodVoList;

	private FoodMapCityRes foodCity;

	public FoodMapCityRes(String message, FoodMapCityRes foodCity) {
		this.message = message;
		this.foodCity = foodCity;
	}
	public FoodMapCityRes(String message, List<String> list) {
		this.message = message;
		this.list = list;
	}
	

	public FoodMapCityRes(List<String> list) {

		this.list = list;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FoodMapCity getFoodmapcity() {
		return foodmapcity;
	}

	public void setFoodmapcity(FoodMapCity foodmapcity) {
		this.foodmapcity = foodmapcity;
	}

	public FoodMapCityRes() {

	}

	public FoodMapCityRes(FoodMapCity foodmapcity, String message) {
		this.foodmapcity = foodmapcity;
		this.message = message;
	}

	public FoodMapCityRes(String message) {
		this.message = message;
	}

	public List<FoodMapVo> getFoodVoList() {
		return foodVoList;
	}

	public void setFoodVoList(List<FoodMapVo> foodVoList) {
		this.foodVoList = foodVoList;
	}

	public FoodMapCityRes getFoodCity() {
		return foodCity;
	}

	public void setFoodCity(FoodMapCityRes foodCity) {
		this.foodCity = foodCity;
	}

	

}
