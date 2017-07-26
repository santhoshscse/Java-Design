package com.xyz.vending.test;

import java.util.Scanner;

import com.xyz.vendingmachine.api.CustomerBehaviour;
import com.xyz.vendingmachine.api.SupplierBehaviour;
import com.xyz.vendingmachine.api.VendingMachine;
import com.xyz.vendingmachine.api.VendingMachineFactory;
import com.xyz.vendingmachine.model.Cash;
import com.xyz.vendingmachine.model.CashDenomination;
import com.xyz.vendingmachine.model.Item;
import com.xyz.vendingmachine.model.ItemMeta;

public class VendingMachineExample {

	private static VendingMachine vm = VendingMachineFactory.createInstance();
	private static SupplierBehaviour supplier = vm.getSupplierContext();
	private static CustomerBehaviour customer = vm.getCustomerContext();

	public static void main(String[] args) {
		while (true) {
			System.out.println("Select option 1.Supplier, 2.Customer 3.Exit");
			Scanner sc = new Scanner(System.in);
			int op = Integer.parseInt(sc.nextLine());
			if (op == 1) {
				displaySupplierOption(sc);
			} else if (op == 2) {
				displayCustomerOption(sc);
			} else {
				System.out.println("Thank you!!");
				break;
			}
		}
	}

	private static void displayCustomerOption(Scanner sc) {
		while (true) {
			System.out.println(
					"Select option 1.select product, 2.list selected product 3.list available products 4.pay cash 5. confirm purchase 6.refund 7. exit");
			int op = Integer.parseInt(sc.nextLine());
			if (op == 1) {
				displaySelectProductOption(sc);
			} else if (op == 2) {
				displaySelectProductList();
			} else if (op == 3) {
				displayListProduct();
			} else if (op == 4) {
				displayPayCashOption(sc);
			} else if (op == 5) {
				displayConfirmOption();
			} else if (op == 6) {
				displayRefundOption();
			} else {
				break;
			}
		}

	}

	private static void displayRefundOption() {
		System.out.println("Refunding cash:" + customer.cancelPurchase());
	}

	private static void displayConfirmOption() {
		System.out.println(customer.checkoutCart());
	}

	private static void displayPayCashOption(Scanner sc) {
		System.out.println("Enter the demonination you want to pay: ");
		String cash = sc.nextLine();
		System.out.println("Enter quantity :");
		int quantity = Integer.parseInt(sc.nextLine());
		customer.addCashToCart(cash, quantity);
	}

	private static void displaySelectProductList() {
		System.out.println(customer.viewItemsFromCart());
	}

	private static void displaySelectProductOption(Scanner sc) {
		System.out.println("Enter product id :");
		String itemId = sc.nextLine();
		System.out.println("Enter product quantity :");
		int quantity = Integer.parseInt(sc.nextLine());
		customer.addItemToCart(itemId, quantity);
	}

	private static void displaySupplierOption(Scanner sc) {
		while (true) {
			System.out.println(
					"Select option 1.add product, 2.list product from store 3. add cash 4. list cash inventory 5.Exit");
			int op = Integer.parseInt(sc.nextLine());
			if (op == 1) {
				displayAddProductOption(sc);
			} else if (op == 2) {
				displayListProduct();
			} else if (op == 3) {
				displayAddCashOption(sc);
			} else if (op == 5) {
				displayCashInventory();
			} else {
				break;
			}
		}
	}

	private static void displayCashInventory() {
		System.out.println(supplier.viewCashFromStore());
	}

	private static void displayAddCashOption(Scanner sc) {
		System.out.println("Enter the denomination to add:");
		int denomination = Integer.parseInt(sc.nextLine());
		System.out.println("Enter product quantity :");
		int quantity = Integer.parseInt(sc.nextLine());
		supplier.addCashToStore(new Cash(CashDenomination.get(denomination), quantity));
	}

	private static void displayListProduct() {
		System.out.println(supplier.viewItemsFromStore());
	}

	private static void displayAddProductOption(Scanner sc) {
		System.out.println("Enter product name :");
		String name = sc.nextLine();
		System.out.println("Enter product price :");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("Enter product quantity :");
		int quantity = Integer.parseInt(sc.nextLine());

		supplier.addItemToStore(new Item(new ItemMeta(name, name, price), quantity));
	}
}
