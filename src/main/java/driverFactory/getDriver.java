package driverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getDriver {

	//public  WebDriver driver;
	Properties pro;
	
	static ThreadLocal<WebDriver> tldriver = new ThreadLocal();
	
	public  WebDriver getdriver(String browsername) throws IOException {
		
		/*pro= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\resources\\java\\config\\config.properties");
		pro.load(fis);
		
		if (pro.get("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(pro.getProperty("url"));
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			
		}else if (pro.get("browser").equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		return driver;
	}*/
		
		
		
		
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();;
			tldriver.set(new ChromeDriver());
		}else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}else {
			System.out.println("Give proper browser "+browsername);
		}
		
		getdriver().manage().window().maximize();
		getdriver().manage().deleteAllCookies();
		return getdriver();
	}
	
	
	public static WebDriver getdriver() {
		return tldriver.get();
	}
}
