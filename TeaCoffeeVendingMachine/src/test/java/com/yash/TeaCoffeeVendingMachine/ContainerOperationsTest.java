package com.yash.TeaCoffeeVendingMachine;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
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

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		
		Mockito.when(product.getTeaWasteAmount()).thenReturn(0);
		Mockito.when(product.getMilkWasteAmount()).thenReturn(0);
		Mockito.when(product.getWaterWasteAmount()).thenReturn(0);
		Mockito.when(product.getSugarWasteAmount()).thenReturn(0);
		
	

		containerOperations.adjustContainerQuantity("Tea", 1, product);

		verify(product).setTeaContainerCapacity(1994);
		verify(product).setMilkContainerCapacity(9956);
		verify(product).setWaterContainerCapacity(14935);
		verify(product).setSugarContainerCapacity(7983);
		
		verify(product).setTeaWasteAmount(1);
		verify(product).setMilkWasteAmount(4);
		verify(product).setWaterWasteAmount(5);
		verify(product).setSugarWasteAmount(2);
		
		
	}

	@Test
	public void adjustContainerQuantityShouldUpdateQuantitiesWhenOrderIsBlackTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		Mockito.when(product.getTeaWasteAmount()).thenReturn(0);
		Mockito.when(product.getWaterWasteAmount()).thenReturn(0);
		Mockito.when(product.getSugarWasteAmount()).thenReturn(0);

		containerOperations.adjustContainerQuantity("Black Tea", 1, product);

		verify(product).setTeaContainerCapacity(1997);
		verify(product).setWaterContainerCapacity(14888);
		verify(product).setSugarContainerCapacity(7982);
		
		verify(product).setTeaWasteAmount(0);
		verify(product).setWaterWasteAmount(12);
		verify(product).setSugarWasteAmount(2);
		

	}

	@Test
	public void adjustContainerQuantityShouldUpdateQuantitiesWhenOrderIsCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		
		
		Mockito.when(product.getCoffeeWasteAmount()).thenReturn(0);
		Mockito.when(product.getMilkWasteAmount()).thenReturn(0);
		Mockito.when(product.getWaterWasteAmount()).thenReturn(0);
		Mockito.when(product.getSugarWasteAmount()).thenReturn(0);
		

		containerOperations.adjustContainerQuantity("Coffee", 1, product);

		verify(product).setCoffeeContainerCapacity(1995);
		verify(product).setWaterContainerCapacity(14977);
		verify(product).setSugarContainerCapacity(7983);
		verify(product).setMilkContainerCapacity(9912);
		
		verify(product).setCoffeeWasteAmount(1);
		verify(product).setMilkWasteAmount(8);
		verify(product).setWaterWasteAmount(3);
		verify(product).setSugarWasteAmount(2);

	}

	@Test
	public void adjustContainerQuantityShouldUpdateQuantitiesWhenOrderIsBlackCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		Mockito.when(product.getCoffeeWasteAmount()).thenReturn(0);
		Mockito.when(product.getWaterWasteAmount()).thenReturn(0);
		Mockito.when(product.getSugarWasteAmount()).thenReturn(0);
		

		containerOperations.adjustContainerQuantity("Black Coffee", 1, product);

		verify(product).setCoffeeContainerCapacity(1997);
		verify(product).setWaterContainerCapacity(14888);

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
		
		Assert.assertTrue(containerOperations.checkAvailabilty("Tea", 1, product));

		
	}
	
	
	@Test
	public void shouldReturnTrueForCheckAvailabilityWhenOrderIsBlackTea() {
		
		
		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		Assert.assertTrue(containerOperations.checkAvailabilty("Black Tea", 1, product));

	

	}
	
	@Test
	public void shouldReturnTrueForCheckAvailabilityWhenOrderIsCoffee() {
		
		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		
		Assert.assertTrue(containerOperations.checkAvailabilty("Coffee", 1, product));


	}
	
	
	@Test
	public void shouldReturnTrueForCheckAvailabilityWhenOrderIsBlackCoffee() {
		
		
		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		
		Assert.assertTrue(containerOperations.checkAvailabilty("Black Coffee", 1, product));
		


	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenTeaContainerContainsLessThanRequiredForOrderTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(1);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Tea", 1, product));

	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenMilkContainerContainsLessThanRequiredForOrderTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(1);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		containerOperations.checkAvailabilty("Tea", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Tea", 1, product));
	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenWaterContainerContainsLessThanRequiredForOrderTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(2);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		containerOperations.checkAvailabilty("Tea", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Tea", 1, product));
	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenSugarContainerContainsLessThanRequiredForOrderTea() {

		
		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(3);
		
		containerOperations.checkAvailabilty("Tea", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Tea", 1, product));
	}

	

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenTeaContainerContainsLessThanRequiredForOrderBlackTea() {

		
		Mockito.when(product.getTeaContainerCapacity()).thenReturn(1);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		containerOperations.checkAvailabilty("Black Tea", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Black Tea", 1, product));

	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenWaterContainerContainsLessThanRequiredForOrderBlackTea() {

		
		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(1);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		containerOperations.checkAvailabilty("Black Tea", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Black Tea", 1, product));

	}

	@Test
	public void shouldReturnFalseForCheckAvailabilityWhenSugarContainerContainsLessThanRequiredForOrderBlackTea() {

		Mockito.when(product.getTeaContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(1);
		
		containerOperations.checkAvailabilty("Black Tea", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Black Tea", 1, product));
	}

	

	@Test
	public void shouldReturnFalseWhenCoffeeContainerContainsLessThanRequiredForOrderCoffee() {

		
		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		containerOperations.checkAvailabilty("Coffee", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenWaterContainerContainsLessThanRequiredForOrderCoffee() {
		
		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(1);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		containerOperations.checkAvailabilty("Coffee", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Coffee", 1, product));
	}

	@Test
	public void shouldReturnFalseWhenMilkContainerContainsLessThanRequiredForOrderCoffee() {

	
		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(4);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		containerOperations.checkAvailabilty("Coffee", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenSugarContainerContainsLessThanRequiredForOrderCoffee() {

		
		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getMilkContainerCapacity()).thenReturn(10000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(5);
		
		containerOperations.checkAvailabilty("Coffee", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Coffee", 1, product));

	}

	

	@Test
	public void shouldReturnFalseWhenCoffeeContainerContainsLessThanRequiredForOrderBlackCoffee() {

		
		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(1);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		containerOperations.checkAvailabilty("Black Coffee", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Black Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenWaterContainerContainsLessThanRequiredForOrderBlackCoffee() {

		
		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(2);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(8000);
		
		containerOperations.checkAvailabilty("Black Coffee", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Black Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenSugarContainerContainsLessThanRequiredForOrderBlackCoffee() {

		Mockito.when(product.getCoffeeContainerCapacity()).thenReturn(2000);
		Mockito.when(product.getWaterContainerCapacity()).thenReturn(15000);
		Mockito.when(product.getSugarContainerCapacity()).thenReturn(2);
		
		containerOperations.checkAvailabilty("Black Coffee", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Black Coffee", 1, product));

	}

	@Test
	public void shouldReturnFalseWhenProductTypeIsUnknown() {
		
		containerOperations.checkAvailabilty("Pepsi", 1, product);
		
		Assert.assertFalse(containerOperations.checkAvailabilty("Pepsi", 1, product));

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
