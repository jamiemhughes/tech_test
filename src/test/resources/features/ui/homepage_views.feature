@JIRA:JIR-159
@regresion
Feature: Behaviors for different views on the homepage

  Background:
    Given I am not logged in
    And have navigated to the homepage

  Scenario: Initial homepage display shows exactly 100 results
    Then exactly 100 currency results should be displayed

  Scenario: Default "View All" shows at least 100 results
    When "View All" is chosen
    Then more than 100 currency results should be displayed


  Scenario: Viewing currencies in the watchlist
    When between 5 and 10 random currencies are added to the watchlist
    And the watchlist is viewed in a different browser tab
    Then the previously chosen currencies are correctly displayed in the watchlist
    #  I've only used a name in comparator as the data is live and changes between steps

  @Pending
  Scenario Outline: Applying filters to the full list of tokens
    When the full list of currencies is chosen
    And a market cap filter of <MCAP> is chosen
    And a price filter of <price> is chosen
    And a volume filter of <volume> is chosen
    Then the details of the filtered results should be correct
  Examples: | MCAP | PRICE | VOLUME |
            |      |       |        |
            |      |       |        |
            |      |       |        |
  #    The scenario has the same problem as the previous. After capturing expected results,
  #    actual results will differ as the data is being updated between test steps. (Should be executed on an environment with static data)
