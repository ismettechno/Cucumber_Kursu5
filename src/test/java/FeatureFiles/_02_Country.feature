Feature: Country Functionality

  @SmokeTest
  Scenario: Create a country
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully
    And Navigate to country page
    When create a country
    Then Success message should be displayed

