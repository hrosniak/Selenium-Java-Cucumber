Feature: Coming up for Google page

  Scenario Outline: Search for SDA
    Given Google Page is opened
    When I close cookie Frame
    When I search for phrase "<searchPhrase>"
    Then I can see search results

    Examples:
      | searchPhrase                   |
      | Software Development Academy   |
      | Selenium Cucumber              |
      | League Of legends              |
      | Flashscore                     |


