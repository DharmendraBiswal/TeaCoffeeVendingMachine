package com.yash.TeaCoffeeVendingMachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.tcvm.dao.Product;
import com.yash.tcvm.service.impl.ContainerOperationsImpl;

@RunWith(MockitoJUnitRunner.class)
public class ContainerOperationsTest {

	@InjectMocks
	private ContainerOperationsImpl containerOperations;

	@Mock
	private Product product;

	@Test
	public void adjustContainerQuantityShouldUpdateQuantitiesWhenOrderIsTea() {

		Product productForTea = new Product();

		containerOperations.adjustContainerQuantity("Tea", 1, productForTea);

		assertEquals((Integer) 1, productForTea.getTeaWasteAmount());
		assertEquals((Integer) 4, productForTea.getMilkWasteAmount());
		assertEquals((Integer) 5, productForTea.getWaterWasteAmount());
		assertEquals((Integer) 2, productForTea.getSugarWasteAmount());

	}

	@Test
	public void adjustContainerQuantityShouldUpdateQuantitiesWhenOrderIsBlackTea() {

		Product productForBlackTea = new Product();

		containerOperations.adjustContainerQuantity("Black Tea", 1, productForBlackTea);

		assertEquals((Integer) 12, productForBlackTea.getWaterWasteAmount());
		assertEquals((Integer) 2, productForBlackTea.getSugarWasteAmount());

	}

	@Test
	public void adjustContainerQuantityShouldUpdateQuantitiesWhenOrderIsCoffee() {

		Product productForCoffee = new Product();

		containerOperations.adjustContainerQuantity("Coffee", 1, productForCoffee);

		assertEquals((Integer) 1, productForCoffee.getCoffeeWasteAmount());
		assertEquals((Integer) 3, productForCoffee.getWaterWasteAmount());
		assertEquals((Integer) 8, productForCoffee.getMilkWasteAmount());
		assertEquals((Integer) 2, productForCoffee.getSugarWasteAmount());

	}

	@Test
	public void adjustContainerQuantityShouldUpdateQuantitiesWhenOrderIsBlackCoffee() {

		Product productForBlackCoffee = new Product();

		containerOperations.adjustContainerQuantity("Black Coffee", 1, productForBlackCoffee);

		assertEquals((Integer) 12, productForBlackCoffee.getWaterWasteAmount());
		assertEquals((Integer) 2, productForBlackCoffee.getSugarWasteAmount());

	}

	@Test
	public void shouldRefillTeaContainer() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(1200);

