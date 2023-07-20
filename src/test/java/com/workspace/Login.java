package com.workspace;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login {

	public WebDriver driver;
	public Actions action;


	@Test
	public void login() throws Exception  {
		
		action = new Actions(driver);

		//Enter the user id
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("leeminho@gmail.com");

		//Enter the password 
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Leemin@123");
		//Thread.sleep(3000);

		//click on login button
		driver.findElement(By.xpath("//button[normalize-space()='Login Now']")).click();
		Thread.sleep(9000);
		Thread.sleep(8000);



		
		//page redirect to home and click on Dashboard
		driver.findElement(By.linkText("Dashboard")).click();
		Thread.sleep(9000);

		//click on user profile icon
	//	driver.findElement(By.xpath("//a[@class='profile-btn ng-star-inserted']//img"));

		Thread.sleep(1000);

		  
		WebElement ele = driver.findElement(By.xpath("//a[@class='profile-btn ng-star-inserted']//img"));

		//Action command
		action.moveToElement(ele).build().perform();
		Thread.sleep(9000);

		driver.findElement(By.cssSelector("li[class='list-group-item list-group-item-action d-flex align-items-center']")).click();
		Thread.sleep(6000);

		try{
		    System.out.println("Waiting for Alert");
		    //WebDriverWait wait = new WebDriverWait(driver,10);
		   // wait.until(ExpectedConditions.alertIsPresent()).accept();
		   driver.switchTo().alert().accept();
		    System.out.println("Alert Displayed");
		}
		catch (Exception e){
		    System.out.println("Alert not Displayed");
		}
				
		

	}

	@BeforeTest
	public void openurl() throws Exception {

	//	WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();

		
		
		  //driver = new FirefoxDriver();
		  driver = new ChromeDriver();

		  driver.get("https://dev.practina.com/partner/login");
		  driver.manage().window().maximize();
		  Thread.sleep(1000);
		  
		
	}

	@AfterTest
	public void afterTest() {
		

	}

}

