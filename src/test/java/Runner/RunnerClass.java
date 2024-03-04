package Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features/identifycourse.feature" ,
		glue="stepDefinition",
		plugin = {"pretty", "html:reports/Cucumberreport.html","rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} ,
		dryRun=false,
		monochrome=true,
		publish=true)
public class RunnerClass {

}
