package com.yash.TeaCoffeeVendingMachine;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.tcvm.service.impl.PaymentImpl;

@RunWith(MockitoJUnitRunner.class)
public class PaymentTest {

	@InjectMocks
	private PaymentImpl payBill;

	@Test
	public void calculatePriceForOrderShouldReturnAmountToBeReturnedToCustomer() {

		PaymentImpl payBillForOrder = Mockito.mock(PaymentImpl.class);

		Mockito.doCallRealMethod().when(payBillForOrder).calculatePriceForOrder("Tea", 10.0, 5, 50);

		Assert.assertEquals(0.0, payBillForOrder.calculatePriceForOrder("Tea", 10.0, 5, 50), 0);

	}

}
