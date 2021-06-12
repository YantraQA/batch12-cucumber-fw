@search
Feature: Search Feature

  Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    Given User navigated to the home application url
    When User Search for product "Laptop"
    Then Search Result page is displayed


  Scenario Outline: User is able to search multiple products
    Given User navigated to the home application url
    When User Search for product "<product_name>"
    Then Search Result page is displayed
    Examples:
      |product_name|
      | laptop     |
      | earphone   |
      | computer   |

  @search  @smoke
  Scenario: User is able to Search for a Product
    Given User Opened the Browser and User navigated to the App url
    When User search for a new product
    Then Search result for the product is displayed

  @search
  Scenario: User is able to filter the search based on price
    Given User search for a Product as "Laptop"
    When User enters minimum as "20000" and maximum as "50000" in the filter criteria
    Then User is able to see results with price between "20000" and "50000"






