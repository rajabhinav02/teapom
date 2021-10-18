package apphooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import driverFactory.getDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.configreader;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AppHooks {

	private getDriver gd;
	private configreader cr;
	Properties pro;
	WebDriver driver;

	@Before(order = 0)
	public void getProperty() {
		cr = new configreader();
		pro = cr.getPro();
	}

	@Before(order = 1)
	public void loadurl() throws IOException {
		String browsername = pro.getProperty("browser");
		
		String url = pro.getProperty("url");
		gd = new getDriver();
		driver=gd.getdriver(browsername);
		
		driver.get(url);
		


	}

	@After(order = 1)
	public void getSS(Scenario sc) {
		if (sc.isFailed()) {
			String ssname = sc.getName().replace(" ", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "img/png", ssname);
		}

	}

	@After(order = 0)
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
