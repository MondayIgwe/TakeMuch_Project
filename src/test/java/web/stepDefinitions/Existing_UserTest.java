package web.stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Existing_UserTest {
    @Given("^user is on the application landing page$")
    public void user_is_on_the_application_landing_page() throws Throwable {

    }

    @Then("^we verify expected outcome of the following$")
    public void we_verify_expected_outcome_of_the_following(DataTable userData) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)

        List<List<String>> data = userData.raw();
        for(int i=0;i<data.size();i++){
            for (int  j=0;j<data.size();j++){
                System.out.println(data.get(i).get(j));
            }
        }

    }

    //REST API
    @Given("^user send a GET request \"([^\"]*)\"$")
    public void userSendAGETRequest(String resource) {
        given()
                .get(resource)
                .then().statusCode(200).body("data.id[1]", equalTo(8))
                .log().status().log().everything();
    }
}
