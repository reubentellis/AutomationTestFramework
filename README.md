# AutomationTestFramework
Solution to test login and sorting in http://automationpractice.com using cucumber, maven and junit along with selenium webdriver

## Feature Files

The solution contains 2 feature files
  1. LoginTests.feature (Contains test scenarios for login)
  2. OptionsCheckTest.feature (Contains test scenarios for Megamenu operations and sorting Summer Dresses via price)

## Step Definition Files

The corresponding step definition files for the above mentioned feature files are as follows:
  1. LoginTests_Steps.java
  2. OptionsCheckTest_Steps.java
  
## Page Objects
 
 This folder contains the files which instantiate the pages under test.
 
## TestFiles folder
 
 The TestFiles folder contains the chromedriver and geckodriver required to execute the tests on Chrome and Firefox browsers respectively.
 
## Execution
 
 To execute the code end to end in firefox using maven download the files and in the command prompt run the following:
        ``` mvn test -Dbrowser=firefox -Dcucumber.options="--tags @End2End"```
 To execute the code end to end in chrome using maven download the files and in the command prompt run the following:
        ``` mvn test -Dbrowser=chrome -Dcucumber.options="--tags @End2End"```
