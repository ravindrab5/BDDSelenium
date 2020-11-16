@reportcriteria
Feature: Check Default criteria & display criteria of room analytics.

  Background: User navigates to the prop homepage
    Given I navigate to prop homepage.

  Scenario: Check Report criteria popup for first time user.
    When Report criteria should have sections "Date Range","Primary Data","Comparative Data","Data Filters" and "Run Report" section.
    Then Date Range section should have Calender with label "Select Date Range", "Impact Event" label with year dropdown enabled,event list as disabled.
    Then Primary Data source should have option of "Active","Budget","Last Submitted" and none should be selected.
    Then In Comparative Data section all comparative dropdowns should be disabled.
    And  Data Filters should have "Days of Week","Occ %","Segment Category","Sub-Totals","PMS Segments" present.
    And  Days of Week should have options for days of week.
    And  Occ % should have minimum of 0 & maximum of 100 value.
    And  Segment Category,Sub-Totals,Pms Segments should have data as configured for that property.

  Scenario: Check Report Criteria drop down data validations with Date Range.
    When I select Date range and then select primary data.
    Then All dropdowns of the Comparative data gets enabled.
    When I Select "Active" in primary, same range should not have "Active" as option.
    When I Select "Budget" in primary, same range should not have "Budget" as option.

    @thisone
  Scenario Outline: Check Comparative dropdown text as per selection.
    Given Report criteria should be open and calender,primary data should be selected.
    When I select <datasource> in comparative dropdowns.
    Then Selected or all metrics <dropdownlabel> should be displayed.
    Examples:
      |datasource  |dropdownlabel |
      |Budget      |Budget        |
      |All         |All Metrics Selected |

  Scenario: Validate impact event behaviour in report criteria.
    Given There should be impact event present for the property.
    When I select impact event year "2020".
    Then Only Repeating and Annual impact event should be present in impact event list.
    When I select impact event from list.
    Then Calender label should get changed and impact event name should be displayed.
    When I select primary data.
    Then Comparative dropdown should be enabled, prior year should be enabled if there are instance for last year present.
    When I select date range.
    Then Calender Label should get changed and impact event should get disabled.

  Scenario: Validate breadcrum for impact event.
    Given There should be impact event present for the property.
    When I select impact event year "2020".
    And I select impact event from list.
    And I select primary data.
    And I click on go.
    Then BreadCrum should have impact event name and its date.
