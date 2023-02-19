@reg
Feature: Register User

  @regUser
  Scenario Outline: DevEx User Register
    Given User creates a POST request with "<email>" and "<password>" and "<name>" and "<google>" and "<facebook>" and "<github>"
    Then Verify that status code for register request is 200
    Then Verify that body contains "token
    And Compiler gets the token
    Examples:
      | email             | password  | name   | google  | facebook | github  |
      | bjorn13@gmail.com | Test65487 | bjornm | gobjornl | fabjornl  | gibjornl |

  @regProfile
  Scenario Outline: User should be able to send POST request get the token saves profile
    Given User creates a POST request and send the token with "<company>" "<webSite>" "<location>" "<status>" "<skills>" "<githubusername>" "<youtube>" "<twitter>" "<facebook>" "<linkedin>" "<instagram>"
    Then Verify that status code should be 200
    Then verify that name "bjornm" and email as "bjorn13@gmail.com"

    Examples:
      | company | webSite       | location | status    | skills | githubusername | youtube      | twitter      | facebook      | linkedin      | instagram      |
      | Apple   | www.apple.com | Virginia | Developer | API UI | appleGit       | appleYoutube | AppleTwitter | appleFacebook | AppleLinkedin | AppleInstagram |
