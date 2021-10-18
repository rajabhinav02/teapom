package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.getDriver;

public class ElementUtil{

	public void waiting(By locator, int time) {
		
		WebDriverWait wait = new WebDriverWait(getDriver.getdriver(),10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
}
