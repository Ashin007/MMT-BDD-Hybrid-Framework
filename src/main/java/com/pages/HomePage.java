package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class HomePage {

    WebDriver driver;
    By flightLink = By.xpath("//li[@class='menu_Flights']/a");

    By fromElement = By.id("fromCity");
    By toElement = By.id("toCity");

    By departureTab = By.cssSelector("p[data-cy='departureDate']");
    By currentDate = By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']");

    By roundTripElement = By.cssSelector("li[data-cy='roundTrip']");

    By searchElement = By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getLandingPageName(){

        avoidLoginSuggestion();

        return driver.getTitle();
    }

    public void clickOnFlightLink(){
        driver.findElement(flightLink).click();
    }
    public void clickOnRoundTrip(){
        driver.findElement(roundTripElement).click();
    }
    public void enterFromPlace(String fromPlace){
        driver.findElement(fromElement).sendKeys(fromPlace);
    }
    public void enterToPlace(String toPlace){
        driver.findElement(toElement).sendKeys(toPlace);
    }

    public SearchResultPage clickOnSearch(){
        driver.findElement(searchElement).click();
        return new SearchResultPage(driver);
    }
    public void selectDepartureDateAsToday(){

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("E, MMM dd yyyy");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime then = now.plusDays(7);

        String nnw = now.format(format).replace(",","");
        String tdays = then.format(format).replace(",","");


        driver.findElement(departureTab).click();
        //today
        //driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']")).click();
        //DayPicker-Day DayPicker-Day--start DayPicker-Day--selected
        driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected']")).click();
        System.out.println("//div[@class='DayPicker-Day' and @aria-label='"+nnw+"']");
        //System.out.println(driver.findElement(currentDate).getText());
        //driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='"+nnw+"']")).click();
        driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='"+tdays+"']")).click();




    }

    public void avoidLoginSuggestion(){
        if(driver.findElements(By.xpath("//div[@data-cy='googleLogin']")).size()>0){
            driver.findElement(By.xpath("//div[@data-cy='outsideModal']")).click();
        }
        else{
            System.out.println("okay");
        }
    }
}
