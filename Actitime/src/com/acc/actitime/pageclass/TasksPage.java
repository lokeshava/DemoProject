package com.acc.actitime.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TasksPage {

	public void navigateToTasks(WebDriver driver) {

		driver.findElement(By.id("container_tasks")).click();

	}
	public void addNewCustomer(WebDriver driver) {


		driver.findElement(By.xpath("//div[text()='Add New']")).click();

	}
}