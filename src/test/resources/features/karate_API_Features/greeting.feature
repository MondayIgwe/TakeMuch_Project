@karateDebug
Feature: greeting end-point

  Background:
    * url 'https://jsonplaceholder.typicode.com'

  Scenario: Get Method
    * path 'comments'
    When method get
    Then status 200

  @parallel=false
  Scenario: Post Method
    * path 'posts'
    When method post
    Then status 200