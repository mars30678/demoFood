package com.example.demoFood.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class FoodMapReq {

	private String shop;

	private String city;

	private Integer num;

	private double shopFame;

	private String food;

	private int price;

	private double foodFame;

	public double getShopFame() {
		return shopFame;
	}

	public void setShopFame(double shopFame) {
		this.shopFame = shopFame;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getFoodFame() {
		return foodFame;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setFoodFame(double foodFame) {
		this.foodFame = foodFame;
	}

	public FoodMapReq() {

	}

}
