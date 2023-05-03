package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Regression or @SmokeTest", // hangi senaryolarda bu etiket varsa onlar çalıştırılacak
        // or yerine and yazılırsa hem smoke hem de regression tag i olanları çalıştırıyor
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
        ,plugin= {"json:target/cucumber/cucumber.json"} // Jenkins için JSON report
)
public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}
