package runner_CucumberOptions;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit_Runner5 {

    @Test
    void testParallel() {
        List<String> allTags = new ArrayList<>();
        allTags.add("@karateDebug");

        Results results = Runner.path("classpath:animals").tags(allTags).parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

}
