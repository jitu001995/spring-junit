package com.jk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.model.Item;
import com.jk.repo.ItemRepository;

@Service
public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;
 
	public Item retrieveHarCodedItem(){
		return new Item(2,"Item2",20,20);
	}
	
	public List<Item> retrieveAllItem(){
		List<Item> items = repository.findAll();
		for(Item item:items) {
			item.setValuel(item.getPrice() * item.getQuantity());
		}
		return items;
	}
}
