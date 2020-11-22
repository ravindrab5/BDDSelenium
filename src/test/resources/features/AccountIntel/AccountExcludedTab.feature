
Feature: Account Intel Profile Management Excluded Tab Functionality.

  Background: User navigates to the prop homepage
    Given Navigate to property homepage.
    And Account Intel Data Should be present.

  @ProfileManagementExcludedTab
Scenario: Validate profile name search for master,substring,*child and no result cases
  When I navigate to account intel page and click on excluded tab.
  And I open the profile display criteria.
  And Search profile "Kuoni Group" in profile search.
  Then Search result should display
      |All Profiles|
      |Kuoni Group |
  When I open the profile display criteria.
  And Search profile "*Lego" in profile search.
  Then Search result should display
    |All Profiles|
    |Kuoni Group |
  When I open the profile display criteria.
  And Search profile "*gover" in profile search.
  Then Search result should display
    |All Profiles|
    |Norwegian Government |
  When I open the profile display criteria.
  And Search profile "asasd" in profile search.
  Then Search result should display
    |No result found      |

  @ProfileManagementExcludedTab
Scenario: Validate rn filter error messages with invalid rn inputs
  When I navigate to account intel page and click on excluded tab.
  And I open the profile display criteria.
  And I enter rn from data as "-5".
  And Click on Go button.
  Then Error message "Please enter valid RN (from) number.".
  When I open the profile display criteria.
  And I enter rn to data as "-5".
  And Click on Go button.
  Then Error message "Please enter valid RN (To) number.".
  When I open the profile display criteria.
  And I enter rn from data as "5".
  And I enter rn to data as "1".
  And Click on Go button.
  Then Error message "To value must be greater than from value.".

  @ProfileManagementExcludedTab
Scenario: Validate grid data creation based on the rn filter applied.
  When I navigate to account intel page and click on excluded tab.
  And I open the profile display criteria.
  And I enter rn from data as "2".
  And I enter rn to data as "5".
  And Click on Go button.
  Then Grid should contain data.
    |New accenture        |
    |Norges Fotballforbund|
    |Norwegian Government |
  When I open the profile display criteria.
  And I enter rn from data as "2".
  And Click on Go button.
  Then Grid should contain data.
    |New accenture        |
    |Norges Fotballforbund|
    |Norwegian Government |

  @ProfileManagementExcludedTab
Scenario: Validate grid data creation when profile is selected from profile name and filter is applied
  When I navigate to account intel page and click on excluded tab.
  And I open the profile display criteria.
  And Search profile "Kuoni Group" in profile search and select.
  And Click on Go button.
  Then Grid should contain data.
    |Kuoni Group        |
  @ProfileManagementExcludedTab
Scenario: Check single and multiple activate of the profile and check in the activate list
  When I navigate to account intel page and click on excluded tab.
  And I Click on the edit icon
  And I activate a account "Kuoni Group".
  And I activate a account "Norwegian Government".
  And I click on the save icon.
  Then Grid should contain data.
    |New accenture        |
    |Norges Fotballforbund|
  When I navigate to profile management tab.
  Then Profile "Kuoni Group" should be in activated state.
  And Profile "Norwegian Government" should be in activated state.

Scenario: Validate edit -> activate profile which was marked as exclude from pending state.
  When I navigate to account intel profile management tab.
  And I click on edit icon in profile management tab.
  And I exclude a account "Airbus Group".
  And I click on save icon in profile management tab.
  And I click on excluded tab.
  Then Grid should contain data.
    |Airbus Group        |
    |Kuoni Group         |
    |New accenture       |
    |Norges Fotballforbund |
    |Norwegian Government  |
  When I Click on the edit icon
  And I activate a account "Airbus Group".
  And I click on the save icon.
  Then Grid should contain data.
    |Kuoni Group         |
    |New accenture       |
    |Norges Fotballforbund |
    |Norwegian Government  |
  When I navigate to profile management tab.
  Then Profile "Airbus Group" should be in activated state.

