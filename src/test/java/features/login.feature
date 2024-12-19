Feature: User Log In

Scenario: User Go To Login Page
Given the user is in the home page
When the user clicks in the accept cookies option
And the user clicks in the account button
Then the user is at the login page

Scenario: User Login Wrong (email)
Given the user is at the login page
When the user enters the wrong email
Then the email is not correct

Scenario: User Login Wrong (password)
Given the user is at the login page
When the user enters the correct email
And the user enters the wrong password
Then the password is not correct

Scenario: User Login Successful
Given the user is at the login page
When the user enters the correct email
And the user enters the correct password
Then the login was made successfuly