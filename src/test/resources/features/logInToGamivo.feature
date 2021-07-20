Feature: Sign in to Gamivo

  Background:
    Given Home page is opened
    When I open login page and close notifications
    Then I click login button and login page is opened


  Scenario Outline: Authentication - incorrect value
    And I fill email address field "<emailAddress>"
    And I fill password field "<password>"
    Then I click Sign button

    Examples:
      |emailAddress             |password        |
      |                         |                 |
      |HubertTest123@gmail.com  |password         |
      |huberttest123@gmail.com  |HubertTest21     |
      |test_test.pl             |test             |

  Scenario: Authentication - positive
    When I authenticate using credentials
      |emailAdress            |   password       |
      |huberttest123@gmail.com|HubertTest22      |

    Then I can see My Account Page