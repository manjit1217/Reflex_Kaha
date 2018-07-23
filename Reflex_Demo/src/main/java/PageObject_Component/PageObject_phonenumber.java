package PageObject_Component;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_class;
import Generic_Component.Log4j;
import Generic_Component.Screenshoot_Class;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.sourceforge.tess4j.TesseractException;

public class PageObject_phonenumber extends Base_class {

//	public AppiumDriver driver;
	
	
	public PageObject_phonenumber (AppiumDriver androidDriver)
	{
		//System.out.println("constructor run");
		//this.androidDriver=androidDriver;
		PageFactory.initElements(androidDriver, this);
	}

	@FindBy(id="com.isport.fastrack:id/phone_valid_tool_bar")
	public WebElement phone_valid_logo;
	
	
	@FindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public static WebElement permission_allow;
	
	@FindBy(id="com.android.packageinstaller:id/permission_deny_button")
	public static WebElement permission_deny;
	
	
	@FindBy(id="com.isport.fastrack:id/country_flag_layout")
	public static WebElement country_flag;
	
	@FindBy(id="com.isport.fastrack:id/search_src_text")
	public static WebElement search_country;
	
	@FindBy(id="com.isport.fastrack:id/search_mag_icon")
	public static WebElement search_mag_icon;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/"
			+ "android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]")
	public static WebElement country_India;
	
	
	@FindBy(id="com.isport.fastrack:id/phone_valid_editText")
	public static WebElement phone_valid;
	
	@FindBy(id="com.isport.fastrack:id/phone_valid_description")
	public static WebElement phone_valid_description;
	
	@FindBy(id="com.isport.fastrack:id/mobile_icon")
	public static WebElement mobile_icon;
	@FindBy(id="com.isport.fastrack:id/checkbox_terms")
	public static WebElement checkbox_terms;
	
	@FindBy(id="com.isport.fastrack:id/terms_textview")
	public static WebElement term_condsn;
	
	
	
	@FindBy(className="android.widget.ImageButton")
	public static WebElement term_back_btn;
	@FindBy(id="com.isport.fastrack:id/toolbar_title")
	public WebElement pdf_toolbar_title;
	
	@FindBy(id="com.isport.fastrack:id/phone_valid_submit")
	public static WebElement valid_submit_btn;
	
	@FindBy(id="com.isport.fastrack:id/dialog_message_tv")
	public WebElement dialog_message_tv;
	
	@FindBy(id="com.isport.fastrack:id/dialog_yes_button")
	public static WebElement dialog_yes_button;
	
	@FindBy(id="com.isport.fastrack:id/dialog_no_button")
	public WebElement dialog_no_button;
	
	
	@FindBy(id="android:id/button1")
	public WebElement remove_profile;
	
	@FindBy(id="com.android.packageinstaller:id/permission_message")
	public WebElement permission_message;



	
	
	
	
	
	/* public PageObject_phonenumber() {
	        PageFactory.initElements(driver, this);
	    }*/
	public void verify_permission_message(){
		String expected_camera = permission_message.getText();
		String expected_message = permission_message.getText();
		String expected_location = permission_message.getText();
		String expected_media = permission_message.getText();
		String expected_contacts = permission_message.getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals("Allow Reflex to access photos, media, and files on your device?", expected_camera);
		permission_allow.click();
		soft.assertEquals("Allow Reflex to access photos, media, and files on your device?", expected_message);
		permission_allow.click();
		soft.assertEquals("Allow Reflex to access photos, media, and files on your device?", expected_location);
		permission_allow.click();
		soft.assertEquals("Allow Reflex to access photos, media, and files on your device?", expected_media);
		permission_allow.click();
		soft.assertEquals("Allow Reflex to access photos, media, and files on your device?", expected_contacts);
		permission_allow.click();
		soft.assertAll();
	}
	
	public void permission_allow(String Yes)
	{
		explicitywait(permission_allow, 50);
		try {
			
		if(Yes=="allow")
		for(int i=0;i<6;i++)
		{
		permission_allow.click();
		}
		else
		{
			permission_deny.click();
		}
	}
	catch(Exception e) {
		System.out.println("Permission Exception: "+e);
	}
	}
	
	
	public void check_phoneno_UI()
	{
		phone_valid_logo.isDisplayed();
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(phone_valid_description.getText(),"Register with your phone number");
		mobile_icon.isDisplayed();
		country_flag.isDisplayed();
		soft.assertEquals(phone_valid.getText(), "Your phone number");
		checkbox_terms.isSelected();
		soft.assertEquals(term_condsn.getText(), "I agree to the Terms and Conditions ");
		valid_submit_btn.isDisplayed();
		soft.assertAll();
		
	}
	public void verify_toastmessages() throws TesseractException, InterruptedException
	{
		/*accept_tc_errortoast();
		phoneno_Blank_toast();
		phoneno_lessthan10_toast();
		phoneno_morethan10_toast();*/
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(accept_tc_errortoast().contains("Please accept the terms and conditions"),"term is wrong");
		soft.assertTrue(phoneno_Blank_toast().contains("Please enter a valid phone number"),"Phone no Blank error");
		soft.assertTrue(phoneno_lessthan10_toast().contains("Phone number +91889263 appears to be" + 
				"invalid. Please select a valid number"),"phone no less than 10");
		soft.assertTrue(phoneno_morethan10_toast().contains("Please enter a valid phone number"),"more than 10");
		soft.assertAll();
	}
	String accept_tc_errortoast() throws TesseractException, InterruptedException
	{
		
		PageObject_phonenumber.valid_submit_btn();
		String s=Screenshoot_Class.readToastMessage();
		Thread.sleep(3000);
		assertTrue(s.contains("Please accept the terms and conditions"),s);
		return s;
		
	}
	String phoneno_Blank_toast() throws TesseractException, InterruptedException
	{
		checkbox_terms.click();
		PageObject_phonenumber.valid_submit_btn();
		String s=Screenshoot_Class.readToastMessage();
		Thread.sleep(5000);
		return s;
			
	}
	String phoneno_lessthan10_toast() throws TesseractException, InterruptedException
	{
		String no="889263";
		PageObject_phonenumber.phoneno_field(no);
		PageObject_phonenumber.valid_submit_btn();
		String s=Screenshoot_Class.readToastMessage();
		return s;
		
		
	
	}
	String phoneno_morethan10_toast() throws TesseractException
	{
		String no="88926377354";
		PageObject_phonenumber.phoneno_field(no);
		PageObject_phonenumber.valid_submit_btn();
		String s=Screenshoot_Class.readToastMessage();
		return s;
		
	}
	
	
	public void verify_country_UI()
	{
		SoftAssert soft = new SoftAssert();
		country_flag.click();
		androidDriver.hideKeyboard();
		search_country.isDisplayed();
		soft.assertEquals(search_country.getText(), "Search Country", "Search country is wrong");
		search_mag_icon.isDisplayed();
		select_country();
				
	}
	public static void select_country()
	{
	//	country_flag.click();
		explicitywait(country_India, 50);
		
		country_India.click();
		//List<WebElement> elements = (List<WebElement>) androidDriver.findElementById("com.isport.fastrack:id/countryList");
		//List<AndroidElement> profile = driver.findElements(MobileBy.id("com.isport.fastrack:id/countryList"));
	
		
	}
	public void TermPDF_check()
	{
		term_condsn.click();
		explicitywait(term_back_btn, 50);
		assertEquals("REFLEX",pdf_toolbar_title.getText(),"T&C Title is wrong");
		term_back_btn.click();
	}
	public void Moveto_OTP(String no)
	{
		
		phoneno_field(no);
		//gfhg
		//valid_submit_btn();
		//checkbox_term();//need to remove
		//checkbox_term();
		String x = checkbox_terms.getAttribute("checked");
		
		System.out.println(x);
		if(x.contains("t"))
		{
		//	System.out.println("Checked");
		valid_submit_btn();
		}
		else {
			System.out.println("not checked");
			checkbox_term();
			valid_submit_btn();
			}
		dialog_yes_button();
		//confirm_no(no);
	}
	public void confirm_no_screen(String no)
	{
		assertEquals("Mobile number entered is +91"+no+". Continue?",dialog_message_tv.getText() );
		dialog_no_button.isDisplayed();
		dialog_yes_button.isDisplayed();
		dialog_no_button.click();
		hidekeyboard();
		valid_submit_btn();
		dialog_yes_button.click();
	}
	
	public static void phoneno_field(String no)
	{
		phone_valid.click();
		phone_valid.sendKeys(no);
		androidDriver.hideKeyboard();
	}
	
	public static void checkbox_term()
	{
		checkbox_terms.click();
	}
	public static void terms_textview()
	{
		
		term_condsn.getText();
		
	}
	public static void term_back_btn()
	{
		term_back_btn.click();
	}
	
	public static void valid_submit_btn()
	{
		explicitywait(valid_submit_btn, 50);
		valid_submit_btn.click();
	}
	
	public void dialog_message_tv()
	{
		String dialog_message = dialog_message_tv.getText();
		
	}
	public static void dialog_yes_button() 
	{
		explicitywait(dialog_yes_button, 50);
		dialog_yes_button.click();
		//Log4j.info("hII");
	}
	public void signin_no_validation() throws InvocationTargetException
	{
		PageObject_OTP obj = new PageObject_OTP(androidDriver);
		Moveto_OTP("7735912808");
//		dialog_yes_button();
		hidekeyboard();
		obj.phone_verify_code.sendKeys("912808");
		hidekeyboard();
		obj.phone_verification_submit.click();
		explicitywait(obj.ok_button, 50);
		obj.ok_button.click();
		//obj.Band1.click();
		explicitywait(obj.Band1, 60);
		obj.Band1.click();
		obj.next_btn();
	}
}
