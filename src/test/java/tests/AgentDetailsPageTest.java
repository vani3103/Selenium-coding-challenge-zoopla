package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AgentDetailsPage;
import pages.HomePage;
import pages.PropertyDetailsPage;
import pages.PropertyResultsPage;
import testbase.TestBase;
import utilities.TestUtil;

public class AgentDetailsPageTest extends TestBase {
	HomePage homepage;
	PropertyResultsPage propertyresultspage;
	PropertyDetailsPage propertydetailspage;
	AgentDetailsPage agentdetailspage;
	String aname=null;
public AgentDetailsPageTest() {
	super();
}
@BeforeTest
public void setUp() {
	initialization();
	homepage=new HomePage();
	propertyresultspage=new PropertyResultsPage();
	propertydetailspage=new PropertyDetailsPage();
	agentdetailspage=new AgentDetailsPage();
	propertyresultspage=homepage.searchProperty(prop.getProperty("location"));
	propertyresultspage.priceslist();
	propertydetailspage=propertyresultspage.selectingproperty(Integer.parseInt(prop.getProperty("index")));
	aname=propertydetailspage.agentname();
	agentdetailspage=propertydetailspage.clickOnAgentName();
	
}

@Test
public void testagent() {
	String agentName=agentdetailspage.agentname();
	Assert.assertTrue(agentName.contains(aname));
}

@AfterTest
public void teardown() {
	try {
		TestUtil.takeScreenshotAtEndOfTest();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
}
}
