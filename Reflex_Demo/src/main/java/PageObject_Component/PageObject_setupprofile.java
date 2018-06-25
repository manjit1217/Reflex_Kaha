package PageObject_Component;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.Base_class;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class PageObject_setupprofile extends Base_class {

	public PageObject_setupprofile (AppiumDriver androidDriver)
	{
		PageFactory.initElements(androidDriver, this);
	}
	
	@FindBy(id="com.isport.fastrack:id/sign_up_name")
	public static WebElement sign_up_name;
	
	@FindBy(id="com.isport.fastrack:id/sign_up_email")
	public static WebElement sign_up_email;
	
	@FindBy(id="com.isport.fastrack:id/user_gender")
	public WebElement user_gender;
	
	@FindBy(id="com.isport.fastrack:id/right_hand_tv")
	public WebElement right_hand_tv;
	
	@FindBy(id="com.isport.fastrack:id/left_hand_tv")
	public WebElement left_hand_tv;
	
	@FindBy(id="com.isport.fastrack:id/ok_button")
	public WebElement ok_button;

	@FindBy(id="com.isport.fastrack:id/user_age")
	public WebElement user_age;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"03 June 2018\"]")
	public WebElement DOB;
	@FindBy(id="android:id/button1")
	public WebElement ok_btn;
	/*@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
			+ "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/"
			+ "android.widget.RelativeLayout/android.widget.ScrollView")
	
*/	@FindBy(className="android.widget.ScrollView")
	public WebElement profilescroll;
	
	@FindBy(id="com.isport.fastrack:id/user_height")
	public static WebElement user_height;
	@FindBy(id="com.isport.fastrack:id/user_weight")
	public WebElement user_weight;
	
	
	
	@FindBy(id="com.isport.fastrack:id/sign_up_button")
	public WebElement sign_up_button;
	
	@FindBy(id="com.isport.fastrack:id/sign_in_camera")
	public WebElement sign_in_camera;
	
	public void DP_Set()
	{
		explicitywait(sign_in_camera, 50);
		sign_in_camera.click();
		
	}
	
	
	public void sign_up_name(String Name)
	{
		explicitywait(sign_up_name, 50);
		sign_up_name.sendKeys(Name);
	}
	public void sign_up_email(String Email)
	{
		sign_up_email.sendKeys(Email);
	}
	
	
	
	public void selectgender(String x)
	{
		user_gender.click();
		explicitywait(right_hand_tv, 50);
		String gender = x;
		user_gender.click();
		explicitywait(right_hand_tv, 10);
		if(gender=="Male")
		right_hand_tv.click();
		else
		{
			left_hand_tv.click();
		}
		ok_button.click();
		
	}
	
	public void dob()
	{
		user_age.click();
		DOB.click();
		ok_btn.click();
		System.out.println("dob");
		
	}
	
	public void hight_weight(String h,String w)
	{
		user_height.sendKeys(h);
		user_weight.sendKeys(w);

	}
	public void touch()
	{
		TouchActions action = new TouchActions(androidDriver);
		action.scroll(profilescroll, 10, 100);
		action.perform();
	}
	
	public void signup_done()
	{
		sign_up_button.click();
		
	}
	
	public void profile_alltextverify()
	{
		String name=sign_up_name.getText();
		if(name == "Manjit")
		{
			
		}
	}
	
	public void input_setup_profile()
	{
		explicitywait(sign_up_button, 40);
		sign_up_name("Manjit");
		androidDriver.hideKeyboard();	
		sign_up_email("Manjit.1217@gmail.com");
		androidDriver.hideKeyboard();
		selectgender("Female");
		dob();
		scrollDown();
		hight_weight("155","50");
		androidDriver.hideKeyboard();
	}
	
	
}

