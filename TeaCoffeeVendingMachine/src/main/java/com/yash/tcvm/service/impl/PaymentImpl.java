package com.yash.tcvm.service.impl;

import com.yash.tcvm.service.interfaces.IPaymentService;

public class PaymentImpl implements IPaymentService {

	@Override
	public double calculatePriceForOrder(String orderType, Double costPerCup, Integer orderQuantity,
			Integer insertedAmount) {

		return costPerCup * orderQuantity - insertedAmount;

	}

}
