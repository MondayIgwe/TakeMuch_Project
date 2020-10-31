package rest_Automation.SteDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import rest.RestFactory;

public class RestServices {
    RestFactory restFactory = new RestFactory();

    @When("^user sends request \"([^\"]*)\"$")
    public void user_sends_request(String uri) throws Throwable {
            restFactory.get(uri);
    }

    @Then("^status code should be (\\d+)$")
    public void status_code_should_be(int arg1) throws Throwable {

    }

    @Then("^response type should be \"([^\"]*)\"$")
    public void response_type_should_be(String arg1) throws Throwable {

    }

    @Then("^response contains user name \"([^\"]*)\"$")
    public void response_contains_user_name(String arg1) throws Throwable {

    }


    @When("^user sends a post request to \"([^\"]*)\" with the following details$")
    public void user_sends_a_post_request_to_with_the_following_details(String url, DataTable data) throws Throwable {

    }
}

