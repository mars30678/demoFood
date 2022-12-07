package com.example.demoFood;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoFoodApplicationTests {
	
	
	
	
	@Test
	   public int[] twoSumss(int[] nums, int target) {
		int count = 0 ;
		for(int i =0 ; i < nums.length; i++) {
			int num1 = nums[i];
			for(int j = i+1; j< nums.length; j++) {
				count ++ ;
				int num2 = nums[j];
				if(num1+num2==target) {
					System.out.println(count);
					return new int[] {i,j};
			}
		
		
		}
			
	}
		return nums;
	}
	@Test
	   public int[] twoSum(int[] nums, int target) { 
	       Map<Integer,Integer>map = new HashMap<>();
	         int count = 0 ;
	        for(int i =0 ; i< nums.length; i++){
	           count++; 
	            int complement = target - nums[i];
	            if(map.containsKey(complement)){
	            	System.out.println(count);
	                return new int [] {map.get(complement),i};
	            }
	            map.put(nums[i], i);
	        }
	       return null ;
	    }
	

}
