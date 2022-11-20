package com.jk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jk.model.Item;
import com.jk.service.ItemBusinessService;

@RestController
public class ItemController {
   
	@Autowired
	private ItemBusinessService businessService;

    
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1,"ball",10,20);
	}
	
	@GetMapping("/service")
	public Item service() {
		return businessService.retrieveHarCodedItem();
	}
	
	@GetMapping("/getAll")
	public List<Item> retrieveAllItem(){
		return businessService.retrieveAllItem();
	}
}
