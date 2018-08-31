package com.yash.tcvm.TeaCoffeeVendingMachine;

import com.yash.tcvm.dao.Product;

public class TeaCoffeeVendingMachine {

	public static void main(String[] args) {
		Product product = new Product();

		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.getMenu(product);

	}

}
