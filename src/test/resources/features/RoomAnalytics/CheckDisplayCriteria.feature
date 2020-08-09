@checkdisplaycriteria
Feature: Validate display criteria functionality.

  Background:User Navigates to Revplan System.
    Given I navigate to property homepage.

    Scenario: Validate the default selected items in display criteria.
      When I open the display criteria.
      Then I should see "Room Nights","Average Rate","Room Revenue" checkbox selected, "RevPar" and "%Contribution" should be unchecked.
      And "Difference" should be selected from Analysis Type.
      And Inventory Option should have label "Select Inventory" intially and ADR Options should have "Select ADR".

    Scenario: Check options present in Inventory & Adr options
      When I open the display criteria.
      Then Inventory options should have items - "Gross Available Rooms","Net Available Rooms","OOO Rooms","Paid Occupancy","Occupancy Group","Occupancy Transient","Financial Occupancy".
      And ADR Options should have items - "ADR Inc Comp","ADR Exc Comp".

    Scenario: Validate selected metrics and analysis type present in report.
      Given Report criteria should be selected with required minimum criteria.
      When I open the display criteria.
      And Select "RevPar","%Contribution","Variance %" and click on go.
      Then Report should have column added for "RevPar","% Cont Rn","% Cont Rev".

    Scenario: Validate statistics and adr rows are displayed in report.
      Given Report criteria should be selected with required minimum criteria.
      When I open the display criteria.
      And Select all inventory options,adr option and click on go.
      Then Report should have rows added for statistics option and adr option.

    Scenario: Validate if all category,sub category & market segment present.
      Given Report criteria should be selected with required minimum criteria.
      When I open the display criteria.
      And Select all inventory options,adr option and click on go.
      Then Report should get generated and should have all categories present.
      And If I click on expand button for each category then respective segments should be present.

      Scenario: Validate the mandatory column generated when selected from display criteria.
        Given Report criteria should be selected with required minimum criteria.
        When I open the display criteria.
        And Select all inventory options,adr option and click on go.
        Then Default display column should be "Rm Nts","ADR" and "Rm Rev".
        When I open the display criteria.
        And Select all the metrics options and click on go.
        Then In report I should see the selected metrics options "Rm Nts","ADR","Rm Rev","RevPar","% Cont Rn","% Cont Rev".