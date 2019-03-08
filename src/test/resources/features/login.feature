Feature: Check the correct behavior of the login features

  Scenario Outline:  SC01.Check that the user sets the invalid credentials,
  the app responses with an error feedback.
    Given I go to 'http://automationpractice.com'
    When I try to login with the following credentials:
      | <username> | <password> |
    Then I should see the following message:
    """
    Authentication failed.
    """

    Examples: Invalid Credentials
      | username               | password        |
      | invalidEmail@gmail.com | invalidPassword |


