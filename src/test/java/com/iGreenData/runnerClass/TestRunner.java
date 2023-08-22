package com.iGreenData.runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/iGreenData/features/firstTestCase.feature", glue = {
		"com.iGreenData.stepDefinition", "com.iGreenData.baseSetup.baseClass" }, monochrome = true, dryRun = false, plugin = { "pretty",
				"html:target/cucumber-reports", "json:target/cucumber-json-reports/report.json",
				"junit:target/cucumber-xml-reports/report.xml" })

public class TestRunner {

}
