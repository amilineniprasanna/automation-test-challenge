Feature: Login and Search wordpress org
  Test some possible scenarios of wordpress website login and search

  Scenario Outline: Login with invalid credentials
    Given user is on login page
    When enters username "<username>" password "<password>" and clicks login
    Then it should display login error
    Examples:
      |username             |password             |
      |test                 |                     |
      |                     |test                 |
      |test                 |test                 |

  Scenario: Login with correct credentials and search
    Given user is on login page
    When enters username "aconextesting1" password "aconextesting1secret" and clicks login
    Then user should be able to perform search



