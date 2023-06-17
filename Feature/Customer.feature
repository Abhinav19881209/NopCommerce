
Feature: Customer feature

Scenario Outline: Add new customer
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email "admin@yourstore.com" and Password "admin"
    And User clicks on login button
    Then Page title should be "Dashboard / nopCommerce administration"
		When User clicks on dashboard customer
		And User clicks on customer subtab
		And User clciks on Add new button
		And User Click enters Customer Info "<emailid>""<passwrd>""<firstname>""<lastname>""<gender>""<dob>""<companyname>""<taxexemptyes>""<NewLetter>""<CutomerRole>""<ManageVendor>""<Comment>"
		And User Click on save button
		Then User confirmation message should appear
		Then User clicks on logout button
    Then User close the browser
		
Examples:
|emailid|passwrd|firstname|lastname|gender|dob|companyname|taxexemptyes|NewLetter|CutomerRole|ManageVendor|Comment|
|Test5.test@Test.com|test1|ftest1|ltest1|male|1/1/2023|MS|yes|Your store name|Guests|Vendor 1|Comment1|
|Test6.test@Test.com|test1|ftest1|ltest1|Female|1/1/2024|apple|no|Your store name|Guests|Vendor 1|Comment2|
|Test7.test@Test.com|test1|ftest1|ltest1|male|1/1/2025|Oracle|yes|Your store name|Guests|Vendor 2|Comment3|

@Search
Scenario Outline: Search the Added customer
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email "admin@yourstore.com" and Password "admin"
    And User clicks on login button
    Then Page title should be "Dashboard / nopCommerce administration"
		When User clicks on dashboard customer
		And User clicks on customer subtab
		And Search with an email
		And Select and click on edit in search result
		And Delete the record
		And User validate the deleted record
		Then User clicks on logout button
    Then User close the browser
		
Examples:
|emailid|
|Test5.test@Test.com|
|Test6.test@Test.com|
|Test7.test@Test.com|