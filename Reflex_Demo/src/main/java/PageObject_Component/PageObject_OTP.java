package PageObject_Component;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_class;
import Generic_Component.Screenshoot_Class;
import io.appium.java_client.AppiumDriver;
import net.sourceforge.tess4j.TesseractException;
public class PageObject_OTP extends Base_class {
	
	
	
	
	public PageObject_OTP (AppiumDriver androidDriver)
	{
		PageFactory.initElements(androidDriver, this);
		
	}
	
	@FindBy(id="com.isport.fastrack:id/phone_verification_submit")
	public static WebElement phone_verification_submit;
	
	@FindBy(id="com.isport.fastrack:id/phone_valid_tool_bar")
	public static WebElement phone_valid_tool_bar_OTP;
	
	//imageViewOne.getDrawable() == null
	
	@FindBy(id="com.isport.fastrack:id/verify_phone_title")
	public static WebElement verify_phone_title;
	
	@FindBy(id="com.isport.fastrack:id/mobile_icon")
	public WebElement mobile_icon_OTP;
	
	
	//@FindBy(id="com.isport.fastrack:id/phone_verify_desc")
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	public static WebElement phone_verify_desc;
	@FindBy(id="com.isport.fastrack:id/phone_verify_code")
	public static WebElement phone_verify_code;
	
	
	@FindBy(id="com.isport.fastrack:id/phone_verify_timer")
	public static WebElement phone_verify_timer;
	
	
	@FindBy(id="com.isport.fastrack:id/mobile_icon")
	public static WebElement mobile_icon;
	
	
	@FindBy(id="com.isport.fastrack:id/phone_verify_resend_otp_description")
	public static WebElement resend_otp_description;
	
	
	@FindBy(id="com.isport.fastrack:id/phone_verification_resend_otp_button")
	public static WebElement verification_resend_otp_button;
	
	@FindBy(id="com.isport.fastrack:id/ok_button")
	public WebElement ok_button;
	
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout"
			+ "/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout\r\n" + 
			"")
	public static WebElement Band1;
	
	@FindBy(id="com.isport.fastrack:id/list_view")
	public static String Band_list;
	
	@FindBy(id="com.isport.fastrack:id/list_view")
	public static WebElement FastBand_list;
	
	@FindBy(id="com.isport.fastrack:id/next")
	public static WebElement next;
	
	@FindBy(id="com.isport.fastrack:id/dialog_yes_button")
	public static WebElement dialog_yes_profile;
	
	@FindBy(id="com.isport.fastrack:id/dialog_no_button")
	public static WebElement dialog_no_profile;
	
	@FindBy(id="com.isport.fastrack:id/existing_user_dialog_user_pic_iv")
	public static WebElement existing_user_dialog_user_pic;
	@FindBy(id="com.isport.fastrack:id/dialog_message_tv")
	public static WebElement dialog_message_tv;
	
	@FindBy(id="com.isport.fastrack:id/bandDisplayImage")
	public static WebElement banddisplayimage;
	
	@FindBy(id="com.isport.fastrack:id/toolbar_title")
	public WebElement toolbar_title_bandlist;
	@FindBy(id="com.isport.fastrack:id/pair_image_container")
	public WebElement pair_image_container;
	@FindBy(id="com.isport.fastrack:id/btn_scan")
	public WebElement Refresh_scan;
	@FindBy(id="android:id/button1")
	public static WebElement remove_profile;
	
	//band Pair screen
	
	@FindBy(id="com.isport.fastrack:id/toolbar_title")
	public WebElement toolbar_title_pair;
	
	@FindBy(id="com.isport.fastrack:id/pair_textview")
	public WebElement pair_textview;
	@FindBy(id="com.isport.fastrack:id/band_icon")
	public WebElement band_icon;
		
	public void Verify_OTP_UI()
	{
		
		phone_valid_tool_bar_OTP.isDisplayed();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals("Verify your phone number", verify_phone_title.getText());
		mobile_icon_OTP.isDisplayed();
		soft.assertEquals("A verification code (OTP) has been sent to your number via SMS.Please "
				+ "enter the OTP to verify your phone number.", phone_verify_desc.getText(),"OTP_DESc is wrong");
		soft.assertEquals("Enter OTP", phone_verify_code.getText());
		soft.assertEquals("Waiting for SMS Code 58 seconds", phone_verify_timer.getText(),"Timer desc is wrong");
		phone_verification_submit.isDisplayed();
		explicitywait(verification_resend_otp_button, 60);
		soft.assertEquals("Verification code not received in 60 seconds", phone_verify_timer.getText(),"Timer desc is wrong");
		soft.assertEquals("Did not receive the OTP ?",resend_otp_description,"resend OTP desc is wrong");
		verification_resend_otp_button.isDisplayed();
		soft.assertAll();
	}
	public void BlankOTP() throws TesseractException
	{
		phone_verification_submit.click();
		String s=Screenshoot_Class.readToastMessage();
		assertTrue(s.contains("Please enter a valid OTP "), "Enter a valid otp message is not coming"+s);
	}
	public void verify_retry_button_Success() throws InterruptedException
	{
		PageObject_phonenumber obj=new PageObject_phonenumber(androidDriver);
		verification_resend_otp_button.click();
		PageObject_phonenumber.checkbox_term();
		PageObject_phonenumber.valid_submit_btn();
		PageObject_phonenumber.dialog_yes_button();
		System.out.println("Enter OTP");
		Thread.sleep(3000);
		phone_verify_code.sendKeys("912808");
		phone_verification_submit.click();
		
		/*String x= phone_verify_code.getText();
		boolean y=x.matches(".*\\d+.*");
		
		if(x.matches(".*\\d+.*"))
		{
			phone_verification_submit.click();
		}*/
}
	
	public void existing_profile_popup_UI()
	{
		existing_user_dialog_user_pic.isDisplayed();
		assertEquals("The number +917735912808 is already registered in the name of sweta. Use this profile? ", dialog_message_tv.getText(),"Exiting profile popup message");
		dialog_yes_profile.isDisplayed();
		dialog_no_profile.isDisplayed();
	}
	
