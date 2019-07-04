package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import testbase.TestBase;

public class HomePageTest extends TestBase {
	HomePage homepage;
public HomePageTest() {
	super();
}
@BeforeTest
public void setup() {
	initialization();
	homepage=new HomePage();
}

@Test(enabled=false)
public void verifytitle() {
	String title=homepage.gettitle();
	System.out.println(title);
}

@Test
public void searchProperty() {
	homepage.searchProperty(prop.getProperty("location"));
}

@AfterTest
public void teardown() {
	driver.quit();
}
}
