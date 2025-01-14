@all @feature @login_page
Feature: Scenarios on the login page

  Scenario: login page : go to offline and check the toast content
    Given Navigate to login the page
    When go to offline in login page
    Then You are currently offline toast should be displayed

  Scenario: Login page : click on the sigin in offline
    Given Navigate to login page
    When click on the signin btn in offline
    Then Please check your internet connection toast should be displayed

  Scenario: Login page : come back to online in login page
    Given Navigate to login page
    When come back to online in login page
    Then Connected toast should be displayed in login page

	@login
  Scenario: Login the application
    Given Navigate to login page
    When Enter the username and password and click on the login the button.
    Then If login success page should be navigating to the stream page.
