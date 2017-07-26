package com.xyz.vendingmachine.store;

import java.util.LinkedHashMap;
import java.util.Map;

import com.xyz.vendingmachine.model.Item;

/**
 * @author santhoshsrinivasan
 * 
 *         This class to check the availability of item, update price/quantity.
 *         Singleton is to avoid creating any instance.
 *
 */

public class ItemStore {
	private Map<String, Item> itemStore = new LinkedHashMap<>();

	private static ItemStore INSTANCE = new ItemStore();

	/**
	 * 
	 */
	private ItemStore() {
		// TODO Auto-generated constructor stub
		// Load with default items
	}
}
