package com.test.task.QETestTask;

import org.openqa.selenium.By;

import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends Base {

	@Step("Click on Add a Customer")
	public void clickAddCustomer() {
		driver.findElement(By.id("addCustomer")).click();
	}
	
	@Step("Click on Update Customer")
	public void clickUpdateCustomer() {
		driver.findElement(By.id("updateCustomer")).click();
	}
	
}