		containerOperations.reFillContainer(1, product);

	}

	@Test
	public void shouldRefillCoffeeContainer() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(1200);

		containerOperations.reFillContainer(2, product);

	}

	@Test
	public void shouldRefillMilkContainer() {

		Mockito.when(product.getMilkContainerCapacity()).thenReturn(100);

		containerOperations.reFillContainer(3, product);

	}

	@Test
	public void shouldRefillWaterContainer() {

		Mockito.when(product.getWaterContainerCapacity()).thenReturn(100);

		containerOperations.reFillContainer(4, product);

	}

	@Test
	public void shouldRefillSugarContainer() {

		Mockito.when(product.getSugarContainerCapacity()).thenReturn(100);

		containerOperations.reFillContainer(5, product);
	}

	@Test
	public void shouldCheckContainerStatus() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(1200);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(14000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(7000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);

		containerOperations.checkContainerStatus(product);

	}

	@Test
	public void shouldResetContainers() {

		containerOperations.resetContainer(product);

	}

	@Test
	public void shouldReturnTrueForCheckAvailabilityWhenOrderIsTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		assertTrue(containerOperations.checkAvailabilty("Tea", 1, product));

	}

	@Test
	public void shouldReturnTrueForCheckAvailabilityWhenOrderIsBlackTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		assertTrue(containerOperations.checkAvailabilty("Black Tea", 1, product));

	}

	@Test
	public void shouldReturnTrueForCheckAvailabilityWhenOrderIsCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		assertTrue(containerOperations.checkAvailabilty("Coffee", 1, product));

	}

	@Test
	public void shouldReturnTrueForCheckAvailabilityWhenOrderIsBlackCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		assertTrue(containerOperations.checkAvailabilty("Black Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenTeaContainerContainsLessThanRequiredForOrderTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(1);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		assertFalse(containerOperations.checkAvailabilty("Tea", 1, product));

	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenMilkContainerContainsLessThanRequiredForOrderTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(1);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		containerOperations.checkAvailabilty("Tea", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Tea", 1, product));
	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenWaterContainerContainsLessThanRequiredForOrderTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(2);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		containerOperations.checkAvailabilty("Tea", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Tea", 1, product));
	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenSugarContainerContainsLessThanRequiredForOrderTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(3);

		containerOperations.checkAvailabilty("Tea", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Tea", 1, product));
	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenTeaContainerContainsLessThanRequiredForOrderBlackTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(1);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		containerOperations.checkAvailabilty("Black Tea", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Black Tea", 1, product));

	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenWaterContainerContainsLessThanRequiredForOrderBlackTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(1);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		containerOperations.checkAvailabilty("Black Tea", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Black Tea", 1, product));

	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenSugarContainerContainsLessThanRequiredForOrderBlackTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(1);

		containerOperations.checkAvailabilty("Black Tea", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Black Tea", 1, product));
	}

	@Test
	public void shouldReturnFalseWhenCoffeeContainerContainsLessThanRequiredForOrderCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		containerOperations.checkAvailabilty("Coffee", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenWaterContainerContainsLessThanRequiredForOrderCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(1);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		containerOperations.checkAvailabilty("Coffee", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Coffee", 1, product));
	}

	@Test
	public void shouldReturnFalseWhenMilkContainerContainsLessThanRequiredForOrderCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(4);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		containerOperations.checkAvailabilty("Coffee", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenSugarContainerContainsLessThanRequiredForOrderCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(5);

		containerOperations.checkAvailabilty("Coffee", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenCoffeeContainerContainsLessThanRequiredForOrderBlackCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(1);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		containerOperations.checkAvailabilty("Black Coffee", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Black Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenWaterContainerContainsLessThanRequiredForOrderBlackCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(2);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);

		containerOperations.checkAvailabilty("Black Coffee", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Black Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenSugarContainerContainsLessThanRequiredForOrderBlackCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(2);

		containerOperations.checkAvailabilty("Black Coffee", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Black Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenProductTypeIsUnknown() {

		containerOperations.checkAvailabilty("Pepsi", 1, product);

		assertFalse(containerOperations.checkAvailabilty("Pepsi", 1, product));

	}

	@Test
	public void reFillContainershouldHandleExceptionWhenTeaContainerIsFull() {

		Product product = new Product();
		product.setTeaContainerCapacity(2000);

		containerOperations.reFillContainer(1, product);

	}

	@Test
	public void reFillContainershouldHandleExceptionWhenCoffeeContainerIsFull() {

		Product product = new Product();
		product.setCoffeeContainerCapacity(2000);

		containerOperations.reFillContainer(2, product);

	}

	@Test
	public void reFillContainershouldHandleExceptionWhenMilkContainerIsFull() {

		Product product = new Product();
		product.setCoffeeContainerCapacity(10000);

		containerOperations.reFillContainer(3, product);

	}

	@Test
	public void reFillContainershouldHandleExceptionWhenWaterContainerIsFull() {

		Product product = new Product();
		product.setCoffeeContainerCapacity(15000);

		containerOperations.reFillContainer(4, product);

	}

	@Test
	public void reFillContainershouldHandleExceptionWhenSugarContainerIsFull() {

		Product product = new Product();
		product.setCoffeeContainerCapacity(8000);

		containerOperations.reFillContainer(5, product);

	}

}
