package com.workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;

public class PractinaRegister {
	
	public WebDriver driver;

	@Test
	public void handlingalerts() throws Exception  {
		
		
	// click on Affiliate link
	driver.findElement(By.linkText("Affiliate")).click();
	
	//click on Become a Partner Button
	driver.findElement(By.partialLinkText("Become a Partner")).click();
		
	//click on Sign Up	
	driver.findElement(By.xpath("//a[normalize-space()='Sign Up']")).click();
	
	File src = new File("C:\\Users\\happy\\OneDrive\\Desktop\\my.xlsx");
   
    FileInputStream finput = new FileInputStream(src);
    
    //XSSFWorkbook is a Syntax for .XLSX to Load the workbook
     XSSFWorkbook workbook = new XSSFWorkbook(finput);
   
    // Load the sheet index
    XSSFSheet s = workbook.getSheetAt(1);

    String name = s.getRow(1).getCell(0).getStringCellValue();
    
	System.out.println(name);
	
	
	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
	
	Thread.sleep(3000);

	String email = s.getRow(1).getCell(1).getStringCellValue();
	
	System.out.println(email);
	
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//div[@class='country-dropdown mat-menu-trigger ng-star-inserted']//img")).click();
	
	driver.findElement(By.xpath("//span[normalize-space()='India']")).click();
	Thread.sleep(1000);

	driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("9988123456");
	
	String password = s.getRow(1).getCell(1).getStringCellValue();
	
	System.out.println(password);
	
	
	
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
	
	Thread.sleep(1000);

	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Keys.TAB);
	Thread.sleep(1000);

	driver.switchTo().activeElement().sendKeys("Other");
	Thread.sleep(1000);

	driver.switchTo().activeElement().sendKeys(Keys.TAB);
	Thread.sleep(1000);

	driver.switchTo().activeElement().sendKeys("Ads");
	Thread.sleep(1000);


	driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	Thread.sleep(1000);
	
	
	
	}
	



	@BeforeTest
	public void openurl() throws Exception {
		

		  WebDriverManager.firefoxdriver().setup();
		 
		  driver = new FirefoxDriver();
		  
		  driver.get("https://dev.practina.com/");
		  
		  driver.manage().window().maximize();
		  
		  Thread.sleep(1000);

		  
	}

	@AfterTest
	public void afterTest() {
		driver.close();

	}

}