@End2End
@TestSummerDressesAndSorting
Feature: Check menu options and Validate sorting

@MegaMenucheck
Scenario: Check whether Megamenu works
Given The user is on home page
When the user selects Dresses tab
And the user selects Summer Dresses
Then Summer Dresses page is displayed

# @SortSummerDressesAscending and @SortSummerDressesDescending can be combined by passing a string value for sorting order
# Use the following expression in place of "ascending" or "descending" 
# to pass String values to the step definition file: \”(.*)\” and \”(.*)\”$”)
# Also the logic in the Then condition will need to be verified using If condition

@SortSummerDressesAscending
Scenario: Sort Summer Dresses Ascending
Given the user is on Summer Dresses page
When the user selects to sort dresses by ascending price
Then Summer Dresses are sorted in ascending order of price


@SortSummerDressesDescending
Scenario: Sort Summer Dresses Descending
Given the user is on Summer Dresses page
When the user selects to sort dresses by descending price
Then Summer Dresses are sorted in descending order of price




