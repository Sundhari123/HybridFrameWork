package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{
	
	@Before
	public void setUp() throws IOException
	{
		property = new Properties();
		FileInputStream propertyFile = new FileInputStream("config.properties");
		property.load(propertyFile);
		
		logger = Logger.getLogger("BDDProject");
		PropertyConfigurator.configure("log4j.properties");
		
		String brwsr = property.getProperty("browser");
		
		if(brwsr.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", property.getProperty("chromepath"));
			driver = new ChromeDriver();
			logger.info("*******Launching browser*********");
		}
		
		if(brwsr.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", property.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
			logger.info("*******Launching browser*********");
		}
		
		if(brwsr.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", property.getProperty("iepath"));
			driver = new InternetExplorerDriver();
			logger.info("*******Launching browser*********");
		}
		
		if(brwsr.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", property.getProperty("chromepath"));
			driver = new ChromeDriver();
			logger.info("*******Launching browser*********");
		}

	}

	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		lp = new LoginPage(driver);		
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) throws InterruptedException {
		logger.info("*******Opening url*********");
		driver.get(url);
		Thread.sleep(2000);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String uName, String passwd) throws InterruptedException {
		logger.info("*******Providing email and password*********");
		lp.setUserName(uName);
		lp.setPassword(passwd);
		Thread.sleep(2000);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException{
		lp.clickLogin();
		Thread.sleep(2000);
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) throws InterruptedException{
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertEquals(title, driver.getTitle());
		}
			
		
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException{
		lp.clickLogout();
	}

	@Then("close browser")
	public void close_browser() throws InterruptedException{
		driver.close();
	}
	
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() throws InterruptedException{
		
		acp = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", acp.getPageTitle());
		Thread.sleep(2000);
		
	}

	@When("User Click on customers Menu")
	public void user_Click_on_customers_Menu() throws InterruptedException{
		
		acp.clickCustomerMenu();
		Thread.sleep(2000);
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException{
		acp.clickCustomerMenuItem();
		Thread.sleep(2000);
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException{
		acp.clickAddNewButton();
		Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() throws InterruptedException{
		Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getPageTitle());
		Thread.sleep(2000);

	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException{
		String email = randomString()+"@gmail.com";
		acp.setEmail(email);
		acp.setPassword("test123");
		acp.setFirstName("Sun");
		acp.setLastName("Moon");
		acp.setDob("05/12/2000");
		acp.companyName("qaOnly");
		acp.comment("Testing purpose");
		acp.setCustomerRole("Guests");
		Thread.sleep(2000);
		

	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException{
		acp.clickSaveButton();
		Thread.sleep(2000);

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String cnfrmMsg) {
		Assert.assertTrue(driver.getPageSource().contains(cnfrmMsg));

	}
	
	@When("Enter customer Email")
	public void enter_customer_Email() {		
		scp = new SearchCustomerPage(driver);
		scp.setEmail("victoria_victoria@nopCommerce.com");

	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		scp.clickSearchButton();
		Thread.sleep(3000);

	}

	@Then("User should found Email in the search table")
	public void user_should_found_Email_in_the_search_table() {
		boolean status = scp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	@When("Enter customer FirstName")
	public void enter_customer_FirstName() {
		scp = new SearchCustomerPage(driver);
		scp.setFirstname("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_LastName() {
		scp.setLastname("Terces");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_Name_in_the_search_table() {
		boolean status = scp.searchCustomerByName("Victoria", "Terces");
		Assert.assertEquals(true, status);
		
	}

}
