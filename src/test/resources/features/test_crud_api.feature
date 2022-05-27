Feature: Test crud api
  I as a user of the application.
  I need to test with the api for the get, post, get by id and delete methods
  to validate its correct operation

  Background:
    Given that the user consumes on the base endpoint

  @HU-GET
  Scenario: get successful
    When the user uses get the endpoint information
    Then the user will be able to visualize the response status code 200

  @HU-POST
  Scenario Outline: post successful
    When the user uses post the endpoint information
      | name   | salary   | age   |
      | <name> | <salary> | <age> |
    Then the user will be able to visualize the response status code 200
    And the user will be able to visualize the message <option>

    Examples:
      | name | salary | age | option       |
      | test | 1234   | 23  | Successfully |


  @HU-GET-ID
  Scenario: get by id successful
    When the user uses get id the endpoint information whit id 2
    Then the user will be able to visualize the response status code 200
    And the user will be able to visualize the data of the employe consulted

  @HU-DELETE
  Scenario Outline: delete successful
    When the user uses delete the endpoint information whit id 1
    Then the user will be able to visualize the response status code 200
    And And the user will be able to visualize the data of the employe <option>

    Examples:
      | option  |
      | deleted |