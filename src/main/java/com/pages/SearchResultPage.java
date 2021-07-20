package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    WebDriver driver;
    By searchResultErrorElement = By.id("fullpage-error");



    public boolean isResultEmpty(){
        return driver.findElements(searchResultErrorElement).size()>0;
    }

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public void getTitle(){
        System.out.println(driver.getTitle());
    }
}
