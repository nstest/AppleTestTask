package com.test.task.QETestTask;

import org.testng.annotations.Test;

public class UpdateCustomerTest extends Base{

	HomePage homePage = new HomePage();
	AddCustomer addCustomer = new AddCustomer();
	
	@Test(groups={"regression"})
	public void updateExistingCustomer() {
		homePage.clickUpdateCustomer();
		addCustomer.addCustomer("First", "last", "1988-02-12", "333-333-3333", "update@existing.com");
		addCustomer.verifyCustomerUpdated();
	}
	
	@Test(groups={"regression"})
	public void updateNonExistingCustomer() {
		homePage.clickUpdateCustomer();
		addCustomer.addCustomer("NonExisting", "NonExisting", "1944-04-12", "444-444-4444", "non@existing.com");
		addCustomer.verifyNonExistingCustomerUpdated();
	}
}
