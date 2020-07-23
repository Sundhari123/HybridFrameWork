package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import pageObjects.AddCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage acp;
	public SearchCustomerPage scp;
	
	public String randomString()
	{
		String rndmString = RandomStringUtils.randomAlphabetic(5);
		return rndmString;
	}

}
