package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    WebDriver driver;
    JavascriptExecutor jse;
    By searchResultErrorElement = By.id("fullpage-error");
    String flightPartA = "//div[@class='paneView'][";
    String flightPartB = "]/div[2]/div/label/div/div/span";

    By nonStopFilterElement = By.xpath("//span[@class='filterName' and @title='Non Stop']/parent::span/parent::div/span[@class='customCheckbox'][1]");
    By selectTop10DepartureFlight = By.xpath("//div[@class='paneView'][1]/div[2]/div/label/div/div[2]/div[2]/span/span");
    By selectTop10ReturnFlight = By.xpath("//div[@class='paneView'][2]/div[2]/div/label/div/div[2]/div[2]/span/span");






    public boolean isResultEmpty(){
        return driver.findElements(searchResultErrorElement).size()>0;
    }

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        jse = (JavascriptExecutor)driver;
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

    public void clickOnTopDepartureFlight(int topFlightList){
        WebElement element = driver.findElements(selectTop10DepartureFlight).get(topFlightList);
        clickOnFlightRadioButton(element);

    }
    public void clickOnTopReturnFlight(int topFlightList){
        WebElement element = driver.findElements(selectTop10ReturnFlight).get(topFlightList);
        clickOnFlightRadioButton(element);
    }

    private void clickOnFlightRadioButton(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
}
