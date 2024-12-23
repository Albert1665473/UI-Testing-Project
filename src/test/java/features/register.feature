Feature: User Sign in

Scenario: User Go To Sign in Page
Given the user is in the home page
When the user clicks in the accept cookies option
And the user clicks in the account button
And the user clicks on register button
Then the user is at the sign in page

Scenario: User Signs in
Given the user is at the sign in page
When the user registers his email
And the user creates a password
Then the user has to accept the terms