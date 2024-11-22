Feature: Check Login Functionality

  Scenario: Positive Login Test at local android device
    When User navigates to login page of swaglabs native application on "local"
    And User logins with valid username and password
    Then Verifies user can see a sample product item on the homepage

    #https://saucelabs.com/sign-up
@remoteAndroid
  Scenario: Positive Login Test at remote android device
    When User navigates to login page of swaglabs native application on "remote"
    And User logins with valid username and password
    Then Verifies user can see a sample product item on the homepage

@remoteIOS
  Scenario: Positive Login Test at remote iphone device
    When User navigates to login page of swaglabs native application on "remoteIOS"
    And User logins with valid username and password
    Then Verifies user can see a sample product item on the homepage


