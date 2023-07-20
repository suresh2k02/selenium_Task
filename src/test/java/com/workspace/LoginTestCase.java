package com.workspace;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class LoginTestCase {
	public WebDriver driver;

  @Test(priority=1)
  public void LoginWith_Validuser_InvalidPassword() throws InterruptedException {
	  
	  	driver.get("https://dev.practina.com/partner/login");

	  	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("suresh2k02@gmail.com");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Sureshhh@123");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[normalize-space()='Login Now']")).click();
	  
  }
  
  @Test(priority=2)
  public void LoginWith_inValiduser_validPassword() throws InterruptedException {
	  	driver.get("https://dev.practina.com/partner/login");

	  	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("user@gmail.com");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Suresh@123");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[normalize-space()='Login Now']")).click();
  }
  
  @Test(priority=3)
  public void LoginWith_Validuser_validPassword() throws InterruptedException {
	  	driver.get("https://dev.practina.com/partner/login");
	  	
	  	
	    driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("suresh2k02@gmail.com");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Suresh@123");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[normalize-space()='Login Now']")).click();
	  
  }
  
  
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.firefoxdriver().setup();
		
		
	  driver = new FirefoxDriver();
	 // driver.get("https://dev.practina.com/partner/login");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
