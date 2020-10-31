@parallel=false
Feature: Test Karate API

  Background:

  @karateSanity
  Scenario: test GITHUB Get Method
    Given url "https://api.spotify.com/v1/albums"
    And method get
    Then status code should be 200