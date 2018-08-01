package PageObject_Component;

import static org.testng.Assert.assertEquals;

import org.ghost4j.GhostscriptLibrary.stderr_fn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

//Football
	@FindBy(id="com.isport.fastrack:id/item_title")
	public static WebElement football_title;
	
	
	//

	
	@FindBy(id="com.isport.fastrack:id/item_desc")
	public static WebElement football_desc;
	
	@FindBy(id="com.isport.fastrack:id/item_icon_iv")
	public static WebElement football_icon;
	
//Fastlane
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
			+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout"
			+ "/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]"
			+ "/android.widget.RelativeLayout/android.widget.ImageView\r\n" + 
			"")
	public static WebElement fastlane_icon;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
			+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout"
			+ "/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]"
			+ "/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]\r\n" + 
			"")
	public static WebElement fastlane_title;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
			+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout"
			+ "/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]"
			+ "/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]\r\n" + 
			"")
	public static WebElement fastlane_desc;
	
	//MyAchivement
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
			+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout"
			+ "/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]"
			+ "/android.widget.RelativeLayout/android.widget.ImageView\r\n" + 
			"")
	public static WebElement MyAchivement_icon;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
			+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout"
			+ "/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]"
			+ "/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView\r\n" + 
			"")
	public static WebElement MyAchivement_title;
	
		
//Fitness buddies
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
			+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout"
			+ "/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]"
			+ "/android.widget.RelativeLayout/android.widget.ImageView\r\n" + 
			"")
	public static WebElement fitnessbuddies_icon;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
			+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout"
			+ "/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]"
			+ "/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView\r\n" + 
			"")
	public static WebElement fitnessbuddies_title;
	
	

	
	
	public void All_UI_dashboard()
	{
		toolbar_image_fasttracklogo.isDisplayed();
		dashboard_BT.isDisplayed();
		share_iv.isDisplayed();
		fit_connect_google.isDisplayed();
		goal_percentage_steps.isDisplayed();
		fitness_progress_bar.isDisplayed();
		calories.isDisplayed();
		distance.isDisplayed();
		
		
	}
		
	public void dashboard_BT()
	{
		explicitywait(dashboard_BT, 50);
		dashboard_BT.isDisplayed();
		dashboard_BT.click();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("Are you sure want to disconnect?", BT_MSg.getText());
		BT_connect_confirm.isDisplayed();
		BT_connect_cancel.isDisplayed();
		BT_connect_cancel.click();
		football_icon.isDisplayed();
		soft.assertEquals(football_title.getText(), "");
		soft.assertEquals(fastlane_title.getText(), "Fastlane");
		soft.assertEquals(fastlane_desc.getText(), "Last Updated","Fastlane desc is wrong");
		MyAchivement_icon.isDisplayed();
		soft.assertEquals(MyAchivement_title.getText(), "My Achivements");
		
		soft.assertAll();
		
	}
	
	public static void step_cal_km()
	{
		String step = steps.getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("1306 Steps", step);
		String cal = calories.getText();
		soft.assertEquals("129 Cal", cal);
		String Km = distance.getText();
		soft.assertEquals("0.91 km", Km);
		soft.assertAll();
	}
	
	
	
	
	
}
