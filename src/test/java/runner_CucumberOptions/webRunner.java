package runner_CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "web.stepDefinitions",
        dryRun = false,
        strict = false,
        monochrome = true,
        tags = "@debug",
        //tags = {"~@web","@web2","@rest","@debug"},
        plugin = {"pretty","html:target/Cucumber"},
        snippets = SnippetType.UNDERSCORE
        )

public class webRunner {

}
