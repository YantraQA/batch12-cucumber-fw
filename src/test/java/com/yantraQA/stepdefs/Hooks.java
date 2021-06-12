package com.yantraQA.stepdefs;

import com.yantraQA.core.TestContext;
import com.yantraQA.core.WebDriverFactory;
import com.yantraQA.pageobjects.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Map;

@Log4j2
public class Hooks {

    TestContext testContext;
    WebDriver driver;

    //Dependency Injections using Pico Container
    public Hooks(TestContext testContext) {
        this.testContext = testContext;
        driver = testContext.driver;
    }

    @Before
    public void setUp(Scenario scn) throws Exception {
        testContext.initializeWebDriver();
        testContext.intializePageObjects();
        testContext.scn = scn;
    }

    @After(order=1)
    public void cleanUp(Scenario scn){
        testContext.quitDriver();
        scn.log("Browser Closed");
    }

    @After(order=2)
    public void takeScreenShot(Scenario scn) {
        if (scn.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + scn.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }

}
