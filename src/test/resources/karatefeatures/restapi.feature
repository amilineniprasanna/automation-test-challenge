Feature: REST API Nasa neo results search
  Background:
    * url 'https://api.nasa.gov/neo/rest/v1/neo/'

  Scenario: Browse all Nasa neo results and get details of first item from response

    Given path 'browse'
    And param api_key = 'DEMO_KEY'
    And param page = '0'
    And param size = '1'
    When method GET
    Then status 200
    * def id = response.near_earth_objects[0].id
    Given path id
    And param api_key = 'DEMO_KEY'
    When method GET
    Then status 200
    And match id == response.id