Feature: Login Page functionality test
    
  Scenario: login with valid credential
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email "admin@yourstore.com" and Password "admin"
    And User clicks on login button
    Then Page title should be "Dashboard / nopCommerce administration"
    Then User clicks on logout button
    Then User close the browser

  Scenario: login with invalid credential
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email "admin@yourstore.com" and Password "adminfa4"
    And User clicks on login button
    Then Check for error message "The credentials provided are incorrect"
    Then User close the browser
    
  Scenario: check for login page
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    Then Check for welcome message "Welcome, please sign in!"
    Then User close the browser