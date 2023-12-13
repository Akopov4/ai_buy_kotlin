package com.example.ai_buy_kotlin;
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/kotlin/tests/"],
    glue = ["test.tests"],
    plugin = ["pretty", "html:target/cucumber-reports"],
    monochrome = true
)
public class RunCucumberTest {

}