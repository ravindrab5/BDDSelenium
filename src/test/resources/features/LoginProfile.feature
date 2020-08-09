Feature: Login to RevPlan
  As an Mars admin I should be able to login to the system and able to see Mangement Company Listing.
  As an Management admin I should be able to login to the system and able to see the Property Listing.
  As an Above Property admin I should be able to login to the system and able to see the Property Assigned to system.
  As a Property User I should be able to login to the system and able to see the home page of property.

Background:User Navigates to Revplan System.
  Given I am on Revplan System login page.

 @Login
 @smoke
Scenario: Revplan admin sucessful login.
  When I fill in username for mars admin as "mars@ideas.com".
  And I fill in password for mars admin as "ID6asMar5".
  And I click on login button.
  Then management listing page should be displayed.

  @single
  Scenario: Revplan admin unsucessful login.
    When I fill in username for mars admin as "mars@ideas.com".
    And I fill in password for mars admin as "ID6asMar6".
    And I click on login button.
    Then management listing page should be displayed.


