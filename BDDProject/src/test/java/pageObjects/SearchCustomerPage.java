package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {	
	
	public WebDriver ldriver;
	
	WaitHelper waitHelper;
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver,this);		
		waitHelper = new WaitHelper(ldriver);
	}
	
	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement email;
	
	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(how = How.ID, using = "SearchMonthOfBirth")
	@CacheLookup
	WebElement monthOfBirth;
	
	@FindBy(how = How.ID, using = "SearchDayOfBirth")
	@CacheLookup
	WebElement dayOfBirth;
	
	@FindBy(how = How.ID, using = "SearchCompany")
	@CacheLookup
	WebElement company;
	
	@FindBy(how = How.ID, using = "SearchIpAddress")
	@CacheLookup
	WebElement ipAddress;
	
	@FindBy(how = How.XPATH, using = "//*[@id='SelectedCustomerRoleIds_taglist']/li/span[@title='delete']")
	@CacheLookup
	WebElement cusRoleClear;
	
	@FindBy(how = How.XPATH, using = "//div[@class='k-widget k-multiselect k-multiselect-clearable']")
	@CacheLookup
	WebElement cusRole;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement administrators;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Forum')]")
	@CacheLookup
	WebElement forum;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Moderators')]")
	@CacheLookup
	WebElement moderators;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement guests;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement registered;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement vendors;
	
	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = "//table[@role='grid']")
	@CacheLookup
	WebElement tableSearchresults;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	public void setEmail(String emailId)
	{
		waitHelper.WaitForElement(email, 30);
		email.clear();
		email.sendKeys(emailId);
	}
	
	public void setFirstname(String firstNameValue)
	{
		waitHelper.WaitForElement(firstName, 30);
		firstName.clear();
		firstName.sendKeys(firstNameValue);
	}
	
	public void setLastname(String lastNameValue)
	{
		waitHelper.WaitForElement(lastName, 30);
		lastName.clear();
		lastName.sendKeys(lastNameValue);
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	}
	
	public int getNoOfRows() {
		
		return (tableRows.size());
	}

	public int getNoOfColumns() {
		
		return (tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag = false;
		
		for (int i =1; i<=getNoOfRows(); i++)
		{
			String emailId = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			
			System.out.println(emailId);
			
			if(emailId.contentEquals(emailId))
			{
				flag = true;
			}
		}
		
		return flag;
	}
	
	public boolean searchCustomerByName(String firstName, String lastName)
	{
		boolean flag = false;
		
		for (int i =1; i<=getNoOfRows(); i++)
		{
			String nameValue = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			
			String names[] = nameValue.split(" ");
			
			if(names[0].equals(firstName) && names[1].equals(lastName))
			{
				flag = true;
			}
		}
		
		return flag;
	}
}
