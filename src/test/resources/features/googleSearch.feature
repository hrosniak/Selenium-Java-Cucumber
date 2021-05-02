Feature: Coming up in allegro page

  Scenario: Search for SDA
    Given Google Page is opened
    When I close cookie Frame
    When I search for phrase "Software Development Academy"
    Then I can see search results