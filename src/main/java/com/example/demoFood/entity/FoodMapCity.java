package com.example.demoFood.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "foodcity")
public class FoodMapCity {
	@Column(name ="foodcity")
	private String city ;
	
	@Id
	@Column(name ="shop")
	private String shop ;
	
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
	
	public double getShopFame() {
		return shopFame;
	}
	public void setShopFame(double shopFame) {
		this.shopFame = shopFame;
	}

	@Column(name ="shopfame")
	private double shopFame;
	public  FoodMapCity() {
		
	}
    public  FoodMapCity(String city,String shop ) {
		this.city =city ;
		this.shop =shop ;
	
	}
	
}
