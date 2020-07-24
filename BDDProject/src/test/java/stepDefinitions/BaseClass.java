package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import pageObjects.AddCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage acp;
	public SearchCustomerPage scp;
	public Logger logger;
	public Properties property;
	
	public String randomString()
	{
		String rndmString = RandomStringUtils.randomAlphabetic(5);
		return rndmString;
	}

}
