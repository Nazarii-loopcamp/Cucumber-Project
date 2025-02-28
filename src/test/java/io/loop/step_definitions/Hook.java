package io.loop.step_definitions;

import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.*;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.logging.log4j.Logger;

public class Hook {

    private static final Logger LOG = LogManager.getLogger();

    @Before
    public void setup(Scenario scenario) {
        Driver.getDriver();
        BrowserUtils.myScenario = scenario;
        LOG.info("-------------------------- AUTOMATION STARTED --------------------------");
    }

    @After
    public void teardown(Scenario scenario) {
        // Only takes screenshot where scenario is failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        LOG.info("-------------------------- END AUTOMATION --------------------------");
        Driver.closeDriver();
    }

    @AfterStep
    public void takeScreenshot (Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

}
