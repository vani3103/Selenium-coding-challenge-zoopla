package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilities.Waittimes;
import utilities.WebEventListener;

public class TestBase {
public static WebDriver driver;
public static Properties prop;
public  static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;


public TestBase() {
	prop=new Properties();
	try {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/configuration/config.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void initialization() {
	String browser_name=prop.getProperty("browser");
	if(browser_name.equalsIgnoreCase("chrome")){
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("disable-notifications");
		System.setProperty(prop.getProperty("chromekey"), prop.getProperty("chromedriverpath"));
		driver=new ChromeDriver(options);
		
	}
	else {
		if(browser_name.equalsIgnoreCase("firefox")) {
			System.setProperty(prop.getProperty("ff_key"), prop.getProperty("ff_driverPath"));
			driver=new FirefoxDriver();
		}
	}
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Waittimes.implicitWait, TimeUnit.MILLISECONDS);
	driver.get(prop.getProperty("url"));
}
}
