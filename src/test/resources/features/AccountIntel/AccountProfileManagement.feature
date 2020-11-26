@profilemanagement
Feature: Account Intel Profile Management Functionality.

  Background: User navigates to the prop homepage
    Given User navigate to property homepage.
    And Profiles and its reservation are populated already.

    @sample
  Scenario: Validate grid data is sorted from high to low.
    When I navigate to account intel page.
    And Select the criteria with sort high to low for rn.
    Then Grid should contain profiles.
        |Airbus Group            |
        |Microsoft Corporation   |
        |CHAP BB test            |
        |PricewaterhouseCoopers  |
        |Eli Lilly & Company     |
        |Inditex                 |
        |Fortum Corporation      |
        |Boston Consulting Group |
        |National Oilwell Varco  |

  Scenario: Validate grid data is sorted from low to high.
    When I navigate to account intel page.
    And Select the criteria with sort low to high for rn.
    Then Grid should contain profiles.
      |National Oilwell Varco    |
      |Boston Consulting Group   |
      |Fortum Corporation        |
      |CHAP BB test              |
      |PricewaterhouseCoopers    |
      |Eli Lilly & Company       |
      |Inditex                   |
      |Microsoft Corporation     |
      |Airbus Group              |

  Scenario: Validate grid maintains the sorting order even after linking delinking of profiles.
    When I navigate to account intel page.
    And Link profile.
        |Master_Profile|Subprofile            |
        |PricewaterhouseCoopers  |CHAP BB test|
    Then Grid should contain profiles.
        |National Oilwell Varco |
        |Boston Consulting Group|
        |Fortum Corporation     |
        |Inditex                |
        |Eli Lilly & Company    |
        |Microsoft Corporation  |
        |Airbus Group           |
        |PricewaterhouseCoopers |

  Scenario: Validate grid maintains the sorting order when criteria is run with Profile Type.
    When I navigate to account intel page.
    And Open the report criteria.
    And Select "Pending Profiles" as profile type in criteria.
    And Select the sort order as low to high from criteria.
    And Click on the go button.
    Then Grid should contain profiles.
      |Boston Consulting Group        |
      |Fortum Corporation             |
      |CHAP BB test                   |
      |PricewaterhouseCoopers         |
      |Airbus Group                   |
    When Select the criteria with sort high to low for rn.
    Then Grid should contain profiles.
      |Airbus Group               |
      |CHAP BB test               |
      |PricewaterhouseCoopers     |
      |Fortum Corporation         |
      |Boston Consulting Group    |

  Scenario: Validate autolink feature to verify if profiles get subprofiled under master after autolink.
    When I navigate to account intel page.
    And I Autolink profiles.
      |Profile            |Autolink_Name                            |
      |Eli Lilly & Company|PricewaterhouseCoopers,Fortum Corporation|
    Then Grid should contain profiles.
      |Airbus Group               |
      |Boston Consulting Group    |
      |CHAP BB test               |
      |Eli Lilly & Company        |
      |Inditex                    |
      |Microsoft Corporation      |
      |National Oilwell Varco     |
    Then Profiles should have subprofiles.
      |Profiles                   |Subprofiles                                          |
      |Eli Lilly & Company        |Fortum Corporation,PricewaterhouseCoopers,Eurocontrol|


  Scenario: Validate delete the name in autolink.
    Given I navigate to account intel page.
    And I Autolink profiles.
          |Profile            |Autolink_Name                            |
          |Eli Lilly & Company|PricewaterhouseCoopers,Fortum Corporation|
    When I delete first autolink of profile "Eli Lilly & Company".
    And Click on the "save" button of autolink.
    And Click on "close" button of autolink.
    Then Grid should contain profiles.
      |Airbus Group               |
      |Boston Consulting Group    |
      |CHAP BB test               |
      |Eli Lilly & Company        |
      |Inditex                    |
      |Microsoft Corporation      |
      |National Oilwell Varco     |
      |PricewaterhouseCoopers     |

  Scenario: Validate Autolink of profile which has autolink configured in it.
    Given I navigate to account intel page.
    And I Autolink profiles.
      |Profile            |Autolink_Name                            |
      |Eli Lilly & Company|PricewaterhouseCoopers,Fortum Corporation|
    When I Autolink profiles and wait for error.
      |Profile              |Autolink_Name                            |
      |Microsoft Corporation|Eli Lilly & Company,abc                  |
    Then I should get popup with message "Eli Lilly & Company is profile name of auto link configured account. So, it will not be used for auto link account name."


    Scenario: Validate delink of the profile when autolink configured profile is marked as pending.
      Given I navigate to account intel page.
      And I Autolink profiles.
        |Profile            |Autolink_Name                            |
        |Eli Lilly & Company|PricewaterhouseCoopers,Fortum Corporation|
      When I mark the profile "Eli Lilly & Company" as pending.
      Then Grid should contain profiles.
        |Airbus Group               |
        |Boston Consulting Group    |
        |CHAP BB test               |
        |Eli Lilly & Company        |
        |Fortum Corporation         |
        |Inditex                    |
        |Microsoft Corporation      |
        |National Oilwell Varco     |
        |PricewaterhouseCoopers     |

    Scenario: Validate linking of profiles marked as accepted from excluded tab.
      Given I navigate to account intel page.
      And I Autolink profiles.
        |Profile            |Autolink_Name                            |
        |Eli Lilly & Company|Kuoni Group                              |
      When I navigate to excluded tab.
      And Activate profile "Kuoni Group".
      And I navigate to account intel tab.
      Then Grid should contain profiles.
        |Airbus Group               |
        |Boston Consulting Group    |
        |CHAP BB test               |
        |Eli Lilly & Company        |
        |Fortum Corporation         |
        |Inditex                    |
        |Microsoft Corporation      |
        |National Oilwell Varco     |
        |PricewaterhouseCoopers     |


    Scenario: Validate if the autolink persist if the profile is marked as excuded and then activated again.
      Given I navigate to account intel page.
      And I Autolink profiles.
        |Profile            |Autolink_Name                            |
        |Eli Lilly & Company|PricewaterhouseCoopers,Fortum Corporation|
      When I exclude profile "Eli Lilly & Company".
      And I navigate to excluded tab.
      And Activate profile "Eli Lilly & Company".
      And I navigate to account intel tab.
      Then I should see 2 accounts autolinked to "Eli Lilly & Company".

    Scenario: Validate error popup is displayed when user links parent to new child and child to same parent
      Given I navigate to account intel page.
      When Link profile.
        |Master_Profile|Subprofile                         |
        |Boston Consulting Group  |Fortum Corporation      |
        |Fortum Corporation       |Boston Consulting Group |
      Then I should get popup with message "Invalid linking of profiles!"


    Scenario: Validate error popup is displayed when there are cyclic as well as valid profile linking present
      Given I navigate to account intel page.
      When I click on edit button on grid.
      And I link profile "Fortum Corporation" to "Boston Consulting Group".
      And I link profile "Boston Consulting Group" to "Fortum Corporation".
      And I link profile "PricewaterhouseCoopers" to "Boston Consulting Group".
      And I click on the save button of grid.
      And I click on the ok button of error message.
      Then Grid should contain profiles.
        |Airbus Group               |
        |Boston Consulting Group    |
        |CHAP BB test               |
        |Eli Lilly & Company        |
        |Fortum Corporation         |
        |Inditex                    |
        |Microsoft Corporation      |
        |National Oilwell Varco     |
        |PricewaterhouseCoopers     |


    Scenario: Validate error popup is displayed when cyclic linking is done along with profile actioning(activate)
      Given I navigate to account intel page.
      When I click on edit button on grid.
      And I link profile "Fortum Corporation" to "Boston Consulting Group".
      And I link profile "Boston Consulting Group" to "Fortum Corporation".
      And Activate profile "Boston Consulting Group" in profile management screen.
      And I click on the save button of grid.
      And I click on the ok button of error message.
      Then Grid should contain profiles.
          |Airbus Group               |
          |Boston Consulting Group    |
          |CHAP BB test               |
          |Eli Lilly & Company        |
          |Fortum Corporation         |
          |Inditex                    |
          |Microsoft Corporation      |
          |National Oilwell Varco     |
          |PricewaterhouseCoopers     |


  Scenario: Validate error popup is displayed when cyclic linking is done along with activate all operation.
    Given I navigate to account intel page.
    When I click on edit button on grid.
    And I link profile "Fortum Corporation" to "Boston Consulting Group".
    And I link profile "Boston Consulting Group" to "Fortum Corporation".
    And I click on the star action icon.
    And I click on the accept all and close popup.
    And I click on the save button of grid.
    And I click on the ok button of error message.
    Then Grid should contain profiles.
      |Airbus Group               |
      |Boston Consulting Group    |
      |CHAP BB test               |
      |Eli Lilly & Company        |
      |Fortum Corporation         |
      |Inditex                    |
      |Microsoft Corporation      |
      |National Oilwell Varco     |
      |PricewaterhouseCoopers     |






















