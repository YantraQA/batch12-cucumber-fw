Feature: Cart scn

  @cart  @smoke
  Scenario: User can view his added items in the cart
    Given User has added multiple products in the cart
    When User navigates to the My Cart Page
    Then User is able to see the list of all the added items with correct quantities as well as price totals is correct

  @cart
  Scenario: User can delete the items in the cart
    Given User has added multiple products in the cart
    And User navigates to the My Cart Page
    When User deletes an item from the cart
    Then Item should be delete and should not appear in the cart item list
    And deleted item amount should be removed from the total cart amount

  @cart
  Scenario: User can reduce the items quantity in the cart
    Given User has added products with multiple quantity in the cart
    And User navigates to the My Cart Page
    When User reduces an item quantity from the cart
    Then Item should be reduced in the quantity
    And reduced item amount should be re-calculated from the total cart amount

  @cart
  Scenario: User can add the items in the cart
    Given User has added single item with single quanity in the cart
    And User navigates to the My Cart Page
    When User increase the product quantity by 1
    Then Product quantity is increased by 1 and cart total should re-calcualte the total amount






