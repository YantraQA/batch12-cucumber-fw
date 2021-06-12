@healthcheck
Feature: E-commerce Project Web Site Health Check

  Scenario: Navigation to the URL
    Given User navigated to the home application url

  @smoke
  Scenario: Open Browser and Navigate
    Given User Opened the Browser
    When User navigated to the app url
    Then User is able to see application landing page





