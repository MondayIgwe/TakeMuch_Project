package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class D_StepDefinition {

    @Then("^i( do not see| see) following dollars in my account$")
    public void i_see_following_dollars_in_my_account(String seeOrDoNotSee){
        System.out.println(seeOrDoNotSee);
    }

    @Given("^(?:i have|he has|we have)seen it all$")
    public void i_have_seen_it_all() throws Throwable {
    }
}
