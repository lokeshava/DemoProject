package com.acc.actitime.tasks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.acc.actitime.testbase.BaseClass;

public class DeleteCustomer extends BaseClass{
  @Test
  public void testDeleteCustomer() throws InterruptedException {
	  tp.navigateToTasks(driver);
	  String custName=xlib.getExcelData("DeleteCustomer", 1, 0);
	  driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys(custName);
	  driver.findElement(By.xpath("//span[@class='highlightToken']/../../..//div[@class='editButton']")).click();
	  driver.findElement(By.xpath("(//div[text()='ACTIONS'])[1]")).click();
	  driver.findElement(By.xpath("(//div[text()='Delete'])[2]")).click();
	  driver.findElement(By.xpath("//span[@class='submitTitle buttonTitle' and text()='Delete permanently']")).click();
  }
}
