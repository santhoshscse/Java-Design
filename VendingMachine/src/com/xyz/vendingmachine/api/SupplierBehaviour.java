package com.xyz.vendingmachine.api;

import java.util.List;

import com.xyz.vendingmachine.model.Cash;
import com.xyz.vendingmachine.model.Item;
import com.xyz.vendingmachine.supplier.model.PurchaseStatement;

/**
 * @author santhoshsrinivasan
 *
 */
public interface SupplierBehaviour {

	List<Item> viewItemsFromStore();

	void addItemToStore(Item item);

	void removeItemFromStore(String itemId);

	void updateItemPrice(String itemId, int price);

	void updateItemQuantity(String itemId, int quantity);

	List<Cash> viewCashFromStore();

	void addCashToStore(Cash cash);

	List<Cash> collectCashFromStore();

	List<PurchaseStatement> viewPurchaseStatement();

	void resetStore();

}
