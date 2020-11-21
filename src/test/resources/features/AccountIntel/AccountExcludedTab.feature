@ProfileManagementExcludedTab
Feature: Account Intel Profile Management Excluded Tab Functionality.

  Background: User navigates to the prop homepage
    Given Navigate to property homepage.
    And Account Intel Data Should be present.

Scenario: Validate profile name search for master,substring,*child and no result cases
  When I navigate to account intel page and click on excluded tab.
  And I open the profile display criteria.
  And Search profile "Kuoni Group".
  Then Search result should display
      |All Profiles|
      |Kouni Group |
  When I Search profile "*Lego".
  Then Search result should display
    |All Profiles|
    |Kouni Group |
  When I Search profile "*gover".
  Then Search result should display
    |All Profiles         |
    |Norwegian Government |
  When I Search profile "asasd".
  Then Search result should display
    |No result found      |

Scenario: Validate rn filter error messages with invalid rn inputs
  When I navigate to account intel page and click on excluded tab.
  And I open the profile display criteria.
  And I enter rn from data as "-5".
  And Click on Go button.
  Then Error message "Please enter valid RN (from) number.".
  When I enter rn to data as "-5".
  And Click on Go button.
  Then Error message "Please enter valid RN (To) number.".
  When I enter rn from data as "5".
  And I enter rn to data as "1".
  And Click on Go button.
  Then Error message "To value must be greater than from value.".








