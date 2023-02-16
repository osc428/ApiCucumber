Feature: Retrieve Profile
@allUsers
  Scenario: user should be able to see all profiles

    Given User creates a GET request to see all profiles
    Then Verify that status code is 200

  @allUsers2
  Scenario: User should be able to see all profiles with second way
    Given User creates a GET request to see all profiles with second way
    Then Verify that status code is 200 with second way

  @wip
  Scenario Outline: GET request with path param
    Given User creates a GET request with path "<id>"
    Then Verify that status code is 200
    Then Verify that user info's "<name>" and "<email>" and "<company>" and "<location>"
    Examples:
      | id  | name         | email                | company  | location |
      | 236 | Mike Masters | etsMntr@eurotech.com | eurotech | Germany  |


