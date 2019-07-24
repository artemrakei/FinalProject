Feature: Test API VK

  Scenario: Test create post
    Given I create basic URL
    Given I create basic ID
    When I login as correct user
    Then I see logout link