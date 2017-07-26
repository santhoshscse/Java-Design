package com.xyz.vendingmachine.api;

import com.xyz.vendingmachine.api.impl.VendingMachineImpl;

/**
 * @author santhoshsrinivasan
 *
 */
public class VendingMachineFactory {
	public static VendingMachine createInstance() {
		return new VendingMachineImpl();
	}
}
