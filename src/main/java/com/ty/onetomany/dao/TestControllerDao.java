package com.ty.onetomany.dao;

import java.util.ArrayList;
import java.util.List;

import com.ty.onetomany.dto.AmazonOrder;
import com.ty.onetomany.dto.Item;

public class TestControllerDao {

	public static void main(String[] args) {
		
		TestController testController = new  TestController();
		
		AmazonOrder  amazonOrder = new AmazonOrder();
		
		amazonOrder.setId(1);
		amazonOrder.setAddress("xyz abc");
		
		Item item1 = new Item();
		
		item1.setId(1);
		item1.setName("pen");
		item1.setCost(25);
		
Item item2 = new Item();
		
		item2.setId(2);
		item2.setName("pencil");
		item2.setCost(20);
		
		List<Item> list = new ArrayList<Item>();
		list.add(item1);
		list.add(item2);
		
		amazonOrder.setItems(list);
		
		testController.save(amazonOrder);
		
		

	}

}
