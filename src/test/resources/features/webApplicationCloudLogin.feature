Feature: Login Functionality Tests for Cloud Web Application on Mobile Device
@cloudWebAppTest
  Scenario: Positive Login Test on Android Device
    When User navigates to web application of Cloud on a Mobile Device
    And User logins with valid credentials
    Then User verifies successful login action