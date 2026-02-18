Feature: Login

  Background:
    Given User should land on the homepage
    When User clicks on MyAccount button
    When User clicks on Login link
    Then User should land on the login page

  @Smoke
  Scenario: Verify login for the valid credentials
    When User enters the email as "alex12345@example.com"
    And password as "alex@123"
    And clicks on login button
    Then User should land on the my account page

  @Regression @DataDriven
  Scenario Outline: Verify login for the valid and invalid credentials
    When User enters the email as "<email>"
    And password as "<password>"
    And clicks on login button
    Then User should see the "<login status>"

    Examples:
      | email                 | password  | login status    |
      | alex12345@example.com | alex@123  | my account page |
      | jerry123@example.com  | jerry@123 | error message   |
