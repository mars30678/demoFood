package com.example.demoFood.service.ifs;

import java.util.List;

import com.example.demoFood.entity.FoodMap;
import com.example.demoFood.entity.FoodMapCity;
import com.example.demoFood.vo.FoodMapCityRes;
import com.example.demoFood.vo.FoodMapRes;

public interface FoodMapService {

	public FoodMapCityRes fmcity(String city, String shop);

	public FoodMapRes foodmap(String shop, String food, int price, double foodFame);

//	public  List<String> findcity(String city, Integer num);
	public  FoodMapCityRes findcity(String city, Integer num);
	
	 public List<String> findcity2(String city, Integer num);
	public  FoodMapCityRes findShopFameDesc(double shopFame);

	public FoodMapCityRes findShopFameandFoodFameDesc(double shopFame, double foodFame);
// public void deleteByFood(String food);
// public void deleteByShop(String shop);

	

// public List<String> 

}
