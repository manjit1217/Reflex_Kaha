package PageObject_Component;

import static org.testng.Assert.assertEquals;

import org.ghost4j.GhostscriptLibrary.stderr_fn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Generic_Component.Base_class;
import io.appium.java_client.AppiumDriver;

public class PageObject_Dashboard extends Base_class{
	
	

	
	public PageObject_Dashboard (AppiumDriver androidDriver)
	
	{
		PageFactory.initElements(androidDriver, this);
	}
	
	@FindBy(id="com.isport.fastrack:id/goal_percentage")
	public static WebElement goal_percentage;
	
	@FindBy(id="com.isport.fastrack:id/dashboard_enable_bt")
	public static WebElement dashboard_BT;
	
	@FindBy(id="com.isport.fastrack:id/msg")
	public static WebElement BT_MSg;
	@FindBy(id="com.isport.fastrack:id/confirm")
	public static WebElement BT_connect_confirm;
	@FindBy(id="com.isport.fastrack:id/cancel")
	public static WebElement BT_connect_cancel;
	
	@FindBy(id="com.isport.fastrack:id/goal_percentage")
	public static WebElement goal_percentage_steps;
	
	
	@FindBy(id="com.isport.fastrack:id/goal_text_view")
	public static WebElement goal_text_view;
	
	@FindBy(id="com.isport.fastrack:id/share_iv")
	public static WebElement share_iv;
	
	@FindBy(id="com.isport.fastrack:id/toolbar_image")
	public static WebElement toolbar_image_fasttracklogo;
	
	@FindBy(id="com.isport.fastrack:id/fitness_progress_bar")
	public static WebElement fitness_progress_bar;
	
	
	@FindBy(id="com.isport.fastrack:id/fit_connect")
	public static WebElement fit_connect_google;
	
	@FindBy(id="com.isport.fastrack:id/calories")
	public static WebElement calories;

	@FindBy(id="com.isport.fastrack:id/steps")
	public static WebElement steps;
	
	@FindBy(id="com.isport.fastrack:id/distance")
	public static WebElement distance;


	
	public static void All_UI_dashboard()
	{
		toolbar_image_fasttracklogo.isDisplayed();
		dashboard_BT.isDisplayed();
		share_iv.isDisplayed();
		fit_connect_google.isDisplayed();
		goal_percentage_steps.isDisplayed();
		fitness_progress_bar.isEnabled();
		
		
		
	}
	
	

	
	public static void dashboard_BT()
	{
		explicitywait(dashboard_BT, 50);
		dashboard_BT.isDisplayed();
		
	/*	assertEquals("Are you sure want to disconnect?", BT_MSg.getText());
		BT_connect_confirm.isDisplayed();
		BT_connect_cancel.isDisplayed();
		BT_connect_cancel.click();*/
	}
	
	public static void step_cal_km()
	{
		String step = steps.getText();
		assertEquals("1306 Steps", step);
		String cal = calories.getText();
		assertEquals("129 Cal", cal);
		String Km = distance.getText();
		assertEquals("0.91 km", Km);
	}
	
	
	
	
	
}
