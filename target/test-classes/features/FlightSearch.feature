Feature: Turkish Airlines Flight Search
  As a user of Turkish Airlines website
  I want to search for available flights
  So that I can plan and book my travel

  Background:
    Given I am on the Turkish Airlines homepage

  @smoke @flightSearch
  Scenario: Successful one-way flight search
    When I enter origin "Istanbul" and destination "London"
    And I click the search button
    Then flight results should be displayed

  @regression @flightSearch
  Scenario Outline: Search flights between multiple cities
    When I enter origin "<origin>" and destination "<destination>"
    And I click the search button
    Then flight results should be displayed

    Examples:
      | origin    | destination  |
      | Istanbul  | New York     |
      | Ankara    | Dubai        |
      | Istanbul  | Paris        |

  @smoke
  Scenario: Verify homepage title
    Then the page title should contain "Turkish Airlines"
