package com.example.demoFood;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demoFood.repository.OrdersInfo;
import com.example.demoFood.vo.OrdersDao;



@SpringBootTest(classes =DemoFoodApplication.class)
public class OrdersTest  {
	@Autowired
	private OrdersDao ordersDao;
	@Test                                 
	public void ordersInfoTest()  { //  throws JsonProcessingException
		List<OrdersInfo> result = ordersDao.findAllByOrdersInfo();
		for (OrdersInfo item : result) {
			System.out.println(item.getCustomerId());
			System.out.println(item.getName());
			System.out.println(item.getProductName());
			System.out.println(item.getQuantity());
		}
	}
	@Test
	public void findordersInfoTest() {
		List<OrdersInfo> result = ordersDao.findOrdersInfoByCustomerIdIn(4);
		for (OrdersInfo item : result) {
			System.out.println(item.getCustomerId());
			System.out.println(item.getName());
			System.out.println(item.getProductName());
			System.out.println(item.getQuantity());
		}
	}
	
}
