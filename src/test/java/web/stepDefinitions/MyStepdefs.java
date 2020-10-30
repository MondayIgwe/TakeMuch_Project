package web.stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pagesFactory.LoginPage;

import java.util.List;

import static io.restassured.RestAssured.given;

public class MyStepdefs {
    LoginPage loginPage;
    WebDriver driver;

    @Given("^user is on the application \"(.*?)\" home page$")
    public void user_is_on_the_application_home_page(String url) throws Exception {
        loginPage = new LoginPage(driver);
        System.out.println(url);
        loginPage.caller();


    }

    @When("^user enters \"(.*?)\" in the username field$")
    public void user_enters_in_the_username_field(String arg1) throws PendingException {
        System.out.println("When");
    }

    @When("^user enters \"(.*?)\" in the password field$")
    public void user_enters_in_the_password_field(String arg1) throws PendingException {
        System.out.println("When");
    }

    @Then("^user clicks on the login button$")
    public void user_clicks_on_the_login_button() throws PendingException {
        System.out.println("Then");
    }

    @But("^user did not input (\\d+)$")
    public void user_did_not_input(int arg1) throws PendingException {
        System.out.println("pass a number Integer");
    }
    @But("^user is not available \"([^\"]*)\"$")
    public void user_is_not_available(List<String> days) throws PendingException {
        System.out.println("pass a List of values"+ "  "+ days.get(1));
    }

}
