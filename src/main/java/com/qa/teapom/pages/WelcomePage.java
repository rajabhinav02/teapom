package com.qa.teapom.pages;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import driverFactory.getDriver;
import utils.ElementUtil;

public class WelcomePage {

	WebDriver driver;
	ElementUtil eu;
	public int count=0;

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		eu = new ElementUtil();
	}

	private By welcomelink = By.xpath("//a[text()='Welcome']");
	private By seecollbutton = By.xpath("//span[contains(text(),'Collection')]");
	private By teaname = By.cssSelector("[class*='editor_collections']");
	private By passion = By.xpath("//a[contains(text(),'Our')]");
	private By menu = By.xpath("//a[contains(@data-url,'menu.html')]");
	private By talk = By.xpath("//a[contains(text(),\"Let's\")]");
	private By checkout = By.xpath("//a[contains(text(),\"Out\")]");
	@FindBy(xpath = "//a[contains(text(),'Passion')]")
	private WebElement passionk;
	private By alllinksleft = By.xpath("//ul[contains(@class,'navigation')]//a");

	public int clickteaname(String teanameselect) throws InterruptedException {
		eu.waiting(seecollbutton, 10);
		List<WebElement> teanames = driver.findElements(teaname);
		List<WebElement> addbuttons = driver.findElements(seecollbutton);
		
		int i;
		for (i = 0; i < teanames.size(); i++) {
			if (teanames.get(i).getText().equals(teanameselect)) {
				Thread.sleep(3000);
				addbuttons.get(i).click();
				
				
			}
		}
		
		return i;
	}

	
	
	public String gettitle() {
		return driver.getTitle();

	}

	public void clickPassion() {
		passionk.click();

	}

	public void talktea() {
		driver.findElement(talk).click();

	}

	public void clickchkout() {
		driver.findElement(checkout).click();

	}

	public void clickWelcome() {
		driver.findElement(welcomelink).click();

	}

	public void clickMenu() {
		driver.findElement(menu).click();

	}
	
	
	public void clickleftlink() throws InterruptedException {
		List<WebElement>links = driver.findElements(alllinksleft);
		//Actions action = new Actions(driver);
		
		
		
		for (int j=0; j<links.size(); j++) {
			links.get(j).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));;
			count++;
			Thread.sleep(2000);
		}
		//return count;
	}
	
	public int validateopeining() {
		Set<String> windows=driver.getWindowHandles();
		return windows.size();
	}

}
