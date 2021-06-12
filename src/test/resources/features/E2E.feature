Feature: End to end

  @smoke @e2e
  Scenario: User is able to order single product with single quantity from the app
    Given User is able to login in the app
    And User is able to search for the product and add the product to the cart with quantity as 1
    And User navigates to my cart and clicks on Buy
    And User selects the address
    When User clicks on Place order with delivery option as "CoD"
    Then Order is placed for the user
    And Order details can be seen in order details page

  @smoke @e2e
  Scenario: User is able to order single product with multiple quantity from the app
    Given User is able to login in the app
    And User is able to search for the product and add the product to the cart with quantity as 2
    And User navigates to my cart and clicks on Buy
    And User selects the address
    When User clicks on Place order with delivery option as "CoD"
    Then Order is placed for the user
    And Order details can be seen in order details page

  @smoke @e2e
  Scenario: User is able to order multiple product with single quantity from the app
    Given User is able to login in the app
    And User is able to search for the product "laptop" and add the product to the cart with quantity as 1
    And User is able to search for the product "mobile" and add the product to the cart with quantity as 1
    And User navigates to my cart and clicks on Buy
    And User selects the address
    When User clicks on Place order with delivery option as "CoD"
    Then Order is placed for the user
    And Order details can be seen in order details page

  @smoke @e2e
  Scenario: User is able to order multiple product with multiple quantity from the app
    Given User is able to login in the app
    And User is able to search for the product "laptop" and add the product to the cart with quantity as 2
    And User is able to search for the product "mobile" and add the product to the cart with quantity as 2
    And User navigates to my cart and clicks on Buy
    And User selects the address
    When User clicks on Place order with delivery option as "CoD"
    Then Order is placed for the user
    And Order details can be seen in order details page







