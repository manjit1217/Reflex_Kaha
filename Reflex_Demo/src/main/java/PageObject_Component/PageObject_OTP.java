package PageObject_Component;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.Base_class;
import io.appium.java_client.AppiumDriver;
public class PageObject_OTP extends Base_class {
	
	
	
	
	public PageObject_OTP (AppiumDriver androidDriver)
	{
		PageFactory.initElements(androidDriver, this);
		
	}
	
	@FindBy(id="com.isport.fastrack:id/phone_verification_submit")
	public static WebElement phone_verification_submit;
	
	@FindBy(id="com.isport.fastrack:id/phone_valid_tool_bar")
	public static WebElement phone_valid_tool_bar;
	
	//imageViewOne.getDrawable() == null
	
	@FindBy(id="com.isport.fastrack:id/verify_phone_title")
	public static WebElement verify_phone_title;
	
	//@FindBy(id="com.isport.fastrack:id/phone_verify_desc")
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	public static WebElement phone_verify_desc;
	@FindBy(id="com.isport.fastrack:id/phone_verify_code")
	public static WebElement phone_verify_code;
	
	
	@FindBy(id="com.isport.fastrack:id/phone_verify_timer")
	public static WebElement phone_verify_timer;
	
	
	
	@FindBy(id="com.isport.fastrack:id/phone_verify_resend_otp_description")
	public static WebElement resend_otp_description;
	
	@FindBy(id="com.isport.fastrack:id/phone_verification_resend_otp_button")
	public static WebElement verification_resend_otp_button;
	
	@FindBy(id="com.isport.fastrack:id/ok_button")
	public static WebElement ok_button;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/"
			+ "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
			+ "android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ListView"
			+ "/android.widget.LinearLayout[1]")
	public static WebElement Band1;
	
	@FindBy(id="com.isport.fastrack:id/next")
	public static WebElement next;
	
	@FindBy(id="com.isport.fastrack:id/dialog_yes_button")
	public static WebElement dialog_yes_profile;
	
	@FindBy(id="com.isport.fastrack:id/dialog_no_button")
	public static WebElement dialog_no_profile;
	
	@FindBy(id="com.isport.fastrack:id/dialog_message_tv")
	public static WebElement dialog_message_tv;
	
	@FindBy(id="android:id/button1")
	public static WebElement remove_profile;
	
	
	
public static void phone_verification_submit() 
	
	{
		
		explicitywait(phone_verification_submit, 30);
		phone_verification_submit.click();
	}



public static void ok_button() 

{
	explicitywait(ok_button, 50);
	ok_button.click();
}
public static void Band1() 

{
	Band1.click();
}
public static void next() 

{
	PageObject_OTP obj = new PageObject_OTP(androidDriver);
	//explicitywait(PageObject_OTP.next, 50);
	//next.click();
	for(int i=0;i<4;i++)
	{
		explicitywait(next, 100);
		
		if(next.isDisplayed() && next.getText() != null)
		{
			next.click();
			System.out.println("clicked one");
			
		}
		else {
			break;
		}
		
	}
	
	
	/*else {
		return;
	}*/
	
}

public String verify_phone_title()
{
	String s = verify_phone_title.getText();
	System.out.println(s);
	return s;
}

public static void delete_profile()
{
	explicitywait(dialog_no_profile, 50);
	dialog_no_profile.click();
	explicitywait(remove_profile, 50);
	remove_profile.click();
}

public void verify_resend_desc()
{
	explicitywait(resend_otp_description, 100);
	String Text=resend_otp_description.getText();
}


public static void check_existing_profile()
{
	
	String text=dialog_message_tv.getText();
	if(text.contains("already registered"))
	{
		delete_profile();
	}
	
}

}
