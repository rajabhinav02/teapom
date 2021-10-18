package testrunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src\\resources\\java\\feature"},
					glue= {"stepdefinitions", "apphooks"})
public class testrunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider//(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
}
