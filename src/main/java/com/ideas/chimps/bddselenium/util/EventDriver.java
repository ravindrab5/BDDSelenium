package com.ideas.chimps.bddselenium.util;




import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.Scenario;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventDriver {

    @Autowired
    private EventHandler handler;

    @Autowired
    private SeleniumApi seleniumApi;

    private ExtentTest logger;

    public void startTest(Scenario scenario){
        logger=ExtentTestManager.startTest(scenario.getName());
    }

    public void stopTest(Scenario scenario){

        if(scenario.isFailed()){
            ExtentTestManager.logFail(scenario.getName());
        }else{
            ExtentTestManager.logPass(scenario.getName());
        }

        ExtentTestManager.endTest(scenario.getName());
    }


    public EventFiringWebDriver getDriver(){
        return new EventFiringWebDriver(seleniumApi.start()).register(handler);
    }

    public ExtentTest getExtentLogger(){
        return logger;
    }

    public void stopDriver(){

        seleniumApi.quit();
    }

}
