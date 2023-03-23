package StepDefinitions;

import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {

    LeftNav ln=new LeftNav();

    @And("Navigate to CitizenShip page")
    public void navigateToCitizenShipPage() {
        ln.clickFunction(ln.citizenShip);
    }

    @When("User a CitizenShip name as {string} short name as {string}")
    public void userACitizenShipNameAsShortNameAs(String name, String shortName) {

    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
    }
}
