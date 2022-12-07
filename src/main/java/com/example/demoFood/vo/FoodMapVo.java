package com.example.demoFood.vo;

import com.example.demoFood.entity.FoodMap;
import com.example.demoFood.entity.FoodMapCity;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodMapVo {
	private FoodMapCity foodMapCity ;
	private FoodMap foodMap ;
	public FoodMapCity getFoodMapCity() {
		return foodMapCity;
	}
	public void setFoodMapCity(FoodMapCity foodMapCity) {
		this.foodMapCity = foodMapCity;
	}
	public FoodMap getFoodMap() {
		return foodMap;
	}
	public void setFoodMap(FoodMap foodMap) {
		this.foodMap = foodMap;
	}
	
	
	
}
