package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Prasad_Reddy\\IdeaProjects\\BDD\\Features\\basic.feature",
        glue= {"StepDefinitions"},
        plugin={"pretty","html:test-output","json:jshon_output/cucumber.json","junit:junit-output/cucumber.xml" })




public class testRunner {

}
