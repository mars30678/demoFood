package com.example.demoFood.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoFood.constants.FoodMapRtnCode;
import com.example.demoFood.entity.FoodMap;
import com.example.demoFood.entity.FoodMapCity;
import com.example.demoFood.service.ifs.FoodMapService;
import com.example.demoFood.vo.FoodMapCityRes;
import com.example.demoFood.vo.FoodMapReq;
import com.example.demoFood.vo.FoodMapRes;

import org.springframework.util.StringUtils;

@CrossOrigin
@RestController
public class FoodMapController {
	@Autowired
	FoodMapService foodMapService;

	@PostMapping(value = "/api/foodmapshop")
	public FoodMapCityRes foodcity(@RequestBody FoodMapReq req) {
		return foodMapService.fmcity(req.getCity(), req.getShop());

	}

	@PostMapping(value = "/api/foodmap")
	public FoodMapRes createFood(@RequestBody FoodMapReq req) {
		FoodMapRes fm = foodMapService.foodmap(req.getShop(), req.getFood(), req.getPrice(), req.getFoodFame());
		if (fm == null) {
			return new FoodMapRes(FoodMapRtnCode.SHOP_NON_EXISTENT.getMessage());
		}
		return fm;
	}

//	@PostMapping(value = "/api/findCity")
//	public FoodMapCityRes findCity(@RequestBody FoodMapReq req) {
//		if (!StringUtils.hasText(req.getCity())) {
//			return new FoodMapCityRes(FoodMapRtnCode.CITY_REQUIRED.getMessage());
//		}
//		List<String> foodCity = foodMapService.findcity(req.getCity(), req.getNum());
//		if (foodCity == null) {
//			return new FoodMapCityRes(FoodMapRtnCode.CITY_NON_EXISTENT.getMessage());
//		}
//		return  new FoodMapCityRes(FoodMapRtnCode.SUCCESSFUL.getMessage(),foodCity);
//
//	}
	
	@PostMapping(value = "/api/findCity")
	public FoodMapCityRes findCity(@RequestBody FoodMapReq req) {
		if (!StringUtils.hasText(req.getCity())) {
			return new FoodMapCityRes(FoodMapRtnCode.CITY_REQUIRED.getMessage());
		}
		FoodMapCityRes foodCity = foodMapService.findcity(req.getCity(), req.getNum());
		if (foodCity == null) {
			return new FoodMapCityRes(FoodMapRtnCode.CITY_NON_EXISTENT.getMessage());
		}
		return  new FoodMapCityRes(FoodMapRtnCode.SUCCESSFUL.getMessage(),foodCity);

	}
	
	
	
	@PostMapping(value = "/api/findCity2")
	public FoodMapCityRes findCity2(@RequestBody FoodMapReq req) {
		if (!StringUtils.hasText(req.getCity())) {
			return new FoodMapCityRes(FoodMapRtnCode.CITY_REQUIRED.getMessage());
		}
		List<String> foodCity = foodMapService.findcity2(req.getCity(), req.getNum());
		if (foodCity == null) {
			return new FoodMapCityRes(FoodMapRtnCode.CITY_NON_EXISTENT.getMessage());
		}
		return  new FoodMapCityRes(FoodMapRtnCode.SUCCESSFUL.getMessage(),foodCity);

	}

	@PostMapping(value = "/api/findShopfame")
	public FoodMapCityRes findShopfame(@RequestBody FoodMapReq req) {

		FoodMapCityRes foodCity = foodMapService.findShopFameDesc(req.getShopFame());
		if (foodCity == null) {
			return new FoodMapCityRes(FoodMapRtnCode.SHOP_NON_EXISTENT.getMessage());
		}
		
		return  new FoodMapCityRes(FoodMapRtnCode.SUCCESSFUL.getMessage(),foodCity);

	}

	@PostMapping(value = "/api/findShopfameandFoodFame")
	public FoodMapCityRes findShopFameandFoodFame(@RequestBody FoodMapReq req) {
	
		FoodMapCityRes foodCity = foodMapService.findShopFameandFoodFameDesc(req.getShopFame(), req.getFoodFame());
		if (foodCity == null) {
			return new FoodMapCityRes(FoodMapRtnCode.SHOP_NON_EXISTENT.getMessage());
		}
		return  new FoodMapCityRes(FoodMapRtnCode.SUCCESSFUL.getMessage(),foodCity);

	}

	@PostMapping(value = "/api/list")
	public FoodMapCityRes list(@RequestBody FoodMapReq req) {
		FoodMapCityRes res = new FoodMapCityRes(); 
		List<String> testList = new ArrayList<>();
		testList.add("good");
		testList.add("Tea");
		res.setList(testList);
		return res;
	}
}
//@PostMapping(value = "/api/findShopfameandFoodFame")
//public FoodMapCityRes findShopFameandFoodFame(@RequestBody FoodMapReq req) {
//
//	List<String> fc = foodMapService.findShopFameandFoodFameDesc(req.getShopFame(), req.getFoodFame());
//	if (fc == null) {
//		return new FoodMapCityRes(FoodMapRtnCode.SHOP_NON_EXISTENT.getMessage());
//	}
//	return new FoodMapCityRes(FoodMapRtnCode.SUCCESSFUL.getMessage(), fc);
//
//}
//
//}



//@PostMapping(value = "/api/deletefood")
//public void deleteFood(@RequestBody FoodMapReq  req) {
//	 foodMapService.deleteByFood(req.getFood());
//}
//@PostMapping(value = "/api/deleteshop")
//public void deleteShop(@RequestBody FoodMapReq  req) {
//	 foodMapService.deleteByShop(req.getShop());
//}
//
