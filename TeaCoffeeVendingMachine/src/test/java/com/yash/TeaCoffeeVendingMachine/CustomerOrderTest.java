package com.yash.TeaCoffeeVendingMachine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.tcvm.TeaCoffeeVendingMachine.CustomerOrder;
import com.yash.tcvm.dao.InputScanner;
import com.yash.tcvm.dao.Product;
import com.yash.tcvm.service.impl.ContainerOperationsImpl;
import com.yash.tcvm.service.impl.GenerateReportImpl;
import com.yash.tcvm.service.impl.PaymentImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerOrderTest {

	@InjectMocks
	private CustomerOrder customerOrder;

	@Mock
	private Product product;

	@Mock
	private ContainerOperationsImpl containerOperations;

	@Mock
	private PaymentImpl payBill;

	@Mock
	private InputScanner inputScanner;

	@Mock
	private GenerateReportImpl generateReportImpl;

	@Test
	public void getMenuShouldAllowToOrderTea() {

		Product product1 = new Product();

		Mockito.when(containerOperations.checkAvailabilty("Tea", 1, product1)).thenReturn(true);
		Mockito.when(payBill.calculatePriceForOrder("Tea", 10.0, 1, 10)).thenReturn(0.0);
		Mockito.doNothing().when(containerOperations).adjustContainerQuantity("Tea", 1, product1);
		Mockito.when(inputScanner.nextInt()).thenReturn(1).thenReturn(1).thenReturn(10);

		customerOrder.getMenu(product1);

	}

	@Test
	public void getMenuShouldAllowToOrderBlackTea() {

		Product product1 = new Product();

		Mockito.when(containerOperations.checkAvailabilty("Black Tea", 1, product1)).thenReturn(true);
		Mockito.when(payBill.calculatePriceForOrder("Black Tea", 5.0, 1, 5)).thenReturn(0.0);
		Mockito.doNothing().when(containerOperations).adjustContainerQuantity("Black Tea", 1, product1);
		Mockito.when(inputScanner.nextInt()).thenReturn(2).thenReturn(1).thenReturn(5);

		customerOrder.getMenu(product1);

		assertTrue(containerOperations.checkAvailabilty("Black Tea", 1, product1));

	}

	@Test
	public void getMenuShouldAllowToOrderCoffee() {

		Product product1 = new Product();

		Mockito.when(containerOperations.checkAvailabilty("Coffee", 1, product1)).thenReturn(true);
		Mockito.when(payBill.calculatePriceForOrder("Coffee", 15.0, 1, 15)).thenReturn(0.0);
		Mockito.doNothing().when(containerOperations).adjustContainerQuantity("Coffee", 1, product1);
		Mockito.when(inputScanner.nextInt()).thenReturn(3).thenReturn(1).thenReturn(15);

		customerOrder.getMenu(product1);

		assertTrue(containerOperations.checkAvailabilty("Coffee", 1, product1));

	}

	@Test
	public void getMenuShouldAllowToOrderBlackCoffee() {

		Product product1 = new Product();

		Mockito.when(containerOperations.checkAvailabilty("Black Coffee", 1, product1)).thenReturn(true);
		Mockito.when(payBill.calculatePriceForOrder("Black Coffee", 10.0, 1, 10)).thenReturn(0.0);
		Mockito.doNothing().when(containerOperations).adjustContainerQuantity("Black Coffee", 1, product1);
		Mockito.when(inputScanner.nextInt()).thenReturn(4).thenReturn(1).thenReturn(10);

		customerOrder.getMenu(product1);

		assertTrue(containerOperations.checkAvailabilty("Black Coffee", 1, product1));

	}

	@Test
	public void getMenuShouldAllowToOrderResetContainers() {

		Product product1 = new Product();

		Mockito.doNothing().when(containerOperations).resetContainer(product1);
		Mockito.when(inputScanner.nextInt()).thenReturn(5).thenReturn(1);

		customerOrder.getMenu(product1);

		Mockito.verify(containerOperations).resetContainer(product1);

	}

	@Test
	public void getMenuShouldAllowToOrderRefillContainers() {

		Product product1 = new Product();

		product1.setTeaContainerCapacity(1000);

		Mockito.doNothing().when(containerOperations).reFillContainer(1, product1);
		Mockito.when(inputScanner.nextInt()).thenReturn(6).thenReturn(1).thenReturn(1);

		customerOrder.getMenu(product1);

		Mockito.verify(containerOperations).reFillContainer(1, product1);

	}

	@Test
	public void getMenuShouldAllowToCheckContainersStatus() {

		Product product1 = new Product();

		Mockito.doNothing().when(containerOperations).checkContainerStatus(product1);
		Mockito.when(inputScanner.nextInt()).thenReturn(7).thenReturn(1);

		customerOrder.getMenu(product1);

		Mockito.verify(containerOperations).checkContainerStatus(product1);

	}

	@Test
	public void getMenuShouldAllowToGenerateReport() {

		Product product1 = new Product();

		HashMap<String, List> totalSalePerProduct = new HashMap<String, List>();

		Mockito.doNothing().when(generateReportImpl).prepareReport(product1, totalSalePerProduct, 0, 0.0);
		Mockito.when(inputScanner.nextInt()).thenReturn(8).thenReturn(1);

		customerOrder.getMenu(product1);

	}

	@Test
	public void getMenuShouldHandleExceptionWhenAvalabilityIsFalse() {

		Product product1 = new Product();

		Mockito.when(containerOperations.checkAvailabilty("Tea", 10, product1)).thenReturn(false);

		Mockito.when(inputScanner.nextInt()).thenReturn(1).thenReturn(10).thenReturn(1);

		customerOrder.getMenu(product1);

		assertFalse(containerOperations.checkAvailabilty("Tea", 10, product1));

	}

	@Test
	public void getMenuShouldAskForMenuWhenInputIsInvalid() {

		Product product1 = new Product();

		Mockito.when(inputScanner.nextInt()).thenReturn(10).thenReturn(1);

		customerOrder.getMenu(product1);

	}

	@Test
	public void getMenuShouldReturnExtraAmountWhenInserted() {

		Product product1 = new Product();
		
		Mockito.when(inputScanner.nextInt()).thenReturn(1).thenReturn(1).thenReturn(12).thenReturn(1);
		Mockito.when(containerOperations.checkAvailabilty("Tea", 1, product1)).thenReturn(true);
		Mockito.when(payBill.calculatePriceForOrder("Tea", 10.0, 1, 12)).thenReturn(2.0);
		Mockito.doNothing().when(containerOperations).adjustContainerQuantity("Tea", 1, product1);
		
		customerOrder.getMenu(product1);
	}
	
	@Test
	public void shouldReturnCustomerOrder(){
		CustomerOrder customer = new CustomerOrder();
	}
	
	@Test
	public void shouldExitFromSystemCustomerOrder(){
		
		Product product1 = new Product();
		Mockito.when(inputScanner.nextInt()).thenReturn(9);
		
		customerOrder.getMenu(product1);
		
		
		
		
	}

}
