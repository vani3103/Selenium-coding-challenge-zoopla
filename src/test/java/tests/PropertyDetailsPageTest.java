package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PropertyDetailsPage;
import pages.PropertyResultsPage;
import testbase.TestBase;

public class PropertyDetailsPageTest extends TestBase {
	HomePage homepage;
	PropertyDetailsPage propertydetailspage;
	PropertyResultsPage propertyresultspage;
	public PropertyDetailsPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		homepage=new HomePage();
		propertyresultspage=homepage.searchProperty(prop.getProperty("location"));
		propertydetailspage=propertyresultspage.selectingproperty(Integer.parseInt(prop.getProperty("index")));
		propertydetailspage.agentDetails();
		
	}
	
	@Test
	public void agentdetails() {
		
	}
	
	@AfterTest
	public void teardown() {
		
	}
}
