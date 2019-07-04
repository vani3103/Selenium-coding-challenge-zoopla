package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PropertyResultsPage;
import testbase.TestBase;

public class PropertResultsPageTest extends TestBase {
	HomePage homepage;
	PropertyResultsPage propertiesresultspage;

	public PropertResultsPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		homepage = new HomePage();
		propertiesresultspage=homepage.searchProperty(prop.getProperty("location"));

	}

	@Test(priority = 1)
	public void prices() {
		propertiesresultspage.priceslist();
	}

	@Test(priority = 2)
	public void selectproperty() {
		propertiesresultspage.selectingproperty(Integer.parseInt(prop.getProperty("index")));
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
