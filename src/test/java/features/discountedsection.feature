Feature: See Discounted Section

  Scenario: DiscountedSection
    Given the user is in the home page
    When the user clicks in the accept cookies option
    And the user clicks on the category of discounted products section
    And the user selects see all the discounts
    Then the list of discounted products appears