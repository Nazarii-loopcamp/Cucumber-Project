package io.loop.step_definitions;

import io.cucumber.java.*;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;

public class Hook {

    @Before
    public void setup() {
        Driver.getDriver();
    }

    @After
    public void teardown() {
        Driver.closeDriver();
    }

}
