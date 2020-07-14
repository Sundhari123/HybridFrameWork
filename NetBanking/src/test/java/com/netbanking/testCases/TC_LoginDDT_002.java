package com.netbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.pageObjects.LoginPage;
import com.netbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String userName, String passwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(userName);
		lp.setPassword(passwd);
		lp.clickSubmitButton();
		
		Thread.sleep(3000);
		
		if(isAlertPresent())
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			lp.clicklogOutButton();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name ="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/netbanking/testData/LoginData.xlsx";
		
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String [rowNum][colCount];
		
		for(int i =1; i<=rowNum;i++)
		{
			for(int j=0; j<colCount;j++) 
			{
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);				
			}
		}
		
		return loginData;
	}

}
