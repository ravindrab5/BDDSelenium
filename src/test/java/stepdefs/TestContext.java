package stepdefs;

import com.ideas.chimps.bddselenium.config.Environment;
import com.ideas.chimps.bddselenium.config.EnvironmentConfig;
import com.ideas.chimps.bddselenium.util.ApiController;
import com.ideas.chimps.bddselenium.util.EventDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@Getter
@ContextConfiguration(classes = {EnvironmentConfig.class})
public class TestContext {
    @Autowired
    private EventDriver eventDriver;

    @Autowired
    protected Environment environment;

    @Autowired
    protected ApiController controller;

    @Before
    public void SetupCucumberSpringContext(Scenario scenario) {
        setUp(scenario);
        setupMangementCompanyProperty();
    }

    @After
    public void tearDown(Scenario scenario){
        eventDriver.stopTest(scenario);
        eventDriver.stopDriver();
        tearDownManagementCompanyProperty();
    }

    protected void setUp(Scenario scenario){
        if(System.getProperty("env")==null){
            System.setProperty("env","qa2");
        }
        eventDriver.startTest(scenario);
    }

    protected void setupMangementCompanyProperty(){
        controller.login();
        controller.createManagementCompany();
        controller.doGeoSetup();
        controller.defineSegmentTypes();
        controller.defineSegmentCategoryStructure();
        controller.createProperty();
        controller.createCompanySegment();
        controller.createSegment();
        controller.generateRdpData();

    }

    protected void tearDownManagementCompanyProperty(){
        controller.deactiveManagementId();
    }


}
