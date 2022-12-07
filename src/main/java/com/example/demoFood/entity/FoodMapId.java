package com.example.demoFood.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FoodMapId implements Serializable{
	private String food ;
	   private String shop ;
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	 public FoodMapId() {
		 
	 }
  public FoodMapId( String food ) {
	  super();
		 this.food =food ;
	 }
  public FoodMapId( String shop,String food ) {
	  super();
	  this.shop =shop ;
		 this.food =food ;
	 }
}
