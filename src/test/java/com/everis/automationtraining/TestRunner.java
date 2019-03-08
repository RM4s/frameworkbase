package com.everis.automationtraining;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        format = {"pretty", "json:target/cucumber/cucumber.json", "html:target/cucumber/cucumber.html"},
        strict = true,
        features = "classpath:features")
public class TestRunner extends AbstractTestNGCucumberTests {

}
