package com.ideas.chimps.bddselenium.views;

import com.ideas.chimps.bddselenium.util.UIName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PageBase {


    public EventFiringWebDriver getDriver() {
        return driver;
    }

    protected EventFiringWebDriver driver;

    public static Map<String, String> uiName=new HashMap<String, String>();

    private WebDriverWait wait;
    private Actions actions;
    private static final int TIMEOUT = 50;
    private static final int POLLING = 200;

    public PageBase(EventFiringWebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    public LoginPage logout() throws MalformedURLException {
        driver.findElement(By.cssSelector(".icon.ion-power")).click();
        return new LoginPage(driver);
    }


    protected void addWebElementMeta(PageBase p)  {
        Field[] field = p.getClass().getDeclaredFields();
        for (Field fld : field) {
            UIName wem = fld.getAnnotation(UIName.class);
            FindBy fb = fld.getAnnotation(FindBy.class);

            if(fb!=null && wem!=null) {
                uiName.put(getLocator(fb), wem.uiName());
            }

        }
    }

    protected String getLocator(FindBy fb) {
        String str = null;
        if (fb.css().length() > 0) {
            str = fb.css();
        } else if (fb.id().length() > 0) {
            str = fb.id();
        } else if (fb.className().length() > 0) {
            str = fb.className();
        } else if (fb.linkText().length() > 0) {
            str = fb.linkText();
        } else if (fb.partialLinkText().length() > 0) {
            str = fb.partialLinkText();
        } else if (fb.xpath().length() > 0) {
            str = fb.xpath();
        }

        if (str == null) {
        //    System.out.println("Str null detected ");
        }
        return str;

    }

    /*protected void addWebElementMetaIntoMap(String locator,String uiName) {
        this.uiName.put(locator, uiName);

    }*/

    protected void refreshPage(){
        driver.navigate().refresh();
    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToAppear(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForAllElementsToAppear(List<WebElement> webElements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    protected void waitForElementToAppear(String xPath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    protected void waitForTextToBePresentInElement(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    protected void waitForAllElementsToAppear(String xPath) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xPath)));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(String xPath) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
    }

    protected void waitForAllElementToDisappear(List<WebElement> webElementList) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(webElementList));
    }

    protected void waitForElementToDisappear(WebElement webElement) {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    protected void numberOfElementsToBeMoreThan(String xPath, int num) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPath), num));
    }

    protected void moveToElement(WebElement webElement){
        actions.moveToElement(webElement);
    }

    protected void moveToElementAndClick(WebElement webElement){
        actions.moveToElement(webElement).click().perform();
    }

    protected void moveToElementAndClick(WebElement menuOption1, WebElement menuOption2){
        actions.moveToElement(menuOption1).moveToElement(menuOption2).click().build().perform();
    }

    protected void moveToElementAndClick(WebElement menuOption1, WebElement menuOption2, WebElement menuOption3){
        actions.moveToElement(menuOption1).moveToElement(menuOption2).moveToElement(menuOption3).click().build().perform();
    }

    protected void selectByVisibleTextInDropdown(WebElement webElement, String visibleText){
        new Select(webElement).selectByVisibleText(visibleText);
    }

    protected void selectByValueInDropdown(WebElement webElement, String value){
        new Select(webElement).selectByValue(value);
    }

    protected void selectByIndexInDropdown(WebElement webElement, int index){
        new Select(webElement).selectByIndex(index);
    }

    protected WebElement getFirstSelectedOptionInDropdown(WebElement webElement){
        return new Select(webElement).getFirstSelectedOption();
    }

    protected List<WebElement> getAllSelectedOptionsInDropdown(WebElement webElement){
        return new Select(webElement).getAllSelectedOptions();
    }

    protected void deselectByVisibleTextInDropdown(WebElement webElement, String visibleText){
        new Select(webElement).deselectByVisibleText(visibleText);
    }

    protected void deselectByValueInDropdown(WebElement webElement, String value){
        new Select(webElement).deselectByValue(value);
    }

    protected void deselectByIndexInDropdown(WebElement webElement, int index){
        new Select(webElement).deselectByIndex(index);
    }

    protected void deselectAllInDropdown(WebElement webElement){
        new Select(webElement).deselectAll();
    }

    protected List<WebElement> getAllOptionsInDropdown(WebElement webElement){
        return new Select(webElement).getOptions();
    }

    protected void dragAndDropElement(WebElement sourceLocation, WebElement dropLocation){
        actions.moveToElement(sourceLocation).dragAndDrop(sourceLocation, dropLocation).build().perform();
    }

    protected void waitForElementToBeClickable(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    //Need more discussion around the usage of JavascriptExecutor
    //A click should be made using selenium instead of injecting it using JS directly
    public void clickWithJavascriptExecutor(WebElement webElement){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webElement);
    }
    private static final String OLD_STRING = "string";

    public String getDynamicXpath(String xPath, String newString) {
        return xPath.replaceFirst(OLD_STRING, newString);
    }

    public List<WebElement> getListOfDynamicWebElements(String xPath, String newString) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver.findElements(By.xpath(xPath.replace(OLD_STRING, newString)));
    }


    protected void pauseTest(Integer timeinmilliseconds){
        try{
            TimeUnit.MILLISECONDS.sleep(timeinmilliseconds);
        }finally {
            return;
        }

    }

    public WebElement getDynamicWebElement(String xPath, String newString) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver.findElement(By.xpath(xPath.replace(OLD_STRING, newString)));
    }
}
