package com.example.demoFood.service.imp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demoFood.constants.FoodMapRtnCode;
import com.example.demoFood.entity.FoodMap;
import com.example.demoFood.entity.FoodMapCity;
import com.example.demoFood.entity.FoodMapId;
import com.example.demoFood.repository.FoodMapCityDao;
import com.example.demoFood.repository.FoodMapDao;
import com.example.demoFood.service.ifs.FoodMapService;
import com.example.demoFood.vo.FoodMapCityRes;
import com.example.demoFood.vo.FoodMapRes;
import com.example.demoFood.vo.FoodMapVo;

@Service
public class FoodMapServiceImpl implements FoodMapService {
	@Autowired
	private FoodMapDao foodMapDao;
	@Autowired
	private FoodMapCityDao foodMapCityDao;

//    API one 需求城市店名評價新增修改功能,無須店家評價，店家平價由第二支API的食物評價平均來新增
	@Override
	public FoodMapCityRes fmcity(String city, String shop) {

		FoodMapCityRes chickRes = checkParams(city, shop);
		if (chickRes != null) {
			return chickRes;
		}

		Optional<FoodMapCity> cityOp = foodMapCityDao.findById(shop);
		if (cityOp.isPresent()) { // 修改-> 只需增加城市因為依題意不考慮分店問題
			FoodMapCity foodMapCity = new FoodMapCity(); // 相同的店名不同城市會直接被覆蓋,無須新增店家
			foodMapCity = cityOp.get(); // GET SET方法
			foodMapCity.setCity(city);
			foodMapCityDao.save(foodMapCity);
			return new FoodMapCityRes(FoodMapRtnCode.EDIT_SUCCESSFUL.getMessage());
		} else { // 新增-> 如果城市店家都不存在就新增進去
			FoodMapCity foodMapCity = new FoodMapCity(city, shop);// 使用建構方法
			foodMapCityDao.save(foodMapCity);
			return new FoodMapCityRes(FoodMapRtnCode.ADD_SUCCESSFUL.getMessage());
		}
		
	}

