package stepdefinitions;

import java.util.Properties;

import org.testng.Assert;

import com.qa.teapom.pages.WelcomePage;

import apphooks.AppHooks;
import driverFactory.getDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.configreader;

public class welcomestepdefinition  {

	
	WelcomePage wp = new WelcomePage(getDriver.getdriver());
	int i;
	
	@Given("user is on homescreen with title Welcome")
	public void user_is_on_homescreen_with_title_welcome() {
	   String actual= wp.gettitle();
	   Assert.assertEquals(actual, "Welcome");
	}
	@When("user is on {string} add button is clicked")
	public void user_is_on_loose_tea(String tean) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    wp.clickteaname(tean);
	}
	
	/*@Then("user navigates on Menu screen")
	public void user_navigates_on_menu_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/
	
	@When("user clicks on all the links on left side")
	public void user_clicks_on_all_the_links_on_left_side() throws InterruptedException {
	    wp.clickleftlink();
	}
	
	@Then("link should open in new window")
	public void link_should_open_in_new_window() {
		int countoftabs = wp.validateopeining();
		Assert.assertEquals(countoftabs, wp.count+1);
		
	}	
	
}
