Feature: Google search functionality title verification
  User Story: As a user, when I am on the Google search page
  I should be able to search whatever I want and see the relevant information


  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types Loop Academy in the google search box and click enter
    Then user should be able to see Loop Academy - Google search in the google title


    Scenario: Search functionality result title verification
      Given user is on Google search page
      When user types "Loop Academy" in the google search box and click enter
      Then user should be able to see "Loop Academy - Google Search" in the google title

  @google_search
  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types "Nazarii Duvanov" in the google search box and click enter
    Then user should be able to see "Nazarii Duvanov - Google Search" in the google title