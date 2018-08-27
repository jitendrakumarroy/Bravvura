package com.bravvura.hri.loginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bravvura.hri.Logger.LoggerHelper;
import com.bravvura.hri.PageObject.LoginPage;
import com.bravvura.hri.TestBase.Config;
import com.bravvura.hri.TestBase.TestBase;


public class LoginTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test
	public void testLoginToApplication() throws InterruptedException{
		log.info(LoginTest.class.getName()+" started");
		//int i=9/0;
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToApplication(config.getUserName(), config.getPassword());
		boolean status = loginPage.verifySuccessLoginMsg();
		if(status){
		   log.info("login is sucessful");	
		}
		else{
			Assert.assertTrue(false, "login is not sucessful");
		}
	}

}
