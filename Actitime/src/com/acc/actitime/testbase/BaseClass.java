package com.acc.actitime.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.acc.actitime.pageclass.TasksPage;

import junit.framework.Assert;

public class BaseClass {
	public WebDriver driver;
	public ExcelLibrary xlib; 
	public TasksPage tp;
	@BeforeClass
	public void testOpenBrowser() {
		xlib = new ExcelLibrary();
		
		
		String browserName=xlib.getExcelData("Browser", 1, 0);
		
		if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		
		}else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "../exeFiles/chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "../exeFiles/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		
		tp=new TasksPage();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com");
		driver.manage().timeouts().implicitlyWait(1000000, TimeUnit.SECONDS);
		String expectedTitle="actiTIME - Login";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@BeforeMethod
	public void testLogin() {
		String un=xlib.getExcelData("Login", 1, 0);
		String pw=xlib.getExcelData("Login", 1, 1);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		driver.findElement(By.id("loginButton")).click();
	}
	
	@AfterMethod
	public void testLogout() {
		driver.findElement(By.id("logoutLink")).click();
	}
	
	@AfterClass
	public void testCloseBrowser() {
		driver.close();
		System.out.println("Close Browser");
	}
}
