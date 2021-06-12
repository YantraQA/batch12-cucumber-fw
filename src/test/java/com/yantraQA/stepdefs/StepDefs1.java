package com.yantraQA.stepdefs;

import com.yantraQA.core.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;

@Log4j2
public class StepDefs1{

    TestContext testContext;
    public Scenario scn;

    @Before
    public void temp(Scenario s){
        this.scn = s;
    }

    //Dependency Injections using Pico Container
    public StepDefs1(TestContext testContext){
        this.testContext = testContext;
        this.scn = testContext.scn;
    }

    @Given("User navigated to the home application url")
    public void user_navigated_to_the_home_application_url() {
        testContext.driver.get(testContext.base_url);
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

    @Given("want to send multiple items in list form")
    public void want_to_send_multiple_items_in_list_form(List<String> list) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        System.out.println(list.toString());
    }

    @Given("want to send multiple items in map form")
    public void want_to_send_multiple_items_in_map_form(Map<String,String> hMap) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        System.out.println(hMap.toString());
    }



}
