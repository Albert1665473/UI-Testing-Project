

Feature: Search Near Shops

Scenario: search near shops
   Given the user is in the home page
   When the user clicks in the accept cookies option
   And the user clicks on the shops option
   And the user writes the city in the search bar and selects the first option
   And the user selects the store
   And the user clicks on the see more button
   Then the shop of the desired location appears