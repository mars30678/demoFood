package com.example.demoFood.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@Table(name= "foodmap")
@IdClass(value = FoodMapId.class)
public class FoodMap {
	@Id
	@Column(name ="shop")
	private String shop ;
	
	@Id
	@Column(name ="food")
	private String food ;
	
	@Column(name ="price")
	private int price ;
	
	@Column(name ="foodfame")
	private double foodFame ;
	
	 public FoodMap(String shop ,String food,int price, double foodFame) {
			this.food =food ;
			this.price =price ;
			this.shop =shop ;
			this.foodFame =foodFame ;
		}
	 public FoodMap(String shop ,String food,int price) {
			this.food =food ;
			this.price =price ;
			this.shop =shop ;
		
		}
	 public FoodMap(int price, double foodFame) {
		 this.price =price ;
		 this.foodFame =foodFame ;
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

	public void setFoodFame(double foodFame) {
		this.foodFame = foodFame;
	}
	 public FoodMap() {
		 
	 }
	 
}
