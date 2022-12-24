package cucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:TestsReport.html", "json:TestsReport.json"},
        dryRun = false,
        monochrome = true,
        tags = "@p1 and @iphone11 and @setCookies and @unsetCookies"
)
public class CucumberTestRunner {
}
