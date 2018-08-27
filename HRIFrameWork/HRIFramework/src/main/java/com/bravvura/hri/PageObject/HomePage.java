package com.bravvura.hri.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bravvura.hri.Logger.LoggerHelper;
import com.bravvura.hri.TestBase.Config;
import com.bravvura.hri.TestBase.TestBase;
import com.bravvura.hri.waitHelper.WaitHelper;





public class HomePage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	
	
	@FindBy(xpath="//a[text()='Menu']")
	public WebElement menu;
	

	@FindBy(xpath="//a[text()='Order Online']")
	public WebElement OrderOnline;
	
	@FindBy(xpath="//span[text()='Sign in']")
	public WebElement Signin;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		TestBase testBase = new TestBase();
		waitHelper.waitForElement(driver, menu,new Config(TestBase.OR).getExplicitWait());
	}
}
