Feature: Rest Test
  In order to test rest services
  As a registered user
  I want to specify the rest services test conditions

  Scenario: Get Request
    When user sends request "https://reqres.in/api/users?page=2"
    Then status code should be 200
    And response type should be "json"
    And response contains user name "monday"