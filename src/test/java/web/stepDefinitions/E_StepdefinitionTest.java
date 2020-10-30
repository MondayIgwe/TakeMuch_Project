package web.stepDefinitions;

import cucumber.api.java.en.*;

public class E_StepdefinitionTest {
    @Given("^a book \"(.*?)\" with the following body$")
    public void a_book_with_the_following_body(String bookName, String cookbookText) {
        System.out.println(bookName +""+ cookbookText);
    }

    @Given("^I have a user with (.*?) rights$")
    public void i_have_a_user_with_Manager_rights(String role) {
        System.out.println(role);
        System.out.println();
    }

    @Then("^I am sending you email with a body:$")
    public void i_am_sending_you_email_with_a_body(String email){

        System.out.println(email);
    }

}
