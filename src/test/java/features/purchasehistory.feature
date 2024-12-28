Feature: User Purchase History Query

Scenario: User Go To Login Page
Given the user is in the home page
When the user clicks in the accept cookies option
And the user clicks in the account button
Then the user is at the login page

Scenario: User Login Successful
Given the user is at the login page
When the user enters the correct email
And the user enters the correct password
Then the login was made successfuly

Scenario: User Purchase History Query
Given the login was made successfuly
When the user clicks on the purchase history
And the user clicks on the last purchase
Then the purchase information shows