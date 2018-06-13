package com.test.task.QETestTask;

import org.testng.annotations.Test;

public class AddCustomerTest extends Base{
	
	HomePage homePage = new HomePage();
	AddCustomer addCustomer = new AddCustomer();
	
	@Test(groups={"regression"})
	public void addNewCustomer() {
		
		homePage.clickAddCustomer();
		addCustomer.addCustomer("First Name", "Last Name", "1989-04-23", "111-111-1111", "new@address.com");
		addCustomer.verifyCustomerAdded();
		
	}
	
	@Test(groups={"regression"})
	public void addExistingCustomer() {
		homePage.clickAddCustomer();
		addCustomer.addCustomer("Harry", "Truman", "1988-02-12", "222-222-2222", "add@existing.com");
		addCustomer.verifyCustomerAlreadyExists();
	}

}
