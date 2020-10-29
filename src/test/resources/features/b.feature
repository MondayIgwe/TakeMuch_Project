@debug
Feature: Existing User

  @rest
  Scenario: Rest API
    Given user send a GET request "https://reqres.in/api/users?page=2"

  @web2 @regression
  Scenario: Existing user Validation(Data Table)
    Given user is on the application landing page
    Then we verify expected outcome of the following
          |firstName|lastName|phone|
          | lesego  | brown  |joel |
          |jude     |frank   |james|