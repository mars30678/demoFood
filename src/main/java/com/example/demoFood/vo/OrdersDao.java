package com.example.demoFood.vo;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demoFood.entity.Orders;
import com.example.demoFood.repository.OrdersInfo;

@Repository
@Transactional
public interface OrdersDao extends JpaRepository<Orders, Integer> {
	
	
//	@Transactional
	@Modifying
    @Query("select  new com.example.demo_project.vo.OrdersInfo( set c.name ,o.productName  ,o.quantity ,  o.customerId  )"+
	  " from  Customers c join Orders o"
           + " on o.customer_id = c.id")  
	public List<OrdersInfo> findAllByOrdersInfo();
	
	@Modifying
    @Query("select  new com.example.demo_project.vo.OrdersInfo( set c.name ,o.productName  ,o.quantity ,  o.customerId  )"+
    		  " from  Customers c join Orders o"
    	           + " on o.customer_id = c.id" +"where c.id = :id") 
    public List<OrdersInfo> findOrdersInfoByCustomerIdIn(@Param("id") int customerId);
//	public int updateRegisterInfo(  // @Param("名稱")要跟query冒號後的名稱相同可自定義
//		@Param("newName")String newName,
//		@Param("newQuantity")int newQuantity,
//		@Param("newCustomerId")int newCustomerId,
//		@Param("account")int id );
	
// public List<OrdersInfo> findAllByCustomersId();
// 
// public List<OrdersInfo> findOrdersInfoByCustomersIdIn();
 
 
 
}
