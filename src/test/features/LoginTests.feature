@End2End
@LoginTests
Feature: Check for valid and invalid logins
@PositiveLogin
Scenario Outline: Register into the website automationpractice
Given the user is on home page
When the user clicks on Sign In link
And the user provides the email-ID as "<eID>"
Then the user is directed to create an account


Examples: Valid user
|   eID               |
| rft@abc.com         |
| rdt@123.com        |
| tellis@reuben.123   |
| rft@\123.com        |

@NegativeLogin
Scenario Outline: Register into the website automationpractice.com
Given the user is on home page
When the user clicks on Sign In link
And the user provides the email-ID as "<eID>"
Then an error message is displayed

Examples: Invalid user
| eID                 |
| rft.com             |
| rdt                 |
| tellis.com.hjhsvsdl |
|                     |
| !@#@$%^.com         |
