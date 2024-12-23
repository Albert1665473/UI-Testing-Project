Feature: Add Product to Cart

Scenario: Select Size
Given the user is in the home page
When the user clicks in the accept cookies option
And the user types the product in the search bar
And the user clicks the search button
And the user clicks on product container
And the user selects size
Then the size product is selected

Scenario: Add To Cart
Given the size product is selected
When the user adds product to cart
Then the product is added to cart

Scenario: Info cart
Given the product is added to cart
When the user clicks on the cart button
Then the cart info shows with added products