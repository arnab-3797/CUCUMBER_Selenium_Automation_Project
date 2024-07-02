package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(
		features = {"src/test/java/features/"},
		dryRun = !true,
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = "steps",
		plugin = {"pretty", "html:reports/CucumberReport.html",
				    "json:reports/result.json",
				    "junit:reports/result.xml"}
		
		)
       
public class Runner extends AbstractTestNGCucumberTests {

}
