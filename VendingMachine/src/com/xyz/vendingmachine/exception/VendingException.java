package com.xyz.vendingmachine.exception;

public class VendingException extends Exception {
	public enum ErroCode {
		productNotAvailable, amountNotPaid, noCashChange, notEnoughQuantity, unrecoginedDenomination;
	}

	private ErroCode code;
	private String data;

	public VendingException(ErroCode code, String data) {
		super();
		this.code = code;
		this.data = data;
	}

	public VendingException(ErroCode code) {
		super();
		this.code = code;
	}

	public String getMessage() {
		switch (code) {
		case productNotAvailable:
			return "Product not available";
		case amountNotPaid:
			return "Amount not paid fully";
		case noCashChange:
			return "Unable to dispense the change";
		case notEnoughQuantity:
			return "Not enough quantity available; " + data;
		case unrecoginedDenomination:
			return "Unrecognized denomination";
		default:
			return "Unknown message";
		}
	}
}