	private FoodMapCityRes checkParams(String city, String shop) {
		
		if (!StringUtils.hasText(city)) { // 防呆判定內容是否是null、“”、“ ”，是的話回傳message報錯
			return new FoodMapCityRes(FoodMapRtnCode.CITY_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(shop)) {
			return new FoodMapCityRes(FoodMapRtnCode.SHOP_REQUIRED.getMessage());
		}
		return null;

	}

	// API two

	@Override
	public FoodMapRes foodmap(String shop, String food, int price, double foodFame) {
		
		FoodMapRes chickRes = checkParams2(shop, food, price, foodFame);
		if (chickRes != null) {
			return chickRes;
		}
		
		FoodMap foodMap = new FoodMap();
		
		FoodMapId foodMapKey = new FoodMapId(shop, food);
		Optional<FoodMap> foodOp = foodMapDao.findById(foodMapKey);
		
		Optional<FoodMapCity> cityOp = foodMapCityDao.findById(shop);
		
		
		if (foodOp.isPresent()) {
			foodMap = foodOp.get();
//			new FoodMap(price,foodFame);
			foodMap.setPrice(price);
			foodMap.setFoodFame(foodFame);
			foodMapDao.save(foodMap);
			FoodMapCity fc = cityOp.get();
			double shopPoint = 0;
			List<FoodMap> foodList = foodMapDao.findByShop(shop);
			for (FoodMap foodL : foodList) {
				shopPoint += foodL.getFoodFame();
			}
			shopPoint = shopPoint / foodList.size();
			BigDecimal decimalC = new BigDecimal(Double.toString(shopPoint).substring(0, 3)); // 把double取到小數點後一位
			double decimalFame = decimalC.doubleValue();
			fc.setShopFame(decimalFame);
			foodMapCityDao.save(fc);
			return new FoodMapRes(FoodMapRtnCode.EDIT_SUCCESSFUL.getMessage());
		} else if (cityOp.isPresent()) {
			foodMap.setShop(shop);
			foodMap.setFood(food);
			foodMap.setPrice(price);
			foodMap.setFoodFame(foodFame);
			foodMapDao.save(foodMap);
			FoodMapCity fc = cityOp.get();
			double shopPoint = 0;
			List<FoodMap> foodList = foodMapDao.findByShop(shop);
			for (FoodMap foodL : foodList) {
				shopPoint += foodL.getFoodFame();
			}
			shopPoint = shopPoint / foodList.size();
//			DecimalFormat realShopPoint = new DecimalFormat("#.#");
//          realShopPoint.format();
			BigDecimal decimalC = new BigDecimal(Double.toString(shopPoint).substring(0, 3)); // 把double取到小數點後一位
			double decimalFame = decimalC.doubleValue(); // 把BigDecimal轉成double才能放進原有數據裡
//			String point = String.valueOf(shopPoint).substring(0, 3);
//			Double  decimalFame = Double.parseDouble(point);
			fc.setShopFame(decimalFame);
			foodMapCityDao.save(fc);
			return new FoodMapRes(FoodMapRtnCode.ADD_SUCCESSFUL.getMessage());
			
		} else {
			return null;
		}

	}

	// 抽出來
	private FoodMapRes checkParams2(String shop, String food, int price, double foodFame) {
		if (!StringUtils.hasText(shop)) {
			return new FoodMapRes(FoodMapRtnCode.SHOP_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(food)) {
			return new FoodMapRes(FoodMapRtnCode.FOOD_REQUIRED.getMessage());
		} else if (price == 0) {
			return new FoodMapRes(FoodMapRtnCode.PRICE_REQUIRED.getMessage());
		} else if (foodFame == 0) {
			return new FoodMapRes(FoodMapRtnCode.FOOD_FAME_REQUIRED.getMessage());
		} else if (foodFame > 5 || foodFame < 1) {
			return new FoodMapRes(FoodMapRtnCode.FOOD_FAME_OUT.getMessage());
		}
		return null;
	}

//            API three
	@Override
	public FoodMapCityRes findcity(String city, Integer num) {
		FoodMapCityRes res = new FoodMapCityRes();
		
	
		
		List<String> shoplist = new ArrayList<>();
		
		List<FoodMapVo> foodVoList = new ArrayList<>();
		
		List<FoodMapCity> cityList = foodMapCityDao.findByCity(city);
		if (cityList.isEmpty()) {
			return null;
		}
		
		for (FoodMapCity shopItem : cityList) {
			shoplist.add(shopItem.getShop());
		}

		
		for (FoodMapCity cityItem : cityList) {
			FoodMapVo foodMapVo = new FoodMapVo();
			foodMapVo.setFoodMapCity(cityItem);
			foodVoList.add(foodMapVo);
			List<FoodMap> foodList = foodMapDao.findByShopIn(shoplist);
			for (FoodMap foodItem : foodList) {
				if (cityItem.getShop().equalsIgnoreCase(foodItem.getShop())) {
					foodMapVo = new FoodMapVo();
					foodMapVo.setFoodMap(foodItem);
					foodVoList.add(foodMapVo);
				}
			}
		}

		if (num < 1 || num > foodVoList.size() || num == null || num == 0) {
			res.setFoodVoList(foodVoList.subList(0, num));
			return res;
		}
		res.setFoodVoList(foodVoList.subList(0, num));
		return res;
	}

	public List<String> findcity2(String city, Integer num) {
	List<String> shopList = new ArrayList<>();
	
	List<String> FoodMapList = new ArrayList<>(); 
	
	List<FoodMapCity> cityList = foodMapCityDao.findByCity(city);
	
	if (cityList.isEmpty()) {
		return null;
	}
	for (FoodMapCity shopItem : cityList) {
		shopList.add(shopItem.getShop());
	}

	
	for (FoodMapCity cityItem : cityList) {
		List<FoodMap> foodList = foodMapDao.findByShopIn(shopList);
		for (FoodMap foodItem : foodList) {
			if(cityItem.getShop().equalsIgnoreCase(foodItem.getShop())) {
				FoodMapList.add("城市:" + cityItem.getCity() + "店名:" + cityItem.getShop() + "店家評價:" + cityItem.getShopFame() + "餐點:"
					+ foodItem.getFood() + "餐點價格:" + foodItem.getPrice() + "餐點評價:" + foodItem.getFoodFame());
		}
	}
	}
	if (num < 1 || num > FoodMapList.size() || num == null || num == 0) {
		return FoodMapList;
	}
	return FoodMapList.subList(0, num);
}
	
	
	
	// API 3 原版
//	public List<String> findcity(String city, Integer num) {
//		List<String> shoplist = new ArrayList<>(); // new一個原始數據
//		List<FoodMapCity> cityList = foodMapCityDao.findByCity(city);
//		if (cityList.isEmpty()) {
//			return null;
//		}
//		for (FoodMapCity cityL : cityList) {
//			List<FoodMap> foodList = foodMapDao.findByShop(cityL.getShop());
//			for (FoodMap foodL : foodList) {
//				shoplist.add("城市:" + cityL.getCity() + "店名:" + cityL.getShop() + "店家評價:" + cityL.getShopFame() + "餐點:"
//						+ foodL.getFood() + "餐點價格:" + foodL.getPrice() + "餐點評價:" + foodL.getFoodFame());
//			}
//		}
//
//		if (num < 1 || num > shoplist.size() || num == null || num == 0) {
//			return shoplist;
//		}
//		return shoplist.subList(0, num);
//	}

//  API four
	public FoodMapCityRes findShopFameDesc(double shopFame) {
		FoodMapCityRes chickres = checkParams2(shopFame);//防呆抽成方法寫在下方
		if (chickres != null) {
			return chickres;
		}
		
		FoodMapCityRes res = new FoodMapCityRes();
		
		List<String> shoplist = new ArrayList<>();
		
		List<FoodMapVo> foodVoList = new ArrayList<>();

		List<FoodMapCity> shopFameList = foodMapCityDao.findByShopFameGreaterThanEqualOrderByShopFameDesc(shopFame);
		if (shopFameList.isEmpty()) {
			return null;
		}
		for (FoodMapCity shopItem : shopFameList) {
			shoplist.add(shopItem.getShop());
		}

		for (FoodMapCity fameItem : shopFameList) {
			FoodMapVo foodMapVo = new FoodMapVo();
			foodMapVo.setFoodMapCity(fameItem);
			foodVoList.add(foodMapVo);
		List<FoodMap> foodList = foodMapDao.findByShopIn(shoplist);
		for (FoodMap foodItem : foodList) {
		if (fameItem.getShop().equalsIgnoreCase(foodItem.getShop())) {
			foodMapVo = new FoodMapVo();
			foodMapVo.setFoodMap(foodItem);
			foodVoList.add(foodMapVo);
				}
			}
		}
		res.setFoodVoList(foodVoList);
		return res;
	}

	// 抽防呆
	private FoodMapCityRes checkParams2(double shopFame) {
		if (shopFame == 0) {
			return new FoodMapCityRes(FoodMapRtnCode.SHOP_FAME_REQUIRED.getMessage());
		} else if (shopFame > 5 || shopFame < 0) {
			return new FoodMapCityRes(FoodMapRtnCode.SHOP_FAME_OUT.getMessage());
		}
		return null;

	}

	@Override
	public FoodMapCityRes findShopFameandFoodFameDesc(double shopFame, double foodFame) {
		FoodMapCityRes res = new FoodMapCityRes();
		
		FoodMapCityRes chickres = checkParams4(shopFame, foodFame);
		if (chickres != null) {
			return chickres;
		}
		
		List<FoodMapVo> foodVoList = new ArrayList<>();
		
		List<String> shoplist = new ArrayList<>();
		
		List<FoodMapCity> shopFameList = foodMapCityDao.findByShopFameGreaterThanEqualOrderByShopFameDesc(shopFame);
		for (FoodMapCity shopItem : shopFameList) {
			shoplist.add(shopItem.getShop());
		}

		for (FoodMapCity ShopfameItem : shopFameList) {
			FoodMapVo foodMapVo = new FoodMapVo();
			foodMapVo.setFoodMapCity(ShopfameItem);
			foodVoList.add(foodMapVo);
			List<FoodMap> foodFameList = foodMapDao.findByShopInOrderByFoodFameDesc(shoplist);
			for (FoodMap foodFameItem : foodFameList) { 
				if (ShopfameItem.getShop().equalsIgnoreCase(foodFameItem.getShop())&& foodFameItem.getFoodFame()>= foodFame) {
					foodMapVo = new FoodMapVo();
					foodMapVo.setFoodMap(foodFameItem);
					foodVoList.add(foodMapVo);
				}
			}
		}
		
		res.setFoodVoList(foodVoList);
		return res;
	}

	// 抽出來
	private FoodMapCityRes checkParams4(double shopFame, double foodFame) {
		if (shopFame == 0 || foodFame == 0) {
			return new FoodMapCityRes(FoodMapRtnCode.FAME_REQUIRED.getMessage());
		} else if (shopFame > 5 || foodFame > 5 || shopFame < 0 || foodFame < 0) {
			return new FoodMapCityRes(FoodMapRtnCode.FAME_OUT.getMessage());
		}
		return null;
	}

//  API five 爛版會不斷抽插資料庫
//	@Override
//	public FoodMapCityRes findShopFameandFoodFameDesc(double shopFame, double foodFame) {
//		FoodMapCityRes res = new FoodMapCityRes();
//		FoodMapCityRes chickres = checkParams(shopFame,foodFame);
//		 if(chickres!= null){
//		 return chickres ;        		  
//		 } 
//		List<String> list = new ArrayList<>();
//		List<FoodMapCity> shopFameList = foodMapCityDao.findByShopFameGreaterThanEqualOrderByShopFameDesc(shopFame);
//		List<FoodMap> foodFameList = foodMapDao.findByFoodFameGreaterThanEqualOrderByFoodFameDesc(foodFame);
//		for (FoodMapCity fameL : shopFameList) {
//			for (FoodMap foodL : foodFameList) {
//				if (fameL.getShop().equals(foodL.getShop())) {
//					list.add("城市:" + fameL.getCity() + "店名:" + fameL.getShop() + "店家評價:" + fameL.getShopFame() + "餐點:"
//							+ foodL.getFood() + "餐點價格:" + foodL.getPrice() + "餐點評價:" + foodL.getFoodFame());
//				}
//			}
//		}
//		return res;
//	}

}
//API delete
//	@Override
//	public void deleteByShop(String shop) {
//		foodMapCityDao.deleteById(shop);
//	}
//
//	@Override
//	public void deleteByFood(String food) {
//		FoodMapId fi = new FoodMapId(food);
//		foodMapDao.deleteById(fi);
//	}
