Feature: Customer Registration
@regression
  Scenario: Successful Account Registration
    Given the user is  navigates to  registration page
    When the user enters below data in below field
      | firstName | John       |
      | lastName  | Kenedy     |
      | telephone | 1234567890 |
      | password  | test@123   |
    And user selects the privacy policy
    And users clicks on continue button
    Then user acoount registration is done successfully
