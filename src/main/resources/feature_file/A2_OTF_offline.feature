@all @feature @offline
Feature: offline sceanrios

  Scenario: Stream page : offline scenario in stream page
    Given Navigate to the stream page
    When Goes to offline in stream page
    Then You are currently offline toast is displayed in stream page
    When click on the create stream button
    Then Please check your internet connection toast is displayed in stream page
    When click on the create Record video button
    Then Please check your internet connection toast is displayed in stream page
    When click on the Schedule Webinar video button
    Then Please check your internet connection toast is displayed in stream page
    When click on the upcoming tab in stream page
    Then Please check your internet connection toast is displayed in stream page
    When click on the Past tab in stream page
    Then Please check your internet connection toast is displayed in stream page
    When try to search on the search
    Then Please check your internet connection toast is displayed in stream page
    And loader is displayed in stream page
    When connect back to online
    Then Connected toast is displayed in stream page

  #######
  #When loader is should be removed
  #When Goes to offline
  #Then single <content_offline> toast is displayed
  #	When click on the Destination menu
  #	Then single Please check your internet connection toast is displayed in destination page
  #	When Navigate back to stream page
  #	Then single Please check your internet connection toast is displayed in stream page
  #	#When click on the library menu
  #	#Then single Please check your internet connection toast is displayed in Library page
  #	And show stopper Ui with "Something went wrong" content should be displayed
  #	When click on the stream menu from library in offline
  #	Then element is not click able
  #When connect back to online
  #Then single <content_Online> toast is displayed
  #	When click on the Try again button from the show stopper UI
  #	And click on the stream menu
  #	Then page is navigating to the stream page
  #	When Goes to offline
  #	And click on the Members menu
  #	Then single Please check your internet connection toast is displayed on the members page
  Scenario: Destination page : offline scenario in destination page
    When click on the destination menu
    Then page is navigating to the destination page from the stream page
    When Goes to offline in destination
    Then You are currently offline toast is displayed in destination page
    When connect back to online in destination page
    Then Connected toast is displayed is destination page

  Scenario: Library page : offline scenario in library page
    When click on the library menu from destination page
    Then page is navigating to the destination page
    When Goes to offline in library page
    Then You are currently offline toast is displayed in library page
    Then show stopper Ui is displayed in library page
    When click on the try again button from the show stopper Ui in library page
    Then show stopper Ui should not removed in library page
    When connect back to online in library page
    Then Connected toast is displayed is library page
    When click on the try again button from the show stopper Ui in library page
    Then show stopper Ui should be removed from the library page

  Scenario: Members page: offline scenario in members page
    When click on the member menu from library page
    Then page is navigating to the members page
    When Goes to offline in members page
    Then You are currently offline toast is displayed in members page
    When connect back to online in members page
    Then Connected toast is displayed is members page

  Scenario: Pre-preview screen : Offline scenario in pre-preview screen
    Given Navigate to pre-preview screen
    When Goes to offline in pre-preview screen
    Then You are currently offline is displayed in pre-preview screen
    When Click on the Enter stream button
    Then Enter stream button should not be clickable
    And page is not navigating to the studio page
    When connect back to online in pre-preview screen
    Then Connected toast is displayed in pre-preview screen
    When Click on the Enter stream button
    Then page is navigating to the studio page

  Scenario: studio page : offline scenario in studio page
    When Goes to offline in studio page
    Then You are currently offline toast is displayed in studio page
    Then show stopper Ui is displayed in studio page
    When click on the try again button from the show stopper Ui in studio page
    Then show stopper Ui should not removed in studio page
    When connect back to online in studio page
    Then Connected toast is displayed in studio page
    When click on the try again button from the show stopper Ui in studio page
    Then page should be navigating to the pre-preview screen
