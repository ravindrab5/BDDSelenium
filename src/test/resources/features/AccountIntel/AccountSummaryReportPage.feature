@AccountSummaryTest
Feature: Account Intel Profile Management SummaryReport Functionality

  Background: User navigates to the prop homepage
    Given Navigate to property homepage for production.
    And Profiles data and its reservation are populated already.

  Scenario:Validate minimal Grid column should be Master Account Name
    When I navigate to account intel production.
    And I Open date range calender icon.
    And Select date "TODAY-2" and "TODAY+2" date in the calender.
    And Click on the report criteria go button.
    Then Grid should have columns.
    | #              |
    | Master Account |


  Scenario:Validate Volume Metrics List
    When I navigate to account intel production.
    And Open "Volume metrics" dropdown.
    Then "Volume metrics" list should contain.
    |All Volume Metrics            |
    |Rm Nt Production              |
    |Rm Nt % Contribution          |
    |Account Lead Time             |
    |Comp Seg Lead Time            |
    |Avg Length of Stay            |
    |Stay Pattern Value             |

  Scenario: Validate Rm Rev Metrics List
    When I navigate to account intel production.
    And Open "Room Revenue metrics" dropdown.
    Then "Room Revenue metrics" list should contain.
    |All Rm Rev Metrics    |
    |Account ADR           |
    |Comp Segment ADR      |
    |% Discount to Comp ADR|
    |Room Revenue          |
    |Rm Rev % Contribution |

  Scenario: Validate Account Type List
    When I navigate to account intel production.
    And Open "Account Type" dropdown.
    Then "Account Type" list should contain.
      |All Accounts                 |
      |Contracted Accounts          |
      |Non-Contracted Accounts      |


  Scenario: Validate Account Hierarchy List
    When I navigate to account intel production.
    And Open "Account Hierarchy" dropdown.
    Then "Account Hierarchy" list should contain.
      |Master Accounts Only                 |
      |Master+Sub-Linked Accounts           |
    When I select "Master+Sub-Linked Accounts" from "Account Hierarchy" dropdown.
    Then Label for "Account Hierarchy" drop down should be "Master+Sub-Linked Accounts".


  Scenario: Validate account name search for selected Account Type
    When I navigate to account intel production.
    And I select "Contracted Accounts" from "Account Type" dropdown.
    And Search profile "Microsoft Corporation" in account search.
    Then Search result should contain.
      |All Profiles                         |
      |Microsoft Corporation                |
    When I select "Non-Contracted Accounts" from "Account Type" dropdown.
    And Search profile "*Fire" in account search.
    Then Search result should contain.
      |All Profiles                         |
      |Microsoft Corporation                |
    When Search profile "*ditex" in account search.
    Then Search result should contain.
      |All Profiles                         |
      |Inditex                              |
    When I select "Non-Contracted Accounts" from "Account Type" dropdown.
    And Search profile "Microsoft Corporation" in account search.
    Then Search result should contain.
      |All Profiles                         |
      |Microsoft Corporation                |

 @dayofweektest
  Scenario: Validate Days of Week Default List
    When I navigate to account intel production.
    Then Label for "Days Of Week" drop down should be "All Days Of Week".
    When Open "Days Of Week" dropdown.
    Then "Weekdays" list should contain.
    |Monday|
    |Tuesday      |
    |Wednesday    |
    |Thursday     |
    |Friday       |
    And "Weekends" list should contain.
    |Saturday   |
    |Sunday |
    When I deselect "Days Of Week" list
    |Tuesday        |
    |Saturday       |
    Then Label for "Days Of Week" drop down should be "5 Days Selected".

  Scenario: Validate Market Segments Default List
    When I navigate to account intel production.
    Then Label for "Days Of Week" drop down should be "All Days Of Week".
    When I Click "Market Segment" Drop down.
    Then "Hotel" list should contain.
    |RET1          |
    |RET2          |
    |RET1NAP       |
    |NLRA1         |
    |NLRA2         |
    |Revenue Only  |
    |SegAP         |
    |SegBP         |
    |RoomsOnly     |
    When I deselect "Market Segment" list
    |RET1NAP|
    |RET2   |
    And I Click "Market Segment" Drop down.
    Then Label for "Market Segment" drop down should be "7 Market Segments Selected".

@thisisfailing
  Scenario: Validate the selected Filters displayed properly
    When I navigate to account intel production.
    And I select Impact Event year "2020".
    And I select impact event "Independence Day".
    And I Click "Days Of Week" Drop down.
    And I deselect "Days Of Week" list
      |Thursday     |
      |Sunday       |
      |Friday       |
      |Saturday     |
    And I Click "Days Of Week" Drop down.
    And I set occupancy percentage from "10" to "90".
    And I type the production "from" field as "10".
    And I type the production "to" field as "20".
    And Click on the report criteria go button.
    Then BreadCrum slice text for "DOW" should be "Mon,Tue,Wed".
    And BreadCrum slice text for "Occ" should be "10% - 90%".


  Scenario: Tests date range in the breadcrum for calender and impact event
    When I navigate to account intel production.
    And I Open date range calender icon.
    And Select date "TODAY-2" and "TODAY+2" date in the calender.
    And Click on the report criteria go button.
    Then BreadCrum slice text for "Date Range" should be of selected date "TODAY-2" and "TODAY+2".
    When I Open the report criteria
    And I select Impact Event year "2020".
    And I select impact event "Republic Day".
    And Click on the report criteria go button.
    Then BreadCrum slice text for "Date Range" should be "Jan 26 - Jan 26, 2020".
    And BreadCrum slice text for "Impact Event" should be "Republic Day".
















































