package coreRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resource/FeatureFiles",
	glue = {"stepDefination"},
			tags = {"@Login, @Dashboard, @DroneSelection"},
			monochrome = false,
	plugin= {"pretty","html:target/cucumber-reports"}
		)
public class TestRunner {

	
}
