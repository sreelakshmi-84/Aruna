Feature: User Accounts
  Scenario: Login successfully
    Given user in navigation site
    When user enters username as"arunab7@gmail.com"
    And password "Sahithi0416"
    And submit login
    Then Login successfully into system
