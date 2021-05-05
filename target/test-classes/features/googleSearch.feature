Feature: Coming up for Google page

  Scenario Outline: Search for SDA
    Given Google Page is opened
    When I close cookie Frame
    When I search for phrase "<searchPhrase>"
    Then I click for first element


    Examples:
      | searchPhrase                   |
      | Faceit                         |
      | CallOfDuty                     |
      | League Of legends              |
      | Flashscore                     |
      | Twitter                        |



