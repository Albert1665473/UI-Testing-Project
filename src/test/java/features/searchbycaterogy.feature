
Feature: SearchCategory


Scenario: Show Category
    Given the user is in the home page
    When the user clicks in the accept cookies option
    And the user clicks on the category section
    And the user selects the sport
    And the user selects helmet category
    Then the helmet section page appears