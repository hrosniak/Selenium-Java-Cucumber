Feature: Sign in to Call Of Duty

  Background:
    Given Home page is opened
    When I open login page
    Then Login Page is opened

  Scenario: Authentication - empty login form
    And I click Sign button
    Then I can see error message "Please enter a password"

  Scenario Outline: Authentication - incorrect value
    And I fill email address field "<emailAddress>"
    And I fill password field "<password>"
    And I click Sign button
    Then I can see error message "<errorMessage>"
    Examples:
      | emailAddress              |password                 | errorMessage                       |
      |                           |                         | Please enter a password            |
      | HubertTest123@gmail.com   |password                 | invalid password                   |
      | huberttest123@gmail.com   |HubertTest21             |                                    |
      | test_test.pl              | test                    | Please enter a valid email address |

    Scenario: Authentication - positive flow
      When I authenticate using credentials
      | email address         | password    |
      |huberttest123@gmail.com|HubertTest22 |
      Then I can see My Account Page


