Feature: API behaviors on the cryptocurrency endpont

  Scenario Outline: Price conversion
    Given a request is made to retrieve the ID for the crypto:"<crypto>"
    When the price conversion is requested for "<currency>"
    Then then a conversion reponse should be received
  Examples:
    | crypto | currency  |
    | BTC    | BOB |
#    | USDT   | BOB |
#    | ETH    | BOB |

  Scenario Outline: Retrieving technical documentation
    Given I make a request to retrieve the technical documentation for <name> with id: <id>
    Then a status of 200 should be received
    And the logo should be <logo>
    And the technical doc uri shoudl be <tech_uri>
    And the symbol should be <symbol>
    And the date added should be <date_added>
    And the platform should be <platform>
    And the tags contain <tags>
  Examples:
    | name     | id   | logo                                                         | tech_uri                                          | symbol | date_added               | platform | tags     |
    | Ethereum | 1027 | https://s2.coinmarketcap.com/static/img/coins/54x54/1027.png | https://github.com/ethereum/wiki/wiki/White-Paper | ETH    | 2015-08-07T00:00:00.000Z | null     | mineable |