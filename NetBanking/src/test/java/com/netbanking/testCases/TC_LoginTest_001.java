package com.netbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{	
		try
		{
		logger.info("TestCase started");
		
		LoginPage lgnPage = new LoginPage(driver);
		
		lgnPage.setUsername(username);
		
		lgnPage.setPassword(password);
		
		lgnPage.clickSubmitButton();
		
	
		if (driver.getTitle().equals("HeaderTitle"))
		{
			Assert.assertTrue(true);
		}
		}
		catch (Exception e)
		{
			captureScreenShot(driver, "loginTest");
			logger.info(e.getMessage());
			Assert.assertTrue(false);
			logger.info("TestCase Failed");
		}
	}

}
