package com.ideas.chimps.bddselenium.views;

import com.ideas.chimps.bddselenium.util.UIName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProfileManagementPage extends PageBase{

    public ProfileManagementPage(EventFiringWebDriver driver) {
        super(driver);
        addWebElementMeta(this);
    }

    private String linkingDropDownPath = "//tr[td[span[text()='string']]]/td[5]/div/div/div/span";
    private String delinkingDropDownPath = "//tr[td[span[span[text()='string']]]]/td[5]/div/div/div/span/div/button/span";

    private static final String CLASS = "class";
    private static final String EXCLUDED_TAB = "//a[contains(text(),'Excluded Profiles')]";
    private static final String EDIT_ICON_IN_REPORT_GRID = ".profile-management-table .chi-edit";
    private static final String SAVE_BUTTON_IN_REPORT_GRID = ".profile-management-table .chi-save";
    private static final String CANCEL_SAVE_BUTTON_IN_REPORT_GRID = "tr .chi-close3";
    private static final String SELECT_FROM_SEARCHED_TEXT = ".sub-profile-select label";
    private static final String SUB_PROFILE_CHECK_BOX = ".sub-profiles-checkbox span";
    private static final String TABLE_HEADER_SUBPROFILE = "//table/thead/tr/th[5]";
    private static final String ACCEPT_ALL_BUTTON = ".list-action-content .btn-accept";
    private static final String CLOSE_BUTTON_STAR_ICON_POPUP = ".action-bar .chi-close3";
    private static final String INVALID_LINKING_POPUPTEXT = "#globalConfirmationBox p";
    private static final String INVALID_LINKING_OK_BUTTON = "#globalConfirmationBox button";
    private static final String MASTER_PROFILES = "//tbody/tr/td[3]/span";
    private static final String SORT_PROFILE_LIST_DROP_DOWN = ".sort-profile-select .multiselect-list";
    private static final String PROFILE_DISPLAY = ".btn-profile-search";
    private static final String SORT_PROFILE_DROP_DOWN_BUTTON = ".sort-profile-select button";
    private static final String RN_COL = "//tbody/tr/td[last()-1]/span";
    private static final String GO_BUTTON_IN_CRITERIA = ".chi-go";
    private static final String TABLE_HEADER_AUTOLINK = "//table/thead/tr/th[7]";
    private static final String PROFILE_SEARCH_BUTTON_DROP_DOWN = ".profile-name-select .multiselect-selected-text";
    private static final String SEARCH_FIELD = "//input[@placeholder='Search..']";
    private static final String SEARCH_RESULT = ".profile-name-select label";
    private static final String PROFILE_TYPE_DROP_DOWN = ".profile-type-select button";
    private static final String PROFILE_TYPE_SELECT_DROP_DOWN = ".profile-type-select .profile-type";
    private static final String PROFILE_TYPE_SELECT_SELECT_ALL_OPTION = "//a[label[input[@value='select-all-value']]]";
    private static final String COMPARABLE_SEGMENT_BUTTON = ".btn-popup-segment";
    private static final String COMPARABLE_SEGMENT_DIALOG_BOX = "common-dialog-popup-for-comparable-segment";
    private static final String COMPARABLE_SEGMENT_ROWS = "//div[@id='common-dialog-popup-for-comparable-segment']//div[contains(@class,'utilities-view active')]//span[contains(@class,'utilities__cell-head')]";
    private static final String COMPARABLE_SEGMENT_CANCEL_BUTTON = ".action-bar .chi-close3";
    private static final String COMPARABLE_SEGMENT_SAVE_BUTTON = ".action-bar .chi-save";
    private static final String COMPARABLE_SEGMENT_EDIT_BUTTON = ".action-bar .chi-edit";
    private static final String PENDING_INFORMATION_LABEL = "//div[@class='account-function']//input";
    private static final String TABLE_HEADERS = "//table/thead/tr/th";
    private static final String AUTOLINK_CHECKBOX = ".auto-link-checkbox span";
    private static final String AUTOLINK_BUTTON_IN_COLUMN = "//tr[td[span[span[text()='string']]]]/td[7]";
    private static final String AUTOLINK_POPUP_INPUT_TEXT = ".autoLinkName";
    private static final String AUTOLINK_POPUP_SAVE_BTN = ".mars-popup-titlebar .chi-save";
    private static final String AUTOLINK_POPUP_CLOSE_BTN = ".mars-popup-titlebar .chi-close3";
    private static final String AUTOLINK_POPUP_ADD_BTN = ".chi-plus2";
    private static final String SUBPROFILES_ALL = "//tr[td[span[span[text()='string']]]]/following-sibling::tr[position()<5]/td[5]/span";
    private static final String SUBPROFILE_EXPAND_ICON = "//tr[td[span[span[text()='string']]]]/td[5]/span/i[contains(@class,'chi-arrowright')]";
    private static final String AUTOLINK_ERROR_POPUPTEXT = ".modal-body p";
    private static final String AUTOLINK_ERROR_POPUP_OK_BUTTON = "//button[text()='OK']";
    private static final String AUTOLINK_POPUP_DELETE_BUTTON = ".autolink-popup-content--edit .btn-deletecell .chi-minus";
    private static final String PENDING_OR_APPROVAL_BUTTON = "//tr[td[span[span[text()='string']]]]/td[2]/div/div/div/span/i[1]";
    private static final String EXCLUDE_BUTTON = "//tr[td[span[span[text()='string']]]]/td[2]/div/div/div/span/i[2]";
    private static final String MESSAGE_IN_AUTOLINK_POPUP = "#autoLinkConfigPopupNotification strong";
    private static final String EDIT_ICON_IN_AUTOLINK_POPUP = "#common-dialog-popup-for-auto-link .chi-edit";
    private static final String COMPARABLE_SEG_CHECKBOX_PREFIX = "//div[div[span[text()='";
    private static final String WAIT_LOCATOR = "wait";

    @UIName(uiName = "EXCLUDED TAB")
    @FindBy(how = How.XPATH, using = EXCLUDED_TAB)
    private WebElement excludedProfileTab;

    @UIName(uiName = "EDIT_ICON_IN_REPORT_GRID")
    @FindBy(how = How.CSS, using = EDIT_ICON_IN_REPORT_GRID)
    private WebElement editIcon;

    @UIName(uiName = "SAVE BUTTON IN REPORT GRID")
    @FindBy(how = How.CSS, using = SAVE_BUTTON_IN_REPORT_GRID)
    private WebElement saveButton;

    @UIName(uiName = "CANCEL SAVE BUTTON IN REPORT")
    @FindBy(how = How.CSS, using = CANCEL_SAVE_BUTTON_IN_REPORT_GRID)
    private WebElement cancelSaveButton;

    @UIName(uiName = "SELECT FROM SEARCHED TEXT")
    @FindBy(how = How.CSS, using = SELECT_FROM_SEARCHED_TEXT)
    private WebElement selectFromSearchedText;

    @UIName(uiName = "SUBPROFILE CHECKBOX")
    @FindBy(how = How.CSS, using = SUB_PROFILE_CHECK_BOX)
    private WebElement subProfileCheckBox;

    @UIName(uiName = "TABLE HEADER SUBPOFILE")
    @FindBy(how = How.XPATH, using = TABLE_HEADER_SUBPROFILE)
    private WebElement tableHeaderSubprofile;

    @UIName(uiName = "REACTIVATE STAR ICON")
    private static final String REACTIVATE_STAR_ICON = "table .chi-star";
    @FindBy(how = How.CSS, using = REACTIVATE_STAR_ICON)
    private WebElement reactivateStarIcon;

    @UIName(uiName = "ACCEPT_ALL_BUTTON")
    @FindBy(how = How.CSS, using = ACCEPT_ALL_BUTTON)
    private WebElement acceptAllButton;

    @UIName(uiName = "CLOSE_BUTTON_STAR_ICON_POPUP")
    @FindBy(how = How.CSS, using = CLOSE_BUTTON_STAR_ICON_POPUP)
    private WebElement closeButtonStarIconPopup;

    @UIName(uiName = "INVALID_LINKING_POPUPTEXT")
    @FindBy(how = How.CSS, using = INVALID_LINKING_POPUPTEXT)
    private WebElement invalidLinkingPopupText;

    @UIName(uiName = "INVALID_LINKING_OK_BUTTON")
    @FindBy(how = How.CSS, using = INVALID_LINKING_OK_BUTTON)
    private WebElement invalidLinkingOkButton;

    @UIName(uiName = "MASTER_PROFILES")
    @FindBy(how = How.XPATH, using = MASTER_PROFILES)
    private List<WebElement> masterProfiles;

    @UIName(uiName = "SORT_PROFILE_LIST_DROP_DOWN")
    @FindBy(how = How.CSS, using = SORT_PROFILE_LIST_DROP_DOWN)
    private WebElement sortProfileListSelect;

    @UIName(uiName = "PROFILE_DISPLAY")
    @FindBy(how = How.CSS, using = PROFILE_DISPLAY)
    private WebElement profileDisplayButton;

    @UIName(uiName = "SORT_PROFILE_DROP_DOWN_BUTTON")
    @FindBy(how = How.CSS, using = SORT_PROFILE_DROP_DOWN_BUTTON)
    private WebElement sortProfileButton;

    @UIName(uiName = "GO_BUTTON_IN_CRITERIA")
    @FindBy(how = How.CSS, using = GO_BUTTON_IN_CRITERIA)
    private WebElement goButton;

    @UIName(uiName = "RN_COL")
    @FindBys(@FindBy(how = How.XPATH, using = RN_COL))
    private List<WebElement> rnCol;

    @UIName(uiName = "PROFILE_SEARCH_BUTTON_DROP_DOWN")
    @FindBy(how = How.CSS, using = PROFILE_SEARCH_BUTTON_DROP_DOWN)
    private WebElement profileSearchButtonDropdown;

    @UIName(uiName = "SEARCH_FIELD")
    @FindBy(how = How.XPATH, using = SEARCH_FIELD)
    private WebElement searchField;

    @UIName(uiName = "SEARCH_RESULT")
    @FindBys(@FindBy(how = How.CSS, using = SEARCH_RESULT))
    private List<WebElement> searchResults;

    @UIName(uiName = "PROFILE_TYPE_DROP_DOWN")
    @FindBy(how = How.CSS, using = PROFILE_TYPE_DROP_DOWN)
    private WebElement profileTypeButton;

    @UIName(uiName = "PROFILE_TYPE_SELECT_DROP_DOWN")
    @FindBy(how = How.CSS, using = PROFILE_TYPE_SELECT_DROP_DOWN)
    private WebElement profileTypeSelectOptions;

    @UIName(uiName = "PROFILE_TYPE_SELECT_SELECT_ALL_OPTION")
    @FindBy(how = How.XPATH, using = PROFILE_TYPE_SELECT_SELECT_ALL_OPTION)
    private WebElement profileTypeSelectAllOptions;

    @UIName(uiName = "TABLE_HEADERS")
    @FindBy(how = How.XPATH, using = TABLE_HEADERS)
    private List<WebElement> tableHeaders;

    @UIName(uiName = "COMPARABLE_SEGMENT_BUTTON")
    @FindBy(how = How.CSS, using = COMPARABLE_SEGMENT_BUTTON)
    private WebElement compSegmentButton;

    @UIName(uiName = "COMPARABLE_SEGMENT_DIALOG_BOX")
    @FindBy(how = How.ID, using = COMPARABLE_SEGMENT_DIALOG_BOX)
    private WebElement compSegmentDialogBox;

    @UIName(uiName = "COMPARABLE_SEGMENT_ROWS")
    @FindBy(how = How.XPATH, using = COMPARABLE_SEGMENT_ROWS)
    private List<WebElement> comparableSegmentRows;

    @UIName(uiName = "COMPARABLE_SEGMENT_CANCEL_BUTTON")
    @FindBy(how = How.CSS, using = COMPARABLE_SEGMENT_CANCEL_BUTTON)
    private WebElement comparableSegmentCancelSaveButton;

    @UIName(uiName = "COMPARABLE_SEGMENT_SAVE_BUTTON")
    @FindBy(how = How.CSS, using = COMPARABLE_SEGMENT_SAVE_BUTTON)
    private WebElement comparableSegmentSaveButton;

    @UIName(uiName = "COMPARABLE_SEGMENT_EDIT_BUTTON")
    @FindBy(how = How.CSS, using = COMPARABLE_SEGMENT_EDIT_BUTTON)
    private WebElement comparableSegmentEditButton;

    @UIName(uiName = "PENDING_INFORMATION_LABEL")
    @FindBy(how = How.XPATH, using = PENDING_INFORMATION_LABEL)
    private WebElement pendingInformation;

    @UIName(uiName = "AUTOLINK_CHECKBOX")
    @FindBy(how = How.CSS, using = AUTOLINK_CHECKBOX)
    private WebElement autoLinkCheckbox;

    @UIName(uiName = "AUTOLINK_POPUP_INPUT_TEXT")
    @FindBy(how = How.CSS, using = AUTOLINK_POPUP_INPUT_TEXT)
    private WebElement autolinkPopupInputText;

    @UIName(uiName = "AUTOLINK_POPUP_SAVE_BTN")
    @FindBy(how = How.CSS, using = AUTOLINK_POPUP_SAVE_BTN)
    private WebElement autolinkPopupSaveButton;

    @UIName(uiName = "AUTOLINK_POPUP_CLOSE_BTN")
    @FindBy(how = How.CSS, using = AUTOLINK_POPUP_CLOSE_BTN)
    private WebElement autolinkCloseButton;

    @UIName(uiName = "AUTOLINK_POPUP_ADD_BTN")
    @FindBy(how = How.CSS, using = AUTOLINK_POPUP_ADD_BTN)
    private WebElement autolinkPopupAddButton;

    @UIName(uiName = "TABLE_HEADER_AUTOLINK")
    @FindBy(how = How.XPATH, using = TABLE_HEADER_AUTOLINK)
    private WebElement tableHeaderAutolink;

    @UIName(uiName = "AUTOLINK_ERROR_POPUPTEXT")
    @FindBy(how = How.CSS, using = AUTOLINK_ERROR_POPUPTEXT)
    private WebElement autolinkErrorTextPopup;

    @UIName(uiName = "AUTOLINK_ERROR_POPUP_OK_BUTTON")
    @FindBy(how = How.XPATH, using = AUTOLINK_ERROR_POPUP_OK_BUTTON)
    private WebElement autolinkErrorOkButton;

    @UIName(uiName = "AUTOLINK_POPUP_DELETE_BUTTON")
    @FindBy(how = How.CSS, using = AUTOLINK_POPUP_DELETE_BUTTON)
    private WebElement autolinkDeleteButton;

    @UIName(uiName = "MESSAGE_IN_AUTOLINK_POPUP")
    @FindBy(how = How.CSS, using = MESSAGE_IN_AUTOLINK_POPUP)
    private WebElement messageInAutolinkPopup;

    @UIName(uiName = "EDIT_ICON_IN_AUTOLINK_POPUP")
    @FindBy(how = How.CSS, using = EDIT_ICON_IN_AUTOLINK_POPUP)
    private WebElement autolinkEditIcon;

    @UIName(uiName = "WAIT_LOCATOR")
    @FindBy(how = How.ID, using = WAIT_LOCATOR)
    private WebElement waitLocator;


    public void profileTypeSelectOnly(String byVisibleText) {
        profileTypeButton.click();
        profileTypeSelectAllOptions.click();
        selectByVisibleTextInDropdown(profileTypeSelectOptions, byVisibleText);
    }

    public void clickProfileSearchButtonDropDown() {
        profileSearchButtonDropdown.click();
    }

    public void searchProfileAndSelect(String profileToSearch) {
        profileSearchButtonDropdown.click();
        searchField.clear();
        searchField.sendKeys(profileToSearch);
        String path = "//label[@title=\"string\"]";
        driver.findElement(By.xpath(getDynamicXpath(path, profileToSearch))).click();
        profileSearchButtonDropdown.click();
    }

    public void clickGoButton() {
        goButton.click();
    }

    public void selectSortProfile(String sortType) {
        sortProfileButton.click();
        selectByVisibleTextInDropdown(sortProfileListSelect, sortType);
    }

    public void openProfileDisplayPopup() {
        profileDisplayButton.click();
    }

    public List<String> allMasterProfiles() {
        waitForElementToDisappear(By.id("wait"));
        return masterProfiles.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getInvalidLinkingProfileText() {
        waitForElementToAppear(invalidLinkingPopupText);
        return invalidLinkingPopupText.getText();
    }

    public void clickOk() {
        invalidLinkingOkButton.click();
    }

    public void checkSubProfileCheckBox() {
        if (!"Sub - Profiles".equalsIgnoreCase(tableHeaderSubprofile.getText().trim())) {
            subProfileCheckBox.click();
            waitForElementToDisappear(By.id("wait"));
        }
    }

    public void uncheckSubProfileCheckBox() {
        if ("Sub - Profiles".equalsIgnoreCase(tableHeaderSubprofile.getText().trim())) {
            subProfileCheckBox.click();
            waitForElementToDisappear(By.id("wait"));
        }
    }

    public void clickEditIcon() {
        waitForElementToDisappear(By.id("wait"));
        editIcon.click();
    }

    public void clickCancelSaveButton() {
        cancelSaveButton.click();
    }

    public void clickSave() {
        saveButton.click();
        waitForElementToDisappear(By.id("wait"));
    }

    public void excludeAccount(String profile) {
        String path = "//tr[td[span[span[text()=\"string\"]]]]/td[2]/div/div/div/span/i[contains(@class,'chi-exclude')]";
        driver.findElement(By.xpath(getDynamicXpath(path, profile))).click();
    }

    /*public ExcludedProfilesPage navigateToExcludedTab() {
        excludedProfileTab.click();
        waitForElementToDisappear(WAIT_LOCATOR);
        return new ExcludedProfilesPage(driver);
    }*/

    public boolean isProfilePending(String profileName) {
        String path = "//tr[td[span[span[text()=\"string\"]]]]/td[2]/div/div/div/span/a/i";
        return driver.findElement(By.xpath(getDynamicXpath(path, profileName))).getAttribute(CLASS).contains("chi-pending");
    }

    public boolean isProfileAccepted(String profileName) {
        String path = "//tr[td[span[span[text()=\"string\"]]]]/td[2]/div/div/div/span/a/i";
        return driver.findElement(By.xpath(getDynamicXpath(path, profileName))).getAttribute(CLASS).contains("chi-approval");
    }

    public boolean isContractedProfile(String profileName) {
        String path = "//tr[td[span[span[text()=\"string\"]]]]/td[last()]/div/i";
        return driver.findElement(By.xpath(getDynamicXpath(path, profileName))).getAttribute(CLASS).contains("chi-tic");
    }

    public void activateAccount(String profile) {
        String path = "//tr[td[span[text()=\"string\"]]]/td[2]/div/div/div/span/i[@class='chi-checkmark icon-medium']";
        driver.findElement(By.xpath(getDynamicXpath(path, profile))).click();
    }

    public void clickAcceptAll() {
        acceptAllButton.click();
    }

    public void closeButtonStarAction() {
        closeButtonStarIconPopup.click();
    }

    public void clickStarReactivateIcon() {
        reactivateStarIcon.click();
    }

    public void linkProfile(String parent, String child) {
        clickLinkProfileDropDown(parent);
        searchAndSelect(parent, child);
        clickLinkProfileDropDown(parent);
    }

    public void delinkProfile(String parent) {
        clickDeLinkProfileDropDown(parent);
        deselectProfile();
        clickDeLinkProfileDropDown(parent);
    }

    public void deselectProfile() {
        selectFromSearchedText.click();
    }

    public void searchAndSelect(String parent, String child) {
        String path = getDynamicXpath(linkingDropDownPath, parent);
        path += "/div/ul/li/div/input";
        driver.findElement(By.xpath(path)).sendKeys(child);
        selectFromSearchedText.click();
    }

    public void clickLinkProfileDropDown(String parent) {
        String path = getDynamicXpath(linkingDropDownPath, parent);
        WebElement dropDownButton = driver.findElement(By.xpath(path));
        waitForElementToDisappear(By.id("wait"));
        dropDownButton.click();
    }

    public void clickDeLinkProfileDropDown(String parent) {
        String path = getDynamicXpath(delinkingDropDownPath, parent);
        WebElement dropDownButton = driver.findElement(By.xpath(path));
        waitForElementToDisappear(By.id("wait"));
        dropDownButton.click();
    }


    public void openComparableSegmentPopUp() {
        pendingInformation.click();
        waitForElementToBeClickable(compSegmentButton);
        compSegmentButton.click();
        waitForElementToAppear(compSegmentDialogBox);
    }

    public List<String> getComparableMarketSegments() {
        waitForElementToAppear(compSegmentDialogBox);
        List<String> comparableMarketSegments = new ArrayList<>();
        if (!comparableSegmentRows.isEmpty()) {
            for (WebElement comparableSegmentRow : comparableSegmentRows) {
                comparableMarketSegments.add(comparableSegmentRow.getText());
            }
        }
        return comparableMarketSegments;
    }

    public void setComparableMarketSegments(String comparableMarketSegment) {
        waitForElementToAppear(compSegmentDialogBox);
        String comparableSegCheckbox = COMPARABLE_SEG_CHECKBOX_PREFIX + comparableMarketSegment.trim() + "']]]/div[2]/div/label/span";
        WebElement comparableSegmentCheckBox = driver.findElement(By.xpath(comparableSegCheckbox));
        waitForElementToAppear(comparableSegmentCheckBox);
        comparableSegmentCheckBox.click();
    }

    public boolean isComparableMarketSegmentsTicked(String comparableMarketSegment, String status) {
        waitForElementToAppear(compSegmentDialogBox);
        String comparableSegCheckbox;
        if ("ticked".equalsIgnoreCase(status)) {
            comparableSegCheckbox = COMPARABLE_SEG_CHECKBOX_PREFIX + comparableMarketSegment.trim() + "']]]/div[2]/div/label/span";
        } else {
            comparableSegCheckbox = COMPARABLE_SEG_CHECKBOX_PREFIX + comparableMarketSegment.trim() + "']]]/div[2]/div/label";
        }
        List<WebElement> comparableSegmentsTicked = driver.findElements(By.xpath(comparableSegCheckbox));
        return !(comparableSegmentsTicked.isEmpty());
    }

    public void clickComparableSegmentSaveButton() {
        comparableSegmentSaveButton.click();
    }

    public void clickComparableSegmentCancelButton() {
        comparableSegmentCancelSaveButton.click();
    }

    public void clickComparableSegmentEditButton() {
        comparableSegmentEditButton.click();
    }

    public void clickAutolinkErrorOkButton() {
        autolinkErrorOkButton.click();
    }

    public boolean isAutolinkErrorOkButtonPresent(){
        try{
            return autolinkErrorOkButton.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void clickDeleteButtonInAutolink() {
        autolinkDeleteButton.click();
        pauseTest(1000); //TODO put loaders on Ui so that we can check for disappearance of loader instead of explicit pause.
    }

    public void clickautolinkSaveButton() {
        autolinkPopupSaveButton.click();
        pauseTest(1000);
    }

    public void clickautolinkCloseButton() {
        autolinkCloseButton.click();
        waitForElementToDisappear(By.id("wait"));
    }

    public void openAutolinkPopupFor(String profileName) {
        waitForElementToAppear(By.xpath(getDynamicXpath(AUTOLINK_BUTTON_IN_COLUMN, profileName)));
        driver.findElement(By.xpath(getDynamicXpath(AUTOLINK_BUTTON_IN_COLUMN, profileName))).click();
    }

    public void autoLinkPopupInputText(String text) {
        autolinkPopupInputText.sendKeys(text);
    }

    public void autolinkProfiles(String profileName, List<String> profiles) {
        checkAutolinkCheckBox();
        openAutolinkPopupFor(profileName);
        int noOfProfiles = profiles.size();
        for (int i = 0; i < noOfProfiles; i++) {
            List<WebElement> allTextBoxes = driver.findElements(By.cssSelector(AUTOLINK_POPUP_INPUT_TEXT));
            allTextBoxes.get(i).clear();
            allTextBoxes.get(i).sendKeys(profiles.get(i));
            if (allTextBoxes.size() < noOfProfiles) {
                autolinkPopupAddButton.click();
            }
        }
    }

    public void addIconAutolinkProfile() {
        autolinkPopupAddButton.click();
    }

    public void autolinkProfilesAfterPopupisOpened(String profileName) {
        autolinkPopupInputText.sendKeys(profileName);
    }

    public void checkAutolinkCheckBox() {

        List<String> tableHeadersText = tableHeaders.stream().map(WebElement::getText).collect(Collectors.toList());
        if (!tableHeadersText.contains("Auto Link")) {
            autoLinkCheckbox.click();
            waitForElementToDisappear(By.id("wait"));
        }
    }

    @Override
    public void refreshPage() {
        driver.navigate().refresh();
        waitForElementToDisappear(By.id("wait"));
        waitForElementToAppear(By.className("profile-management-table"));
    }

    public List<String> getAllSubProfilesLinkedToMasterProfile(String profile) {
        driver.findElement(By.xpath(getDynamicXpath(SUBPROFILE_EXPAND_ICON, profile))).click();
        pauseTest(1000);
        return driver.findElements(By.xpath(getDynamicXpath(SUBPROFILES_ALL, profile))).stream().map(WebElement::getText).collect(Collectors.toList());
    }


    public String getErrorTextFromPopupForAutolink() {
        waitForElementToAppear(autolinkErrorOkButton);
        waitForElementToAppear(autolinkErrorTextPopup);
        return autolinkErrorTextPopup.getText().trim();
    }

    public ExcludedProfilesPage navigateToExcludedTab() {
        excludedProfileTab.click();
   //     waitForElementToDisappear(WAIT_LOCATOR);
        return new ExcludedProfilesPage(driver);
    }

    public void markPendingOrAccepted(String profileName) {
        driver.findElement(By.xpath(getDynamicXpath(PENDING_OR_APPROVAL_BUTTON, profileName))).click();
    }

    public void markExcluded(String profileName) {
        driver.findElement(By.xpath(getDynamicXpath(EXCLUDE_BUTTON, profileName))).click();
    }

    public int getNumberOfAccountsInAutolinkConfig() {
        return driver.findElements(By.cssSelector(".autoLinkName ")).size();
    }

    public String getMessageInAutolinkPopup() {
        return messageInAutolinkPopup.getText().trim();
    }

    public void clickAutolinkEditIcon() {
        autolinkEditIcon.click();
    }

}
