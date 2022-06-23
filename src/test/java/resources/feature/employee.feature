Feature: Testing different request on rest api application

  #@SMOKE
  Scenario: User should able to fetch employee information
    When User send GET request to employee endpoint
    Then User should see status code 200

  #@REGRESSION
  Scenario: User should able to fetch employee where id is 8
    When User send GET request to employee endpoint where id is 8
    Then User should see status code 200

  Scenario Outline: User should able to add new data to server
    When user send POST request with name "<name>" salary "<salary>" age "<age>"
    Then User should see status code 200
  Examples:
           |      name      | salary | age |
           |Sachin Tendulkar|10000000| 40  |

  Scenario Outline: User should able to update data
    When User send PATCH request with name "<name>" id 6419
    Then User should see status code 200

  Examples:
           |  name  |
           | dhoni  |

