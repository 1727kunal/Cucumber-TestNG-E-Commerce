Feature: Verifying the login with data table

  @DataDriven
  Scenario: Verifying the login feature with valid and invalid inputs using the data table
    Given User should land on the homepage
    When User clicks on MyAccount button
    When User clicks on Login link
    Then User should land on the login page
    When User enter the below credentials and clicks the login button then login process should be complete
      | email                  | password  | expected |
      | jerry12345@example.com | jerry@123 | invalid  |
      | james12345@example.com | james@123 | invalid  |
      | alex12345@example.com  | alex@123  | valid    |
