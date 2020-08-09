package com.ideas.chimps.bddselenium.tests;

import com.ideas.chimps.bddselenium.util.ApiController;
import io.cucumber.testng.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.*;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        },
      //  tags = { "@reportcriteria","@checkdisplaycriteria"},
        features = {"classpath:features"},
        glue = {"stepdefs"},
        strict = true
)
public class TestRunner{
    private TestNGCucumberRunner testNGCucumberRunner;

    @Parameters({"env","tags"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String arg1,String tags) throws Exception {

        System.setProperty("env",arg1);
        if(!tags.equals("")){
            System.setProperty("cucumber.filter.tags",tags);
        }
        System.out.println("Test Runner Initalized");

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }

    @Test(description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        // the 'featureWrapper' parameter solely exists to display the feature file in a test report
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        testNGCucumberRunner.finish();
    }
}
