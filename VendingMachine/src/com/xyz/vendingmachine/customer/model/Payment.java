package com.xyz.vendingmachine.customer.model;

import java.util.List;

import com.xyz.vendingmachine.model.Cash;

public class Payment {

	List<Cash> paidList;

	int totalBillAmount;

	int balanceToReturn;
}
