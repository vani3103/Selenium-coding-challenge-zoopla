package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class PropertyDetailsPage extends TestBase {

	@FindBy(xpath = "//div[@id='dp-sticky-element']/child::div/child::div/a[@class='ui-agent__details']/div[@class='ui-agent__text']/h4")
	WebElement agentname;

	@FindBy(xpath = "//div[@id='dp-sticky-element']//div[@class='ui-agent']/p/a/span")
	WebElement agent_Phone;

	public PropertyDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public void agentDetails() {
		System.out.println("Agent Name is :" + agentname.getText());
		System.out.println("Agent MObile num is :" + agent_Phone.getText());
	}
	public String agentname() {
		return agentname.getText();
	}

	public AgentDetailsPage clickOnAgentName() {
		agentname.click();
		return new AgentDetailsPage();
	}
}
