Feature: Read FAQ

Scenario: Enter To FAQ Forum
Given the user is in the home page
When the user clicks in the accept cookies option
And the user clicks on the FAQ button
Then the FAQ forum shows

Scenario: Consult One Question
Given the FAQ forum shows
When the user consults one question
Then the question shows