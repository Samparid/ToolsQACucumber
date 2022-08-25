Feature: Search and Place the order for Products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and Offers page
    Given User is on Green Landing page
    When user searched with Shortname <Name> and extracted actual name of product
    When And Added "3" items of the selected product to cart
    Then User proceed to Checkout and validate the <Name> items in checkout page
    And Verify user has ability to enter promo code and place the order

    Examples:
      | Name   |
      | Tom    |
