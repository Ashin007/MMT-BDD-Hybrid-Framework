package com.pages;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    WebDriver driver;
    By searchResultErrorElement = By.id("fullpage-error");
    String flightPartA = "//div[@class='paneView'][";
    String flightPartB = "]/div[2]/div/label/div/div/span";

    By nonStopFilterElement = By.xpath("//span[@class='filterName' and @title='Non Stop']/parent::span/parent::div/span[@class='customCheckbox'][1]");






    public boolean isResultEmpty(){
        return driver.findElements(searchResultErrorElement).size()>0;
    }

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public void getTitle(){
        System.out.println(driver.getTitle());
    }

    public List<String> getDepartureFlights(){


        return getFlightList(1);
    }

    public List<String>getReturnFlights(){
        return getFlightList(2);
    }

    private List<String> getFlightList(int tabNumber) {
        String flight_xpath = flightPartA+tabNumber+flightPartB;
        By flightElement = By.xpath(flight_xpath);
        List<String> flightNameList = new ArrayList<String>();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        List<WebElement> flightList = driver.findElements(flightElement);
        System.out.println(flightList.size());
        for (WebElement flight:flightList){
            flightNameList.add(flight.getText());
        }
        jse.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        return flightNameList;

    }

    public void clickOnNonStop(){
        driver.findElement(nonStopFilterElement).click();
    }
}
