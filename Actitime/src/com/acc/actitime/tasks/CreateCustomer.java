package com.acc.actitime.tasks;

import org.openqa.selenium.By; 
import org.testng.annotations.Test;
import com.acc.actitime.testbase.BaseClass;
public class CreateCustomer extends BaseClass{
  @Test
  public void testCreateCustomer() {
	  tp.navigateToTasks(driver); // code duplication is reduced
	  tp.addNewCustomer(driver);
	  
	  
	  driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
	  String name=xlib.getExcelData("CreateCustomer", 1, 0);
	  String desc=xlib.getExcelData("CreateCustomer", 1, 1);
	  driver.findElement(By.xpath("//input[@placeholder='Enter Customer Name' and @autocomplete='off']")).sendKeys(name);
	  driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(desc);
	  driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
	  System.out.println("Create Customer");
  }
}
