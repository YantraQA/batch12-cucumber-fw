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
import org.openqa.selenium.*;


@Log4j2
public class StepDefs1{

    TestContext testContext;
    public Scenario scn;

    //Dependency Injections using Pico Container
    public StepDefs1(TestContext testContext){
        this.testContext = testContext;
        this.scn = testContext.scn;
    }

    @Given("User navigated to the home application url")
    public void user_navigated_to_the_home_application_url() {
        WebDriverFactory.navigateToTheUrl(testContext.base_url);
        scn.log("Browser navigated to URL: " + testContext.base_url);

        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        testContext.cmnPageObjects.validatePageTitleMatch(expected);
    }

    @When("User Search for product {string}")
    public void user_search_for_product(String productName) {
        testContext.cmnPageObjects.SetSearchTextBox(productName);
        testContext.cmnPageObjects.ClickOnSearchButton();
        scn.log("Product Searched: " + productName);
    }

    @Then("Search Result page is displayed")
    public void search_result_page_is_displayed() {
        testContext.searchPageObjects.ValidateProductSearchIsSuccessfull();
    }



}
