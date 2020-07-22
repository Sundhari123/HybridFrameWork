Feature: Login

Scenario: Successful Login with Valid Credentials

Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on log out link
Then Page Title should be "Your store. Login"
And close browser

Scenario Outline: Successful Login Data driver

Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters email as "<email>" and password as "<password>"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on log out link
Then Page Title should be "Your store. Login"
And close browser

Examples:

|email | password |
| admin@yourstore.com | admin |
|admin123@yourstore.com | admin123 |