//	String text=dialog_message_tv.getText();
	/*
	public void delete_existing_profile()
	{
		if(text.contains("already registered"))
		{
			explicitywait(dialog_no_profile, 50);
			dialog_no_profile.click();
			explicitywait(remove_profile, 50);
			remove_profile.click();
		}
	}*/
	
	public void band_turned_on_UI()
	{
		//please add to very the above desc
		banddisplayimage.isDisplayed();
		ok_button.isDisplayed();
		
	}
	public void band_list_screen_UI()
	{
		explicitywait(Band1, 50);
		toolbar_title_bandlist.isDisplayed();
		pair_image_container.isDisplayed();
		Refresh_scan.isDisplayed();
		Refresh_scan.click();
		explicitywait(Band1, 50);
	}
	public void Band_pair_screen()
	{
		explicitywait(next, 50);
		toolbar_title_pair.isDisplayed();
		assertEquals(pair_textview.getText(), "Your Band is successfully paired","Failed in next screen");
		band_icon.isDisplayed();
		next.isDisplayed();
		explicitywait(next, 50);
		next.click();
		
	}
	 
	public void Band_pair_failed_screen()
	{
		explicitywait(next, 50);
		toolbar_title_pair.isDisplayed();
		assertEquals(pair_textview.getText(), "Your Band was not recognized","Failed in Retry screen");
		band_icon.isDisplayed();
		next.isDisplayed();
	}
	public static void next_btn() 

	{
		//PageObject_OTP obj = new PageObject_OTP(androidDriver);
		explicitywait(next, 50);
	//	next.click();
		for(int i=0;i<4;i++)
		{
			explicitywait(next, 50);
			
			if(next.isDisplayed())
			{
				next.click();
				System.out.println("clicked one");
				
			}
			else {
				break;
			}
		}
			
		}

	
	
	
	public void First_Time_login_movetosetup()
	{
	//	delete_existing_profile();
		ok_button.click();
		
	}

	
	
/*public static void phone_verification_submit() 
	
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
	explicitywait(PageObject_OTP.next, 50);
	next.click();
	for(int i=0;i<4;i++)
	{
		explicitywait(next, 50);
		
		if(next.isDisplayed())
		{
			next.click();
			System.out.println("clicked one");
			
		}
		else {
			break;
		}
		
	}
	
	
	else {
		return;
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


static String text=dialog_message_tv.getText();
public static void check_existing_profile_UI()
{
	existing_user_dialog_user_pic.isDisplayed();
	
	assertEquals(text, "The number +917735912808 is already registered in the name of sweta. Use this profile? ", "PHone no desc is wrong.");
	dialog_no_profile.isDisplayed();
	dialog_yes_profile.isDisplayed();
	
	
}
public static void delete_existing_profile()
{
	if(text.contains("already registered"))
	{
		delete_profile();
	}
}

public static void UI_OTP()
{
	phone_valid_tool_bar_OTP.isDisplayed();
	assertEquals(verify_phone_title.getText(), "Verify your phone number", "OTP phone title is wrong.");
	mobile_icon.isEnabled();
	assertEquals(phone_verify_desc.getText(), "assertEquals(verify_phone_title.getText(), \"Verify your phone number\", \"OTP phone title is wrong.\");", "Desc is wrong.");
	phone_verify_code.isDisplayed();

}*/

}
