package com.example.demoFood.constants;

public enum FoodMapRtnCode {
	SUCCESSFUL("200", "成功"), ADD_SUCCESSFUL("200", "新增成功"), EDIT_SUCCESSFUL("200", "修改成功"), NO_CHANGE("200", "修改成功"),
	FOOD_REQUIRED("400", "Food can't be null or empty!"), CITY_REQUIRED("400", "City can't be null or empty!"),
	SHOP_REQUIRED("400", "Shop can't be null or empty!"), PRICE_REQUIRED("400", "Price can't be null or empty!"),
	FOOD_FAME_REQUIRED("400", "Foodfame can't be null or empty!"), SHOP_NON_EXISTENT("403", "shop is non-existent"),
	CITY_NON_EXISTENT("403", "City is non-existent"), FAILURE("400", "  Failure"),
	SHOP_FAME_REQUIRED("400", "ShopFame can't be  empty!"), FOOD_FAME_OUT("400", "FoodFame out of range!"),
	SHOP_FAME_OUT("400", "ShopFame out of range!"), FAME_OUT("400", "Fame out of range!"),
	FAME_REQUIRED("400", "Fame can't be  empty!");

//		ADD_ROLE_FAILURE("400","add role failure"),
//		ROLE_LIST_IS_EMPTY("400","Role list is empty!!"),
//		ROLE_SET_IS_EMPTY("400","Role set is empty!!");
	private String code;
	private String message;

	private FoodMapRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
