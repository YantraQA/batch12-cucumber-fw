package com.yantraQA.stepdefs;

import com.aventstack.extentreports.model.Test;
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
public class StepDefs1{ //extends TestContext {

    TestContext testContext;
    public  WebDriver driver;
    public String base_url;
    public Scenario scn;
    public CmnPageObjects cmnPageObjects;
    public HomePageObjects homePageObjects;
    public SignInPageObjects signInPageObjects;
    public SearchPageObjects searchPageObjects;
    public ProductDescriptionPageObjects productDescriptionPageObjects;

    //Dependency Injections
    public StepDefs1(TestContext testContext){
        this.testContext = testContext;
        cmnPageObjects = testContext.cmnPageObjects;
        homePageObjects = testContext.homePageObjects;
        signInPageObjects = testContext.signInPageObjects;
        searchPageObjects = testContext.searchPageObjects;
        productDescriptionPageObjects = testContext.productDescriptionPageObjects;
        base_url = testContext.base_url;
    }

    @Before
    public void setUp(Scenario scn) throws Exception {
        this.scn = scn; //Assign this to class variable, so that it can be used in all the step def methods

        //Get the browser name by default it is chrome
        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
        log.info("Browser invoked.");

        //Init Page Object Model Objects
        cmnPageObjects = new CmnPageObjects(driver);
        homePageObjects = new HomePageObjects(driver);
        signInPageObjects = new SignInPageObjects(driver);
        searchPageObjects = new SearchPageObjects(driver);
        productDescriptionPageObjects = new ProductDescriptionPageObjects(driver);

    }

    @After(order=1)
    public void cleanUp(){
        WebDriverFactory.quitDriver();
        scn.log("Browser Closed");
    }

    @After(order=2)
    public void takeScreenShot(Scenario s) {
        if (s.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }

    @Given("User navigated to the home application url")
    public void user_navigated_to_the_home_application_url() {
        WebDriverFactory.navigateToTheUrl(base_url);
        scn.log("Browser navigated to URL: " + base_url);

        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        cmnPageObjects.validatePageTitleMatch(expected);
    }

    @When("User Search for product {string}")
    public void user_search_for_product(String productName) {
        cmnPageObjects.SetSearchTextBox(productName);
        cmnPageObjects.ClickOnSearchButton();
        scn.log("Product Searched: " + productName);
    }

    @Then("Search Result page is displayed")
    public void search_result_page_is_displayed() {
        searchPageObjects.ValidateProductSearchIsSuccessfull();
    }



}
