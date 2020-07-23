Feature: Customers

 Background: Common steps for scenarios 
	Given  User Launch Chrome browser 
	When  User opens URL "https://admin-demo.nopcommerce.com/login" 
	And  User enters email as "admin@yourstore.com" and password as "admin" 
	And  Click on Login 
	Then  User can view Dashboard  

Scenario: Add a new Customer 
	When User Click on customers Menu 
	And click on customers Menu Item 
	And click on Add new button 
	Then User can view Add new customer page 
	When User enter customer info 
	And click on Save button 
	Then User can view confirmation message "The new customer has been added successfully." 
	And close browser 	
	
Scenario: Search Customer by EmailId 
	When User Click on customers Menu 
	And click on customers Menu Item 
	And Enter customer Email 
	When Click on search button 
	Then User should found Email in the search table 
	And close browser 
	
Scenario: Search Customer by Name 
	When User Click on customers Menu 
	And click on customers Menu Item 
	And Enter customer FirstName 
	And Enter customer LastName 
	When Click on search button 
	Then User should found Name in the search table 
	And close browser 
