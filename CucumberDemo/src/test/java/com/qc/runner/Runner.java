package com.qc.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = "src/test/resources/", glue = "com/qc/steps", 
				monochrome = true, 
				plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumberreports/report.html" },
				tags = { "@InvalidData" })
@RunWith(Cucumber.class)
public class Runner {

}
