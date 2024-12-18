Feature: SearchProduct

Scenario: Show Search Product
Given the user is in the home page
When the user clicks in the accept cookies option
And the user types the product in the search bar
And the user clicks the search button
Then the product list appears

Scenario: Show Product Details
Given the product list appears
When the user clicks on product container
Then the product detail info appears