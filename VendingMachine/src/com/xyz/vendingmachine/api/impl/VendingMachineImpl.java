package com.xyz.vendingmachine.api.impl;

import com.xyz.vendingmachine.api.CustomerBehaviour;
import com.xyz.vendingmachine.api.SupplierBehaviour;
import com.xyz.vendingmachine.api.VendingMachine;

/**
 * @author santhoshsrinivasan
 *
 */
public class VendingMachineImpl implements VendingMachine {

	SupplierBehaviour supplier = new SupplierBehaviourImpl();
	CustomerBehaviour customer = new CustomerBehaviourImpl();

	@Override
	public SupplierBehaviour getSupplierContext() {
		return supplier;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.VendingMachine#getCustomerBehaviourImpl()
	 */
	@Override
	public CustomerBehaviour getCustomerContext() {
		// TODO Auto-generated method stub
		return customer;
	}

}
