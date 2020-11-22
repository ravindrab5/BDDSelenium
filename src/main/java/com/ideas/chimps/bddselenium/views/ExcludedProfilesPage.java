package com.ideas.chimps.bddselenium.views;

import com.ideas.chimps.bddselenium.util.UIName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ExcludedProfilesPage extends PageBase{

    public ExcludedProfilesPage(EventFiringWebDriver driver) {
        super(driver);
        addWebElementMeta(this);
    }

    private static final String GRID_HEADER ="//th[contains(@class,'is-fixed-left')]";
    private static final String EXCLUDED_COUNT =".excluded-value";
    private static final String BTN_PROFILE_SEARCH =".btn-profile-search";
    private static final String SUB_PROFILE_LABEL ="//div[@class='sub-profiles-checkbox checkoption ']/small";
    private static final String SUB_PROFILE_CHECKBOX =".sub-profiles-checkbox span";
    private static final String PROFILE_SEARCH_BUTTON_DROP_DOWN =".profile-name-select .multiselect-selected-text";
    private static final String SEARCH_FIELD ="//input[@placeholder='Search..']";
    private static final String SEARCH_RESULT =".profile-name-select label";
    private static final String RN_FROM ="rnFrom";
    private static final String RN_TO ="rnTo";
    private static final String GO_BUTTON =".chi-go";
    private static final String ERROR_TEXT =".errorAlertPosition strong";
    private static final String MASTER_PROFILES ="//tbody/tr/td[3]/span";
    private static final String SAVE_BUTTON =".chi-save";
    private static final String EDIT_ICON = ".chi-edit";
    private static final String CANCEL_SAVE_BUTTON = "tr .chi-close3";
    private static final String PROFILE_MANAGEMENT_TAB = "Profile Management";
    private static final String NO_DATA_POPUP = "//div[@id='globalConfirmationBox']/div/div/div/p";
    private static final String ACCEPT_ALL_BUTTON =".dialog-popup-for-excluded-profiles-tab .btn-accept";
    private static final String OK_NO_DATA_POPUP ="//button[text()='OK']";
    private static final String REACTIVE_STAR_ICON ="table .chi-star";
    private static final String CLOSE_BUTTON_STAR_ICON_POPUP =".dialog-popup-for-excluded-profiles-tab .chi-close3";
    private static final String BTN_RESET = ".dialog-popup-for-excluded-profiles-tab .btn-reset";
    private static final String SORT_PROFILE_DROP_DOWN_BUTTON = ".sort-profile-select button";
    private static final String SORT_PROFILE_LIST_DROP_DOWN =".sort-profile-select .multiselect-list";
    private static final String TABLE_HEADER_SUB_PROFILE = "//table/thead/tr/th[5]";
    private static final String SUB_PROFILE_STRING = "Sub - Profiles";
    private static final String WAIT_ID = "wait";
    private static final String CLASS="class";

    @UIName(uiName = "GRID_HEADER")
    @FindBys(@FindBy(how = How.XPATH,using = GRID_HEADER))
    private List<WebElement> gridHeader;

    @UIName(uiName = "EXCLUDED_COUNT")
    @FindBy(how = How.CSS,using = EXCLUDED_COUNT)
    private WebElement excludedCount;

    @UIName(uiName = "BTN_PROFILE_SEARCH")
    @FindBy(how=How.CSS,using = BTN_PROFILE_SEARCH)
    private WebElement profileDisplay;

    @UIName(uiName = "SUB_PROFILE_LABEL")
    @FindBy(how=How.XPATH,using = SUB_PROFILE_LABEL)
    private WebElement subProfileLabel;

    @UIName(uiName = "SUB_PROFILE_LABEL")
    @FindBy(how=How.CSS, using=SUB_PROFILE_CHECKBOX)
    private WebElement subProfileCheckbox;

    @UIName(uiName = "PROFILE_SEARCH_BUTTON_DROP_DOWN")
    @FindBy(how=How.CSS,using = PROFILE_SEARCH_BUTTON_DROP_DOWN)
    private WebElement profileSearchButtonDropdown;

    @UIName(uiName = "SEARCH_FIELD")
    @FindBy(how=How.XPATH,using = SEARCH_FIELD)
    private WebElement searchField;

    @UIName(uiName = "SEARCH_RESULT")
    @FindBys(@FindBy(how=How.CSS,using = SEARCH_RESULT))
    private List<WebElement> searchResults;

    @UIName(uiName = "RN_FROM")
    @FindBy(how=How.ID,using = RN_FROM)
    private WebElement rnFromField;

    @UIName(uiName = "RN_TO")
    @FindBy(how=How.ID,using = RN_TO)
    private WebElement rnToField;

    @UIName(uiName = "GO_BUTTON")
    @FindBy(how = How.CSS,using = GO_BUTTON)
    private WebElement goButton;

    @UIName(uiName = "ERROR_TEXT")
    @FindBy(how = How.CSS,using = ERROR_TEXT)
    private WebElement errorText;

    @UIName(uiName = "MASTER_PROFILES")
    @FindBys(@FindBy(how=How.XPATH,using=MASTER_PROFILES))
    private List<WebElement> masterProfiles;

    @UIName(uiName = "EDIT_ICON")
    @FindBy(how=How.CSS,using = EDIT_ICON)
    private WebElement editIcon;

    @UIName(uiName = "SAVE_BUTTON")
    @FindBy(how=How.CSS,using = SAVE_BUTTON)
    private WebElement saveButton;

    @UIName(uiName = "CANCEL_SAVE_BUTTON")
    @FindBy(how=How.CSS,using = CANCEL_SAVE_BUTTON)
    private WebElement cancelSaveButton;

    @UIName(uiName = "PROFILE_MANAGEMENT_TAB")
    @FindBy(how=How.LINK_TEXT,using = PROFILE_MANAGEMENT_TAB)
    private WebElement profileManagementTab;

    @UIName(uiName = "NO_DATA_POPUP")
    @FindBy(how=How.XPATH,using=NO_DATA_POPUP)
    private WebElement noDataPopup;

    @UIName(uiName = "OK_NO_DATA_POPUP")
    @FindBy(how=How.XPATH,using = OK_NO_DATA_POPUP)
    private WebElement okNoDataPopup;

    @UIName(uiName = "REACTIVE_STAR_ICON")
    @FindBy(how=How.CSS,using = REACTIVE_STAR_ICON)
    private WebElement reactivateStarIcon;

    @UIName(uiName = "ACCEPT_ALL_BUTTON")
    @FindBy(how=How.CSS,using=ACCEPT_ALL_BUTTON)
    private WebElement acceptAllButton;

    @UIName(uiName = "CLOSE_BUTTON_STAR_ICON_POPUP")
    @FindBy(how=How.CSS,using = CLOSE_BUTTON_STAR_ICON_POPUP)
    private WebElement closeButtonStarIconPopup;

    @UIName(uiName = "BTN_RESET")
    @FindBy(how=How.CSS,using = BTN_RESET)
    private WebElement btnReset;

    @UIName(uiName = "SORT_PROFILE_DROP_DOWN_BUTTON")
    @FindBy(how = How.CSS,using=SORT_PROFILE_DROP_DOWN_BUTTON)
    private WebElement sortProfileButton;

    @UIName(uiName = "SORT_PROFILE_LIST_DROP_DOWN")
    @FindBy(how=How.CSS,using = SORT_PROFILE_LIST_DROP_DOWN)
    private WebElement sortProfileListSelect;

    @UIName(uiName = "TABLE_HEADER_SUB_PROFILE")
    @FindBy(how=How.XPATH,using = TABLE_HEADER_SUB_PROFILE)
    private WebElement tableHeaderSubProfile;

    public void toggleSubProfileCheckBox(){
        waitForElementToDisappear(By.id(WAIT_ID));
        if(!tableHeaderSubProfile.getText().equals(SUB_PROFILE_STRING)) {
            subProfileCheckbox.click();
            waitForElementToDisappear(By.id(WAIT_ID));
            if(!tableHeaderSubProfile.getText().equals(SUB_PROFILE_STRING)){
                subProfileCheckbox.click();
            }
        }
    }



    public void selectSortProfile(String sortType){
        sortProfileButton.click();
        selectByVisibleTextInDropdown(sortProfileListSelect,sortType);
    }

    public void clickSubProfileCheckbox(){
        subProfileCheckbox.click();
    }

    public void clickResetButton(){
        btnReset.click();
    }

    public void clickStarReactivateIcon(){
        reactivateStarIcon.click();
    }

    public boolean isResetButtonEnabled(){

        return !btnReset.getAttribute(CLASS).contains("disabled");
    }

    public void clickAcceptAll(){
        acceptAllButton.click();
    }

    public void closeButtonStarAction(){
        closeButtonStarIconPopup.click();
    }


    public void openReactivateStarIcon(){
        reactivateStarIcon.click();
    }

    public ProfileManagementPage clickOnTabProfileManagement(){
        profileManagementTab.click();
        waitForElementToDisappear(By.id(WAIT_ID));
        return new ProfileManagementPage(driver);
    }

    public void clickEditIcon(){
        waitForElementToDisappear(By.id(WAIT_ID));
        editIcon.click();
    }

    public void clickCancelSaveButton(){
        cancelSaveButton.click();
    }

    public void clickSave(){
        saveButton.click();
    }

    public void activateAccount(String profile){
        String path="//tr[td[span[span[text()=\"string\"]]]]/td[2]/div/div/div/span/i";
        driver.findElement(By.xpath(getDynamicXpath(path,profile))).click();
    }


    public List<String> allMasterProfiles(){
        waitForElementToDisappear(By.id("wait"));
        return masterProfiles.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getErrorText(){
        return errorText.getText();
    }

    public void clickGoButton(){
        goButton.click();
    }

    public void enterRnToField(String rnTo){
        rnToField.clear();
        rnToField.sendKeys(rnTo);
    }

    public void enterRnFromData(String rnFrom){
        rnFromField.clear();
        rnFromField.sendKeys(rnFrom);
    }

    public List<String> searchProfileAndGetResult(String profileToSearch){
        profileSearchButtonDropdown.click();
        searchField.sendKeys(profileToSearch);
        return searchResults.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getSearchResults(){
        return searchResults.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void searchProfileAndSelect(String profileToSearch){
        profileSearchButtonDropdown.click();
        searchField.clear();
        searchField.sendKeys(profileToSearch);
        String path="//label[@title=\"string\"]";
        driver.findElement(By.xpath(getDynamicXpath(path,profileToSearch))).click();
        profileSearchButtonDropdown.click();
    }

    public void clickProfileDisplay(){
        waitForElementToBeClickable(profileDisplay);
        profileDisplay.click();
    }

    public String getSubProfileLabel(){
        return subProfileLabel.getText();
    }

    public List<String> getGridHeaderText(){
        return gridHeader.stream().filter(data->data.getText().length()>0).map(WebElement::getText).collect(Collectors.toList());
    }

    public String getExcludedCount(){
        return excludedCount.getAttribute("value");
    }

    public String getProfileDisplayText(){
        return profileDisplay.getText();
    }

    public boolean isProfileDisplayEnabled(){
        return profileDisplay.isEnabled();
    }

    public boolean isProfileExcluded(String profileName){
        String path="//tr[td[span[span[text()=\"string\"]]]]/td[2]/div/div/div/span/a/i";
        return driver.findElement(By.xpath(getDynamicXpath(path,profileName))).getAttribute(CLASS).contains("chi-import-status-red");
    }

    public boolean isProfileApproved(String profileName){
        String path="//tr[td[span[span[text()=\"string\"]]]]/td[2]/div/div/div/span/i";
        return driver.findElement(By.xpath(getDynamicXpath(path,profileName))).getAttribute(CLASS).contains("chi-approval");
    }

}
