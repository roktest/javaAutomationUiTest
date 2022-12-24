@Ebay
Feature: Ebay advance search page Scenarios

  @Test2
  Scenario: As user I want to go to advance search from Ebay home page
    Given I am on Ebay advance search page
    When I click on Ebay logo
    Then I navigate to Ebay home page

  @p1 @singleDataTable  @setCookies
  Scenario: As user I want to go to advance search from Ebay home page
    Given I am on Ebay advance search page
    When I enter a keyword, exclude word, minimum and maximum fields
      | keyword  | exclude    | minimum | maximum |
      | iphone11 | refubished | 300     | 1000    |
    Then I validate at least 100 search items present
