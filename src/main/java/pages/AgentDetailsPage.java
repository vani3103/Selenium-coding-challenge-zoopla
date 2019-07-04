package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class AgentDetailsPage extends TestBase {

	@FindBy(xpath = "//h1[@class='bottom-half']/b[1]")
	WebElement agentname;

	public AgentDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String agentname() {
		return agentname.getText();
	}
}
