package com.bravvura.hri.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bravvura.hri.Logger.LoggerHelper;
import com.bravvura.hri.TestBase.Config;
import com.bravvura.hri.TestBase.TestBase;
import com.bravvura.hri.genericHelper.GenericHelper;
import com.bravvura.hri.javascriptHelper.JavaScriptHelper;
import com.bravvura.hri.waitHelper.WaitHelper;



public class LoginPage{
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="(//span[text()='Sign in'])[1]")
	WebElement signin;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='pwd']")
	WebElement password;
	
	@FindBy(xpath="//button[text()=' SIGN IN']")
	WebElement submitLogin;
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement successMsgObject;
	
	
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, signin,new Config(TestBase.OR).getExplicitWait());
	}
	
	public void clickOnSignInLink(){
		log.info("clicked on sign in link...");
		signin.click();
	}
	
	public void enterEmailAddress(String emailAddress){
		log.info("entering email address...."+emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password){
		log.info("entering password...."+password);
		this.password.sendKeys(password);
	}
	
	public HomePage clickOnSubmitButton(){
		log.info("clicking on submit button...");
		new JavaScriptHelper(driver).scrollDownVertically();
		submitLogin.click();
		return new HomePage(driver);
	}
	
	public boolean verifySuccessLoginMsg(){
		return new GenericHelper().isDisplayed(successMsgObject);
	}
	
	public void enterRegistrationEmail(){
		String email = System.currentTimeMillis()+"@gmail.com";
		log.info("entering registration email.."+email);
		//registration.sendKeys(email);	
	}
	
	
	
	
	public void loginToApplication(String emailAddress, String password) throws InterruptedException{
		clickOnSignInLink();
		Thread.sleep(1000);
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
	}

}
