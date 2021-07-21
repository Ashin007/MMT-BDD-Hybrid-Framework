package stepdefinitions;

import com.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.SearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MyStepDef {

    HomePage homePage;
    SearchResultPage resultPage;

    @Given("User is on landing page")
    public void userIsOnLandingPage() {
        homePage = new HomePage(DriverFactory.getWebDriver());
        System.out.println(homePage.getLandingPageName());
    }

    @When("User click on flight")
    public void userClickOnFlight() {
        homePage.clickOnFlightLink();
    }

    @And("click on round trip")
    public void clickOnRoundTrip() {
        homePage.clickOnRoundTrip();
    }

    @Then("Select from: {string} and to:{string}")
    public void selectFromAndToBangalore(String from, String to) {
        homePage.enterFromPlace(from);
        homePage.enterToPlace(to);
    }

    @And("Select departure date:today")
    public void selectDepartureDateToday() {
        homePage.selectDepartureDateAsToday();
    }

    @And("return date: after {int} days")
    public void returnDateAfterDays(int numberOfDays) {
    }

    @Then("click on search")
    public void clickOnSearch() {
        resultPage = homePage.clickOnSearch();

    }

    @Then("print total number of records of departure flight")
    public void printTotalNumberOfRecordsOfDepartureFlight() {
        resultPage.getTitle();
        Assert.assertFalse(resultPage.isResultEmpty());
        List<String> flightList = resultPage.getDepartureFlights();
        if(!flightList.isEmpty()){
            System.out.println("----Departure Flights----");
            for (String flight:flightList){
                System.out.println(flight);
            }
        }

    }

    @And("print return flight list")
    public void printReturnFlightList() {

        Assert.assertFalse(resultPage.isResultEmpty());
        List<String> flightList = resultPage.getReturnFlights();
        if(!flightList.isEmpty()){
            System.out.println("----Return Flights----");
            for (String flight:flightList){
                System.out.println(flight);
            }
        }




    }

    @Then("select non-stop filter options")
    public void selectNonStopFilterOptions() {
        resultPage.clickOnNonStop();
        System.out.println("Clicked on non stop filter");

    }

    @And("print total number of departure flight and return flight")
    public void printTotalNumberOfDepartureFlightAndReturnFlight() {
        Assert.assertFalse(resultPage.isResultEmpty());
        List<String> returnFlightList = resultPage.getReturnFlights();
        if(!returnFlightList.isEmpty()){
            System.out.println("----Return Flights----");
            for (String flight:returnFlightList){
                System.out.println(flight);
            }
        }

        Assert.assertFalse(resultPage.isResultEmpty());
        List<String> departureFlightList = resultPage.getDepartureFlights();
        if(!departureFlightList.isEmpty()){
            System.out.println("----Departure Flights----");
            for (String flight:departureFlightList){
                System.out.println(flight);
            }
        }

    }

    @Then("select radio button of top {int} options of departure flight and return flight")
    public void selectRadioButtonOfTopOptionsOfDepartureFlightAndReturnFlight(int arg0) {
    }

    @And("verify the same departure flight price and return flight price are getting reflected in bottom page")
    public void verifyTheSameDepartureFlightPriceAndReturnFlightPriceAreGettingReflectedInBottomPage() {
    }

    @Then("verify the correct total amount is getting reflected correctly")
    public void verifyTheCorrectTotalAmountIsGettingReflectedCorrectly() {
    }
}
