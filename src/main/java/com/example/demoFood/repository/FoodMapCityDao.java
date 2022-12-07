package com.example.demoFood.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoFood.entity.FoodMap;
import com.example.demoFood.entity.FoodMapCity;

@Repository
public interface FoodMapCityDao extends JpaRepository<FoodMapCity,String>{
	@Transactional	
//	public void deleteByShop(String shop);
//	  List<Person> findByLastnameOrderByFirstnameDesc(String lastname);
//	public List<FoodMapCity>findByshopFameOrderByAgeDesc(double shopFame );
//	public List<FoodMapCity>findByShopFameOrderByShopDesc(double shopFame );
//	public List<FoodMapCity>findByShopFameGreaterThanEqualDesc(double shopFame );
	public List<FoodMapCity>findByShopFameGreaterThanEqualOrderByShopFameDesc(double shopFame );

	public List<FoodMapCity> findByCity(String city);
	
	public List<FoodMapCity> findByShop(String shop);
}
