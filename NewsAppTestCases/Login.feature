@Sanity
Feature: News App Appium Tests

  Scenario: As a user I want to login in to app
    Given The user opens app and validate News logo
    Then login screen with user name and password entries and login button is displayed

  Scenario Outline: user login failed
    Given The user enter credentials "<UserName>" and "<Password>"
    When login button is clicked
    Then error markers are displayed

    Examples: 
      | UserName | Password |
      | password | password |
      | user     | test     |

  Scenario Outline: user login succeed (credentials provided below)
    Given The user enter credentials "<UserName>" and "<Password>"
    When login button is clicked
    Then user is taken to the news screen

    Examples: 
      | UserName | Password |
      | user     | password |

  Scenario: User opens app next time
    Given user is taken to the news screen

  Scenario Outline: failed to load images
    Given There is no internet connection
    When The user enter credentials "<UserName>" and "<Password>"
    And login button is clicked
    Then faied load new error message is dispayed

    Examples: 
      | UserName | Password |
      | user     | password |

  Scenario Outline: NewsImages are loaded
    Given There is internet connection
    And The user enter credentials "<UserName>" and "<Password>"
    And login button is clicked
    Then Images are load and displayes on the list

    Examples: 
      | UserName | Password |
      | user     | password |
