package com.example.demoFood.repository;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoFood.entity.FoodMap;

import com.example.demoFood.entity.FoodMapId;

@Repository
public interface FoodMapDao extends JpaRepository<FoodMap,FoodMapId> {
	@Transactional	
//	public void deleteByFood(String food);
	public List<FoodMap> findByShop(String shop);
	public List<FoodMap>findByShopIn(List<String>shoplist);
	public List<FoodMap>findByShopInOrderByFoodFameDesc(List<String>shoplist);
//	public List<FoodMap>findByFoodFameGreaterThanEqualOrderByFoodFameDesc( double foodFame);
//	public List<FoodMap>findByFoodFameGreaterThanEqualOrderByShopDesc( double foodFame);
}
