
@BDD
Feature: User login

  @login @userpanel
  Scenario: Login
    Given User starts on main page
    When User logs to the user panel
    Then  User arrived on user profile page

  @wordpress @test
  Scenario: Wordpress
    Given User starts on wordpress page
    When User logs to the user panel
#    When User logs to the user panel
#    Then  User can modify user profile