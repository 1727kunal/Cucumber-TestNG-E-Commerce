Feature: Register

  Background:
    Given User should land on the homepage
    When User clicks on MyAccount button

  @Smoke @Regression
  Scenario: Verify the signup feature for the valid data inputs
    When User clicks on Register button
    Then User should land on the registration page
    When User enters first name
    And User enters last name
    And User enters email
    And User enters telephone
    And User enters password
    And User enters confirm password
    And User checks the privacy policy checkbox
    And User clicks on the continue button
    Then User should be registered successfully
    And User should land on success page
    When User clicks continue button on the success page
    Then User should land on the my account page
