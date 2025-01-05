Feature: SelectFilterOfAProduct


Scenario: Select Filter
    Given the user is in the home page
    When the user clicks in the accept cookies option
    And the user clicks on the sports button
    And the user clicks on the category swimming
    And the user selects flip flops section
    And the user selects the filter by color
    Then the flip flops with the color selected appears
