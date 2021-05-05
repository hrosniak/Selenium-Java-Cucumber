Feature: Sign in to Call Of Duty

  Background:
    Given Home page is opened
    When I open login page
    Then Login Page is opened

  Scenario: Authentication - empty login form
    And I click Sign button
    Then I can see error message

  Scenario: Authentication - incorrect value
    And I fill email address field
    And I fill password field
    And I click Sign button
    Then I can see error message

