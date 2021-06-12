Feature: Product Details


  @product_details  @smoke
  Scenario: User is able to see the product details
    Given User searched for the product
    When User click on any product
    Then User is navigated to the new tab and product details are displayed

  @product_details
  Scenario: User is able to select the quantity and add to cart from Product details page
    Given User is on the product details page
    When User selects the product quantity as 2
    And User clicks add to cart on the page on product details page
    Then Product is added to the cart








