package com.test.task.QETestTask;

import org.openqa.selenium.By;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class AddCustomer extends Base{

	String birthDate = null;
	public String generateRandomDOB() {
		//Logic to generate random date of birth goes here...
		birthDate = "1988-12-12";
		
		return birthDate;
	}
	
	@Step("Add a Customer")
	public void addCustomer(String firstName, String lastName, String birthDate, String phone, String email) {
		
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("birthDate")).sendKeys(birthDate);
		driver.findElement(By.id("phoneNumber")).sendKeys(phone);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("submit")).click();
		
	}
	
	@Step("Verify if the customer is added to the database")
	public void verifyCustomerAdded() {
		Assert.assertTrue(driver.findElement(By.className("message"))
				.isDisplayed()
				&& driver.findElement(By.className("message")).getText()
						.contains("Customer added to the database"),
				"Customer details added to the database successfully");
	}
	
	@Step("Verify if the customer already exists in the database")
	public void verifyCustomerAlreadyExists() {
		Assert.assertTrue(driver.findElement(By.className("message"))
				.isDisplayed()
				&& driver.findElement(By.className("message")).getText()
						.contains("Customer already exists in the database. Phone and Email has been updated"),
				"Customer already exists in the database. No new records were inserted");
	}

	@Step("Verify if the customer details are updated")
	public void verifyCustomerUpdated() {
		Assert.assertTrue(driver.findElement(By.className("message"))
				.isDisplayed()
				&& driver.findElement(By.className("message")).getText()
						.contains("Customer exists in the database. Phone and Email has been updated"),
				"Customer exists in the database and his details have been updated");
		
		
	}
	
	@Step("Verify if the customer details are updated")
	public void verifyNonExistingCustomerUpdated() {
		Assert.assertTrue(driver.findElement(By.className("message"))
				.isDisplayed()
				&& driver.findElement(By.className("message")).getText()
						.contains("Customer does not exist in the database"),
				"Customer does not exist in the database. No records have been updated");
		
		
	}
}
