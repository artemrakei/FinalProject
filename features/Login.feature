Feature: Test login page

#  Scenario: Test login page
#    Given I am on main application page
#    When I login as correct user
#    Then I see logout link
#
#  Scenario Outline: Test negative login page
#    Given I am on main application page
#    When I login as user with "<number>"
#    Then I see error message
#    Examples:
#      | number |
#      | 2      |
#      | 3      |

  Scenario Outline: Test negative login page XML
    Given I am on main application page
    When I login as user with "<id>" XML
    Then I see error message
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
#
#  Scenario: Test logout page
#    Given I am on main application page
#    Given I login as correct user
#    When I click logout link
#    Then I see registration link
#
#  Scenario: Test group message
#    Given I am on main application page
#    Given I login as correct user
#    When I choice contacts
#    When I write message
#    Then I see that message was send
#
#  Scenario: Test marked message
#    Given I am on main application page
#    Given I login as correct user
#    When I mark flags messages
#    Then I see marked messages
#
#  Scenario: Test unmarked message
#    Given I am on main application page
#    Given I login as correct user
#    When I choice marked messages
#    When I unmarked message
#    Then I dont see marked messages

#    Scenario: Test moving message in archive
#    Given I am on main application page
#    Given I login as correct user
#    When I choice three messages
#    When I move message in archive
#    Then I see decrease incoming letters