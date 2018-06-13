package com.test.task.QETestTask;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	static WebDriver driver = null;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/ssundresh/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/TestTask/index.jsp");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
