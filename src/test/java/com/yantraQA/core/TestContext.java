package com.yantraQA.core;

import com.yantraQA.pageobjects.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class TestContext {

    public WebDriver driver;
    public String base_url = "https://amazon.in";
    public int implicit_wait_timeout_in_sec = 20;
    public Scenario scn;

    public CmnPageObjects cmnPageObjects;
    public HomePageObjects homePageObjects;
    public SignInPageObjects signInPageObjects;
    public SearchPageObjects searchPageObjects;
    public ProductDescriptionPageObjects productDescriptionPageObjects;
}
