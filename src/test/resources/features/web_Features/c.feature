Feature: Title
  Background: User logs in
    Given user is on the application "https://takemuch.co.za/index.php?route=common/home" home page

  @web
  Scenario Outline: Validate URL
    When user enters "<username>" in the username field
    And user enters "<password>" in the password field
    Then user clicks on the login button
    But user did not input 50
    But user is not available "Monday,Tuesday,Wednesday"
    Examples:
      | username | password |
      | jude     | boop     |
