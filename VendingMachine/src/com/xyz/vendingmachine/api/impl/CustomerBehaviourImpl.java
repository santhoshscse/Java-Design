package com.xyz.vendingmachine.api.impl;

import java.util.List;

import com.xyz.vendingmachine.api.CustomerBehaviour;
import com.xyz.vendingmachine.customer.model.Box;
import com.xyz.vendingmachine.customer.model.Payment;
import com.xyz.vendingmachine.model.CashDenomination;
import com.xyz.vendingmachine.model.Item;

/**
 * @author santhoshsrinivasan
 *
 */
class CustomerBehaviourImpl implements CustomerBehaviour {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.CustomerBehaviour#viewItemsFromStore()
	 */
	@Override
	public List<Item> viewItemsFromStore() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xyz.vendingmachine.api.CustomerBehaviour#addItemToCart(java.lang.
	 * String)
	 */
	@Override
	public void addItemToCart(String itemId, int quantity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.CustomerBehaviour#viewItemsFromCart()
	 */
	@Override
	public List<Item> viewItemsFromCart() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xyz.vendingmachine.api.CustomerBehaviour#deleteItemFromCart(java.lang
	 * .String)
	 */
	@Override
	public void deleteItemFromCart(String itemId) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xyz.vendingmachine.api.CustomerBehaviour#changeItemQuanityFromCart(
	 * java.lang.String, int)
	 */
	@Override
	public void changeItemQuanityFromCart(String itemId, int quantity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.CustomerBehaviour#addCashToCart(com.xyz.
	 * vendingmachine.model.CashDenomination, int)
	 */
	@Override
	public void addCashToCart(String cashDenomination, int quantity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xyz.vendingmachine.api.CustomerBehaviour#viewPaymentInfoFromCart()
	 */
	@Override
	public Payment viewPaymentInfoFromCart() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.CustomerBehaviour#checkoutCart()
	 */
	@Override
	public Box checkoutCart() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.CustomerBehaviour#cancelPurchase()
	 */
	@Override
	public Box cancelPurchase() {
		// TODO Auto-generated method stub
		return null;
	}

}
