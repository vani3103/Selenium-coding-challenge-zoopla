package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class HomePage extends TestBase {
	@FindBy(id="search-input-location")
	WebElement from_loc;
	
	@FindBy(id="search-submit")
	WebElement searchBtn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String gettitle() {
		return driver.getTitle();
	}
	
	public PropertyResultsPage searchProperty(String loc) {
		from_loc.sendKeys(loc);
		searchBtn.click();
		return new PropertyResultsPage();
	}
}
