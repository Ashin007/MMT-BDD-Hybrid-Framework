package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDef {
    @Given("User is on landing page")
    public void userIsOnLandingPage() {
    }

    @When("User click on flight")
    public void userClickOnFlight() {
    }

    @And("click on round trip")
    public void clickOnRoundTrip() {
    }

    @Then("Select from: {string} and to:{string}")
    public void selectFromAndToBangalore(String from, String to) {
    }

    @And("Select departure date:today")
    public void selectDepartureDateToday() {

    }

    @And("return date: after {int} days")
    public void returnDateAfterDays(int numberOfDays) {
    }

    @Then("click on search")
    public void clickOnSearch() {

    }

    @Then("print total number of records of departure flight")
    public void printTotalNumberOfRecordsOfDepartureFlight() {
    }

    @And("print return flight list")
    public void printReturnFlightList() {
    }

    @Then("select non-stop and {int} stop filter options")
    public void selectNonStopAndStopFilterOptions(int arg0) {
    }

    @And("print total number of departure flight and return flight")
    public void printTotalNumberOfDepartureFlightAndReturnFlight() {
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
