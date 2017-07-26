package com.xyz.vendingmachine.model;

/*
 * ItemMeta properties are separated from Item, because quantity differs for both supplier and customer
 * 
 * */
public class ItemMeta {
	private String id;
	private String name;
	private int price;

	public ItemMeta(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

}
