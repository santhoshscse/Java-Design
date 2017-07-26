package com.xyz.vendingmachine.api;

/**
 * @author santhoshsrinivasan
 *
 */
public interface VendingMachine {
	SupplierBehaviour getSupplierContext();

	CustomerBehaviour getCustomerContext();
}
