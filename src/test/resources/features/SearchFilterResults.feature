@search_filter
Feature: Search Filter

  @t
  Scenario: User is able to filter the result based on Prices
    Given User navigated to the home application url
    And User Search for product "laptop"
    When User enters minimum price as "30000" and maximum price as "40000" mentioned in below table
    Then Verify that Search results gets filtered with price range between 30000 and 40000

    Scenario: User is able to filter the result based on Prices
      Given User navigated to the home application url
      And User Search for product "Computer"
      When User enters minimum price and maximum price as mentioned in below table
        |MIN_PRICE|MAX_PRICE|
        |30000    |40000    |
      Then Search results gets filtered with price range as mentioned in below table
        |MIN_PRICE|MAX_PRICE|
        |30000    |40000    |

#
#  @t
#  Scenario: Datatable example
#    Given want to send multiple items in list form
#      | Akash  |
#      | Sarang |
#      | Satya  |
#      | Manish |
#
    Given want to send multiple items in map of List
      | Akash  | 2 | 5|56|4564|456|
      | Sarang | 3 | 45|546 |456|7|
      | Satya  | 4 | 45|7   |7  |7|
      | Manish | 5 | 56|7   |8  |8|
