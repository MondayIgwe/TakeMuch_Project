Feature: Test Karate API
  Background:
    * def variabl = 'getVar'
    * url "https://api.spotify.com/"
    #When  param user = 'root'
    * callonce 'getSomething'


  @karateSanity
  Scenario: test GITHUB Get Method
    Given path 'v1/albums'
    And method get
    Then status code should be 200
    * print variabl