package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Component.Base_class;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageObject_phonenumber extends Base_class {

//	public AppiumDriver driver;
	
	
	public PageObject_phonenumber (AppiumDriver androidDriver)
	{
		System.out.println("constructor run");
		//this.androidDriver=androidDriver;
		PageFactory.initElements(androidDriver, this);
	}

	@FindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public static WebElement permission_allow;
	
	@FindBy(id="com.android.packageinstaller:id/permission_deny_button")
	public static WebElement permission_deny;
	
	
	@FindBy(id="com.isport.fastrack:id/country_flag")
	public static WebElement country_flag;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/"
			+ "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TwoLineListItem[1]")
	public static WebElement country_India;
	
	
	@FindBy(id="com.isport.fastrack:id/phone_valid_editText")
	public static WebElement phone_valid;
	
	@FindBy(id="com.isport.fastrack:id/phone_valid_description")
	public static WebElement phone_valid_description;
	
	@FindBy(id="com.isport.fastrack:id/checkbox_terms")
	public static WebElement checkbox_terms;
	
	@FindBy(id="com.isport.fastrack:id/terms_textview")
	public static WebElement term_condsn;
	
	
	
	@FindBy(className="android.widget.ImageButton")
	public static WebElement term_back_btn;
	
	@FindBy(id="com.isport.fastrack:id/phone_valid_submit")
	public static WebElement valid_submit_btn;
	
	@FindBy(id="com.isport.fastrack:id/dialog_message_tv")
	public WebElement dialog_message_tv;
	
	@FindBy(id="com.isport.fastrack:id/dialog_yes_button")
	public static WebElement dialog_yes_button;
	

	
	
	@FindBy(id="android:id/button1")
	public WebElement remove_profile;
	
	
	
	
	
	
	/* public PageObject_phonenumber() {
	        PageFactory.initElements(driver, this);
	    }*/
	public void permission_allow(String Yes)
	{
		explicitywait(permission_allow, 50);
		try {
			
		if(Yes=="allow")
		for(int i=0;i<5;i++)
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
	
	public static void country_btn()
	{
		country_flag.click();
	}
	public static void country_India()
	{
		country_India.click();
	}
	public static void phoneno_field(String no)
	{
		phone_valid.sendKeys(no);
		//androidDriver.hideKeyboard();
	}
	
	public static void checkbox_term()
	{
		checkbox_terms.click();
	}
	public static void terms_textview()
	{
		
		term_condsn.getText();
		term_condsn.click();
	}
	public static void term_back_btn()
	{
		term_back_btn.click();
	}
	
	public static void valid_submit_btn()
	{
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
	}
	

	
	
}
