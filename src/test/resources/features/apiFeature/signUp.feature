Feature: Register User

  @regUser
  Scenario Outline: DevEx User Register
    Given User creates a POST request with "<email>" and "<password>" and "<name>" and "<google>" and "<facebook>" and "<github>"
    Then Verify that status code for register request is 200
    Then Verify that body contains "token
    Examples:
      | email             | password  | name   | google  | facebook | github  |
      | bjorn11@gmail.com | Test65487 | bjornk | gobjorn | fabjorn  | gibjorn |
