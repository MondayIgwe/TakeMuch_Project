Feature: Rest Test
  In order to test rest services
  As a registered user
  I want to specify the rest services test conditions

  Scenario: Get Request
    When user sends request "http://api.github.com/users/"
    Then status code should be 200
    And response type should be "json"
    And response contains user name "monday"

  Scenario: POST request
    When user sends a post request to "http://" with the following details
      | key     | value |
      | string  | folos |
      | integer | 200   |
      | char    | a     |