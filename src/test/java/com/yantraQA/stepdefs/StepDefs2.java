package com.yantraQA.stepdefs;

import com.yantraQA.core.TestContext;
import com.yantraQA.core.WebDriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StepDefs2 {

    TestContext testContext;
    public Scenario scn;

    //Dependency Injections using Pico Container
    public StepDefs2(TestContext testContext){
        this.testContext = testContext;
        this.scn = testContext.scn;
    }


    @Then("Search Result page is displayed")
    public void search_result_page_is_displayed() {
        testContext.searchPageObjects.ValidateProductSearchIsSuccessfull();
    }



}
