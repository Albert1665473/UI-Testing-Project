Feature: SearchProduct

Scenario Outline: Search Product

Given the user is in the index page
When the user clicks the search bar 
And the user enters <article> in the search bar 
And the user clicks the search button
Then the <article> list appears

Examples:
|articles|
|dress|
|jeans|
