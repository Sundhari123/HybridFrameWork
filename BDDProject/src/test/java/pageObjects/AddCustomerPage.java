package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	By customerLinkMenu = By.xpath("//a[@href=\"#\"]//span[contains(text(),'Customers')]");
	By customerLinkMenuItem = By.xpath("//a[@href='/Admin/Customer/List']//span[contains(text(),'Customers')]");
	
	By btnAddNew = By.xpath("//a [@class='btn bg-blue']");
	
	By email = By.xpath("//input[@id='Email']");
	By password = By.xpath("//input[@id='Password']");
	
	By firstName = By.xpath("//input[@id='FirstName']");
	By lastName = By.xpath("//input[@id='LastName']");
	
	By genderFemale = By.id("Gender_Female");
	By genderMale = By.id("Gender_Male");
	
	By dob = By.id("DateOfBirth");
	
	By companyName = By.xpath("//input[@id='Company']");
	By taxExempt = By.xpath("//input[@id='IsTaxExempt']");
	
	By newsLetter = By.xpath("//*[@id='SelectedNewsletterSubscriptionStoreIds_taglist']");
	By newsLetterOption1 = By.xpath("//li[contains(text(),'Your store name')]");
	By newsLetterOption2 = By.xpath("//li[contains(text(),'Test store 2')]");
	
	By customerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[10]/div[2]/div/div[1]/div");
	By cusRoleClear = By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[@title='delete']");
	By administrators = By.xpath("//li[contains(text(),'Administrators')]");
	By forum = By.xpath("//li[contains(text(),'Forum')]");
	By moderators = By.xpath("//li[contains(text(),'Moderators')]");
	By guests = By.xpath("//li[contains(text(),'Guests')]");
	By registered = By.xpath("//li[contains(text(),'Registered')]");
	By vendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	By managerOfVendor = By.xpath("//*[@id='VendorId']");
	
	By active = By.id("Active");
	
	By comment = By.xpath("//textarea[@id='AdminComment']");
	
	By saveButton = By.xpath("//button[@name='save']");
	
	public void clickCustomerMenu()
	{
		ldriver.findElement(customerLinkMenu).click();
	}
	
	public void clickCustomerMenuItem()
	{
		ldriver.findElement(customerLinkMenuItem).click();
	}
	
	public void clickAddNewButton()
	{
		ldriver.findElement(btnAddNew).click();
	}
	
	public void setEmail(String emailText)
	{
		ldriver.findElement(email).sendKeys(emailText);
	}
	
	public void setPassword(String Passwd)
	{
		ldriver.findElement(password).sendKeys(Passwd);
	}
	
	public void setCustomerRole(String role)
	{
		ldriver.findElement(cusRoleClear).click();
		
		WebElement elm = ldriver.findElement(customerRoles);
		
		elm.click();

		WebElement listItem;
		
		if(role.equalsIgnoreCase("Administrators"))
		{
			listItem = ldriver.findElement(administrators);
		}
		
		else if(role.equalsIgnoreCase("Guests"))
		{
			listItem = ldriver.findElement(guests);
		}
		
		else if(role.equalsIgnoreCase("Registered"))
		{
			listItem = ldriver.findElement(registered);
		}
		
		else if(role.equalsIgnoreCase("Vendors"))
		{
			listItem = ldriver.findElement(vendors);
		}
		
		else
		{
			listItem = ldriver.findElement(guests);
		}
		
		//listItem.click();
		
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click();", listItem);
	}
	
	public void setManagerofVendor(String value)
	{
		Select drp = new Select(ldriver.findElement(managerOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(genderMale).click();
		}
		
		else if(gender.equals("Female"))
		{
			ldriver.findElement(genderFemale).click();
		}
		
		else
		{
			ldriver.findElement(genderMale).click();
		}
	}
	
	public void setFirstName(String firstNm)
	{
		ldriver.findElement(firstName).sendKeys(firstNm);
	}
	
	public void setLastName(String lastNm)
	{
		ldriver.findElement(lastName).sendKeys(lastNm);
	}
	
	public void companyName(String cmpName)
	{
		ldriver.findElement(companyName).sendKeys(cmpName);
	}
	
	public void comment(String cmnt)
	{
		ldriver.findElement(comment).sendKeys(cmnt);
	}
	
	public void setDob(String dateOfBirth)
	{
		ldriver.findElement(dob).sendKeys(dateOfBirth);
	}
	
	public void clickSaveButton()
	{
		ldriver.findElement(saveButton).click();
	}
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}

}
