package runner_CucumberOptions;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
@KarateOptions(features = "classpath:features/karate_API_Features",
            tags = "@karateDebug")
public class karate_Runner {
}
