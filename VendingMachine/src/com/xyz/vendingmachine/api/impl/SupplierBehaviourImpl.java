package com.xyz.vendingmachine.api.impl;

import java.util.List;

import com.xyz.vendingmachine.api.SupplierBehaviour;
import com.xyz.vendingmachine.model.Cash;
import com.xyz.vendingmachine.model.Item;
import com.xyz.vendingmachine.supplier.model.PurchaseStatement;

/**
 * @author santhoshsrinivasan
 *
 */
class SupplierBehaviourImpl implements SupplierBehaviour {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.SupplierBehaviour#viewItemsFromStore()
	 */
	@Override
	public List<Item> viewItemsFromStore() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.SupplierBehaviour#addItemToStore(com.xyz.
	 * vendingmachine.model.Item)
	 */
	@Override
	public void addItemToStore(Item item) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xyz.vendingmachine.api.SupplierBehaviour#removeItemFromStore(java.
	 * lang.String)
	 */
	@Override
	public void removeItemFromStore(String itemId) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xyz.vendingmachine.api.SupplierBehaviour#updateItemPrice(java.lang.
	 * String, int)
	 */
	@Override
	public void updateItemPrice(String itemId, int price) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xyz.vendingmachine.api.SupplierBehaviour#updateItemQuantity(java.lang
	 * .String, int)
	 */
	@Override
	public void updateItemQuantity(String itemId, int quantity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.SupplierBehaviour#viewCashFromStore()
	 */
	@Override
	public List<Cash> viewCashFromStore() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.SupplierBehaviour#addCashToStore(com.xyz.
	 * vendingmachine.model.Cash)
	 */
	@Override
	public void addCashToStore(Cash cash) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.SupplierBehaviour#collectCashFromStore()
	 */
	@Override
	public List<Cash> collectCashFromStore() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.SupplierBehaviour#viewPurchaseStatement()
	 */
	@Override
	public List<PurchaseStatement> viewPurchaseStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyz.vendingmachine.api.SupplierBehaviour#resetStore()
	 */
	@Override
	public void resetStore() {
		// TODO Auto-generated method stub

	}

}
