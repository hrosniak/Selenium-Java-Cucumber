Feature: Login to Google account

  Background:
    Given Home page is opened
    When I close cookie frame
    Then Login Page is opened


  Scenario Outline: Authentication - incorrect value
    And I fill email address field "<emailAddress>"
    And I fill password field "<password>"
    And I click Sign button
    Then I can see error message "<errorMessage>"
    Examples:
      | emailAddress                |password               | errorMessage                                                    |
      |                             |                       | Enter an email or phone number                                  |
      | HubertTest123@gmail.com     | password              | Wrong password. Try again or click Forgot password to reset it. |
      | 43543543543543543545454     | HubertTest21          | Couldn't find your Google Account                               |
      | dsadasdsadasdsadas          | test                  | Wrong password. Try again or click Forgot password to reset it. |
      | HubertTest2021@gmail.com    |                       | Enter a password                                                |

    Scenario: Authentication - positive flow
      When I authenticate using credentials
      | email address         | password      |
      |huberttest123@gmail.com|HubertTest123! |
      Then I can see My Account Page


