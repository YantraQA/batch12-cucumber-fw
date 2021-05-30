package com.yantraQA.pageobjects;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CmnPageObjects {

    WebDriver driver;

    By proceedNext = By.id("proceed-link");
    By detailsButton = By.id("details-button");


    public CmnPageObjects(WebDriver driver){
        this.driver = driver;
    }

    public void proceedToNext(String u, String p){

    }

}
