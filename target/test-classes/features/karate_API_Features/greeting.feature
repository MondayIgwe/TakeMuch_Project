@karateDebug
Feature: greeting end-point

  Background:
    #* url 'https://jsonplaceholder.typicode.com'
  * url 'https://api.spotify.com/'

  Scenario: Get Method
    * path 'v1/albums'
    When method get
    Then status 200
     And print <string>

  @parallel=false
  Scenario: Post Method
    * path 'posts'
    When method post
    Then status 200