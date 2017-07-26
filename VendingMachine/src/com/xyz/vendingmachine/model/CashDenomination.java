package com.xyz.vendingmachine.model;

public enum CashDenomination {
	TWOTHOUSAND(2000);

	private int value;

	private CashDenomination(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param denomination
	 * @return
	 */
	public static CashDenomination get(int denomination) {
		return null;
	}
}
