package stepDefinitions;
import cucumber.api.Format;
import cucumber.api.java.en.Given;

import  java.util.Date;
public class F_StepDef {
    @Given("^my birthday is \"(.*?)\"$")
    public void my_birthday_is(@Format("dd-MM-yyyy") Date date) {
        System.out.println(date);
    }

}
