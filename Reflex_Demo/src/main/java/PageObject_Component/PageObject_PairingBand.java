package PageObject_Component;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.Base_class;
import io.appium.java_client.AppiumDriver;

public class PageObject_PairingBand extends Base_class {

	
	public PageObject_PairingBand (AppiumDriver androidDriver)
	{
		PageFactory.initElements(androidDriver, this);
		
	}
	
	
	@FindBy(id="com.isport.fastrack:id/toolbar_title")
	public static WebElement  toolbar_title;
	
	@FindBy(id="com.isport.fastrack:id/pair_textview")
	public static WebElement  pair_textview;
	@FindBy(id="com.isport.fastrack:id/band_icon")
	public static WebElement  band_icon;
	
	@FindBy(id="com.isport.fastrack:id/next")
	public static WebElement  next;
	
	
	
	void UI_Pairingscreen()
		
	{
		toolbar_title.isDisplayed();
		assertEquals(toolbar_title.getText(), "Your Band was not recognized");
		band_icon.isDisplayed();
		next.isDisplayed();
		
	}
	void click_next()
	{
		explicitywait(next, 50);
		next.click();
	}
	
	
}
