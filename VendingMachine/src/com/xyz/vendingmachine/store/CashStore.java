package com.xyz.vendingmachine.store;

import java.util.LinkedHashMap;
import java.util.Map;

import com.xyz.vendingmachine.model.Cash;

/**
 * @author santhoshsrinivasan
 * 
 *         This class to check the store cash. Singleton is to avoid creating
 *         any instance.
 *
 */

public class CashStore {
	private Map<String, Cash> cashStore = new LinkedHashMap<>();

	private static CashStore INSTANCE = new CashStore();

	/**
	 * 
	 */
	private CashStore() {
		// TODO Auto-generated constructor stub
		// Load with default cash
	}
}
