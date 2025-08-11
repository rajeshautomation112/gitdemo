package stepDefination;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\mavenprojectweekdays1230selenium\\src\\test\\resources\\datable.feature",// path
        glue = {"stepDefination"},// package
        plugin = {"pretty","html:target/cucumber-report/Logintable.html"},
        monochrome = false

)

public class Testrunner {
}
