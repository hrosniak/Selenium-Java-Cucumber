Feature: Choose product from Gamivo

  Scenario:
    Given Home page is opened
    When I choose seventh product from popular
    And I going to product page
    And I choose first offer from list and add product to cart
    And I choose price without SMART service
    And I switch to cart
    And I increase number of products to three
    And Add random coupon
    Then I see error message of coupon