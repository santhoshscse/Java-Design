package com.xyz.vendingmachine.model;

/**
 * @author santhoshsrinivasan
 *
 */
public class Cash {

	private CashDenomination cashDenomination;
	private int quantity;

	public Cash(CashDenomination cashDenomination, int quantity) {
		super();
		this.cashDenomination = cashDenomination;
		this.quantity = quantity;
	}

}
