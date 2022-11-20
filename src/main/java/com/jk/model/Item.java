package com.jk.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity 
@NoArgsConstructor
public class Item {
	@Id
     private int id;
     private String name;
     private int price;
     private int quantity;
     
     @Transient
     private int valuel;

	public Item(int id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
     
	
}