Scenario:  Validate edit -> activate profile which was contracted as true previously in active tab.
  When I navigate to account intel profile management tab.
  And I click on edit icon in profile management tab.
  And I exclude a account "Eli Lilly & Company".
  And I click on save icon in profile management tab.
  When I click on excluded tab.
  Then Grid should contain data.
    |Eli Lilly & Company    |
    |Kuoni Group            |
    |New accenture          |
    |Norges Fotballforbund  |
    |Norwegian Government   |
  When I Click on the edit icon
  And I activate a account "Eli Lilly & Company".
  And I click on the save icon.
  Then Grid should contain data.
    |Kuoni Group           |
    |New accenture         |
    |Norges Fotballforbund |
    |Norwegian Government  |
  When I navigate to profile management tab.
  Then Profile "Eli Lilly & Company" should be in activated state.
  And Profile "Eli Lilly & Company" should be in contracted state.

Scenario: Validate edit -> activate a profile and close the edit view.
  When I navigate to account intel page and click on excluded tab.
  And I Click on the edit icon
  And I activate a account "Kuoni Group".
  And I activate a account "Norwegian Government".
  And I click on the save icon.
  Then Grid should contain data.
    |Kuoni Group           |
    |New accenture         |
    |Norges Fotballforbund |
    |Norwegian Government  |

Scenario: Validate if profile display popup button is disabled when user is in edit mode.
  When I navigate to account intel page and click on excluded tab.
  And I Click on the edit icon
  Then Profile display criteria should be in disabled state.

Scenario: Validate edit -> activate profile for profiles selected by profile filter.
  When I navigate to account intel page and click on excluded tab.
  And I open the profile display criteria.
  And Search profile "Kuoni Group".
  And Select the searched profile "Kuoni Group".
  And Click on Go button.
  And I Click on the edit icon
  And I activate a account "Kuoni Group".
  And I click on the save icon.
  Then Grid should contain data.
    |           |

 Scenario: Validate reset button is disabled when user clicks on the edit icon and no changes are made after edit.
   When I navigate to account intel page and click on excluded tab.
   And I Click on the edit icon
   And I Click on the Star Reactivate Icon.
   Then Reset button should be is "disabled" state.
   When I click on the Accept All.
   Then Reset button should be is "enabled" state.

Scenario: Validate reset functionality when user manually marks activate and click on star icon and clicks on reset button.
  When I navigate to account intel page and click on excluded tab.
  And I Click on the edit icon
  And I activate a account "Kuoni Group".
  And I activate a account "Norwegian Government".
  And I click on the save icon.
  And I Click on the edit icon
  And I Click on the Star Reactivate Icon.
  And I Click on the reset button and close.
  When I click on the cancel icon.
  Then Profile "Kuoni Group" should be in excluded state.
  And Profile "Norwegian Government" should be in excluded state.

Scenario: Validate activate all operation for contracted profiles which were marked as  excluded earlier.
  When I navigate to account intel profile management tab.
  And I mark an account "Eli Lilly & Company" excluded.
  And I click on excluded tab.
  Then Grid should contain data.
  |Eli Lilly & Company|
  |Kuoni Group        |
  |New accenture      |
  |Norges Fotballforbund |
  |Norwegian Government  |
  When I activate all from start reactivate feature.
  And I navigate to profile management tab.
  Then Profile "Eli Lilly & Company" should be in pending state.

Scenario: Validate the grid data is sorted low to high
  When I navigate to account intel page and click on excluded tab.
  And I open the profile display criteria.
  And I select sorting order as low to high.
  And Click on Go button.
  Then Grid should contain data.
    |Kuoni Group        |
    |New accenture      |
    |Norwegian Government  |
    |Norges Fotballforbund |
  When I open the profile display criteria.
  And I open the profile display criteria.
  And I select sorting order as high to low.
  And Click on Go button.
  Then Grid should contain data.
    |Norwegian Government  |
    |Norges Fotballforbund |
    |New accenture      |
    |Kuoni Group        |

Scenario: Validate the grid data is sorted low to high
  When I navigate to account intel page and click on excluded tab.
  And I open the profile display criteria.
  And I search and select profile.
      |Kuoni Group           |
      |New accenture         |
      |Norges Fotballforbund |
  And I select sorting order as low to high.
  And Click on Go button.
  Then Grid should contain data.
    |Kuoni Group        |
    |New accenture      |
    |Norges Fotballforbund |
  And I open the profile display criteria.
  And I select sorting order as high to low.
  And Click on the go button.
  Then Grid should contain data.
    |Norges Fotballforbund |
    |New accenture      |
    |Kuoni Group        |

