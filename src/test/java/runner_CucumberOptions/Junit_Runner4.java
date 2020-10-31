package runner_CucumberOptions;

import com.intuit.karate.Runner;
import com.intuit.karate.Results;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Junit_Runner4 {

    @BeforeClass
    public static void before() {
        List<String> setEnvironment = new ArrayList<>();
        setEnvironment.add("dev");
        setEnvironment.add("staging");
        setEnvironment.add("e2e");
        setEnvironment.add("qa");
        System.setProperty("Karate.env", setEnvironment.get(1));
    }

    @Test
    public void testParallel() {
        List<String> allTags = new ArrayList<>();
        allTags.add("@karateSanity");
        allTags.add("@karateDebug");

        Results results = Runner.path("classpath:features/karate_API_Features")
                .tags(allTags)
                .parallel(5);
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }
}
