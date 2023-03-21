package StepDefinitions;

import io.cucumber.java.en.*;

public class _01_LoginSteps {

    @Given("Navigate to Campus")
    public void navigate_to_campus() {
        System.out.println("merhaba selenium");
    }
    @When("Enter username and password and click login button")
    public void enter_username_and_password_and_click_login_button() {
        System.out.println("merhaba testNG");
    }
    @Then("User should login succesfully")
    public void user_should_login_succesfully() {
        System.out.println("merhaba cucumber");
    }
}
