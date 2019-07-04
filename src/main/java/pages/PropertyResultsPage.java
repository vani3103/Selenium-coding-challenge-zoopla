package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.TestBase;

public class PropertyResultsPage extends TestBase{
	@FindBy(xpath="//a[@class='listing-results-price text-price']")
    List<WebElement>prices;
	@FindBy(xpath="//button[@class='btn']/i")
	WebElement cancelfilterBtn;
	ArrayList<Integer>priceslist=new ArrayList<Integer>();
	
	
	public PropertyResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void priceslist() {
		for(WebElement price:prices) {
			String cost=price.getText();
			String finalPrice=cost.replaceAll("[^0-9]", "");
			//System.out.println(finalPrice);
			priceslist.add(Integer.parseInt(finalPrice));
			
		}
		Collections.sort(priceslist);
		System.out.println("afterSorting prices are:");
		System.out.println(priceslist);
	}
	
	 

	
	public PropertyDetailsPage selectingproperty(int num) {
		cancelfilterBtn.click();
		System.out.println("fifth propert val is :"+prices.get(num).getText());
		/*WebDriverWait wait = new WebDriverWait(driver,30);
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),prices.get(num))]")));
        		//"//a[@class='listing-results-price text-price']")));
*/		prices.get(num).click();
		return new PropertyDetailsPage();
	}
}
