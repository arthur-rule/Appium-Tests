Feature: Check Login Functionality

  Scenario: Positive Login Test at local android device
    When User navigates to login page of swaglabs native application on "local"
    And User logins with valid username and password
    Then Verifies user can see a sample product item on the homepage