package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class Steps extends BaseClass{
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(2000);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String uName, String passwd) throws InterruptedException {
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

}
