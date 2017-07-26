package com.xyz.vendingmachine.api;

/**
 * @author santhoshsrinivasan
 *
 */
import java.util.List;

import com.xyz.vendingmachine.customer.model.Box;
import com.xyz.vendingmachine.customer.model.Payment;
import com.xyz.vendingmachine.model.CashDenomination;
import com.xyz.vendingmachine.model.Item;

public interface CustomerBehaviour {

	List<Item> viewItemsFromStore();

	void addItemToCart(String itemId, int quantity);

	List<Item> viewItemsFromCart();

	void deleteItemFromCart(String itemId);

	void changeItemQuanityFromCart(String itemId, int quantity);

	void addCashToCart(String cash, int quantity);

	Payment viewPaymentInfoFromCart();

	Box checkoutCart();

	Box cancelPurchase();
}
