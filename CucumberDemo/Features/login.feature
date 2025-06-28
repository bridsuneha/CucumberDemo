Feature: Login with valid credentials

  @sanity @regression
  Scenario: Successful login
    Given the user navigates to login page
    When the user enters valid credentials(username:"sunehasingh55@gmail.com",password:"Hridit19045@")
    And the user clicks on Login button
    Then the user should be redirected to the My Account Page
#@regression
  #Scenario Outline: Successful login
    #Given the user navigates to login page
    #When the user enters valid credentials(username:"<email>",password:"<password>")
    #And the user clicks on Login button
    #Then the user should be redirected to the My Account Page
#
    #Examples: 
      #| email           | password |
      #| suabc@gmail.com | abc@     |
      #| sudef@gmail.com | Suabc@   |
      #| xyz@gmail.com   | sed@     |
