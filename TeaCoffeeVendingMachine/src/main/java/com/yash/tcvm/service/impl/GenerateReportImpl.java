package com.yash.tcvm.service.impl;

import java.util.HashMap;
import java.util.List;

import com.yash.tcvm.dao.Product;
import com.yash.tcvm.dao.TotalSaleCost;
import com.yash.tcvm.service.interfaces.IReportService;

public class GenerateReportImpl implements IReportService {

	@Override
	public void prepareReport(Product product, HashMap<String, List> totalSale, Integer totalQuantitySold,
			Double totalPrice) {

		System.out.println("*****Tea-Cofee Sold*********");
		List<TotalSaleCost> totalSaleCost = totalSale.get("total_Sale_Cost");
		for (TotalSaleCost e : totalSaleCost) {
			System.out.println(e.getProductName() + ":" + e.getQuantity() + "cup :" + e.getCost());

		}
		System.out.println("*****Total Product soldout and price*********");
		System.out.println("Total cups:" + totalQuantitySold);
		System.out.println("Total:" + totalPrice + "/-");

		System.out.println("*****Available Quantity in Containers*********");
		System.out.println("Tea:" + product.getTeaContainerCapacity());
		System.out.println("Coffee:" + product.getCoffeeContainerCapacity());
		System.out.println("Water:" + product.getWaterContainerCapacity());
		System.out.println("Milk:" + product.getMilkContainerCapacity());
		System.out.println("Sugar:" + product.getSugarContainerCapacity());

		System.out.println("****Waste Of Products****");
		System.out.println("Tea Wasted:" + product.getTeaWasteAmount());
		System.out.println("Coffee Wasted:" + product.getCoffeeWasteAmount());
		System.out.println("Water Wasted:" + product.getWaterWasteAmount());
		System.out.println("Sugar Wasted:" + product.getSugarWasteAmount());
		System.out.println("Milk Wasted:" + product.getMilkWasteAmount());

	}

}
