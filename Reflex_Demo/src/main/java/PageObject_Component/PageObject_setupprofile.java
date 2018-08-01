package PageObject_Component;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_class;
import Generic_Component.Log4j;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class PageObject_setupprofile extends Base_class {

	public PageObject_setupprofile (AppiumDriver androidDriver)
	{
		PageFactory.initElements(androidDriver, this);
	}
	
	@FindBy(id="com.isport.fastrack:id/toolbar_title")
	public WebElement signup_tollobar_title;
	
	@FindBy(id="com.isport.fastrack:id/save")
	public WebElement signup_save_btn;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public WebElement profile_back;
	
	@FindBy(id="com.isport.fastrack:id/sign_in_camera")
	public WebElement Signup_profile_pic;
	
	@FindBy(id="com.isport.fastrack:id/edit_image")
	public WebElement Signup_camera;
	
	@FindBy(id="android:id/alertTitle")
	public WebElement addphoto_title;
	
	@FindBy(id="android:id/text1")
	public WebElement takephoto;
	
	@FindBy(id="com.motorola.camera:id/review_approve")
	public WebElement right_afterphoot;
	
	@FindBy(id="com.isport.fastrack:id/crop_image_menu_crop")
	public WebElement crop_image;
	
	
	
	@FindBy(id="android:id/select_dialog_listview")
	public WebElement select_dialog_listview;
	
	
//Name UI
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
			+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout"
			+ "/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView"
			+ "/android.widget.LinearLayout/TextInputLayout[1]\r\n" + 
			"")
	public WebElement Name_field;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
			+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout"
			+ "/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView"
			+ "/android.widget.LinearLayout/TextInputLayout[2]\r\n" + 
			"")
	public WebElement Email_Field;
	
	@FindBy(id="com.isport.fastrack:id/gender_title")
	public WebElement gender_title;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout"
			+ "/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView"
			+ "/android.widget.LinearLayout/TextInputLayout[3]\r\n" + 
			"")
	public WebElement DOB_field;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout"
			+ "/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView"
			+ "/android.widget.LinearLayout/TextInputLayout[4]\r\n" + 
			"")
	public WebElement height_field;
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
			+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout"
			+ "/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView"
			+ "/android.widget.LinearLayout/TextInputLayout[5]\r\n" + 
			"")
	public WebElement weight_field;
	
	
	@FindBy(id="com.isport.fastrack:id/sign_up_name")
	public static WebElement sign_up_name;
	
	@FindBy(id="com.isport.fastrack:id/sign_up_email")
	public static WebElement sign_up_email;
	
	
	@FindBy(id="com.isport.fastrack:id/gender_male_iv")
	public WebElement gender_male;
	
	@FindBy(id="com.isport.fastrack:id/gender_female_iv")
	public WebElement gender_female;
	
	@FindBy(id="com.isport.fastrack:id/ok_button")
	public WebElement ok_button;

	@FindBy(id="com.isport.fastrack:id/user_age")
	public WebElement user_age;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"01 July 2018\"]")
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
	@FindBy(id="com.isport.fastrack:id/save_button")
	public static WebElement height_weight_save;
	@FindBy(id="com.isport.fastrack:id/user_weight")
	public WebElement user_weight;
	
	
	
	
	
	
	public void Signup_profile_UI()
	{
		signup_tollobar_title.isDisplayed();
		assertEquals(signup_tollobar_title.getText(), "PROFILE");
		Signup_profile_pic.isDisplayed();
		Signup_camera.isDisplayed();
		profile_back.isDisplayed();
		signup_save_btn.isDisplayed();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(Name_field.getText(), "NAME");
		soft.assertEquals(Email_Field.getText(), "EMAIL");
		soft.assertEquals(DOB_field.getText(), "DATE OF BIRTH");
		scrollDown();
		soft.assertEquals(height_field.getText(), "HEIGHT");
		soft.assertEquals(weight_field.getText(), "WEIGHT");
		scrollup();
		soft.assertAll();
		
	}

	public void addphotolist()
	{
		
		Signup_camera.click();
		explicitywait(addphoto_title, 50);
				//WebElement ulElement = driver.findElement(By.className("android.widget.ListView"));
	    List listOfPlayers = driver.findElements(By.id("android:id/select_dialog_listview"));
	   // String x = listOfPlayers.get(0).getText();
		//List<MobileElement> camera_list = androidDriver.findElements(By.className("android.widget.ListView"));
		System.out.println(listOfPlayers);
		System.out.println("hello");
		
		
	}
	
	/*public void signup_camera_Addphoto_UI()

	{
		Signup_profile_pic.click();
		explicitywait(select_dialog_listview, 60);
		Log4j.info(camera_list.get(0).getText());
		Signup_profile_pic.isDisplayed();
		Signup_profile_pic.click();
		//explicitywait(select_dialog_listview, 50);
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(addphoto_title.getText(),"Add Photo!","Title of the Camre is not correct."); 
		// List<WebElement> list = androidDriver.findElements(By.id(select_dialog_listview));
		 soft.assertEquals(camera_list.get(0).getText(), "Take Photo");
		 soft.assertEquals(camera_list.get(1).getText(), "Choose from Library");
		 soft.assertEquals(camera_list.get(2).getText(), "Cancel");
	}*/
	
	public void Profile_camera_take_PIC()
	{
		//explicitywait(sign_in_camera, 50);
		Signup_profile_pic.click();
		takephoto.click();
		touch_action(52, 50);
		explicitywait(right_afterphoot, 50);
		right_afterphoot.click();
		explicitywait(crop_image, 50);
		crop_image.click();
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
		if(x=="male")
		{
			gender_male.click();
		}
		else
		{
			gender_female.click();
		}
	}
	
	public void dob()
	{
		user_age.click();
		DOB.click();
		ok_btn.click();
		System.out.println("dob");
		
	}
	
	public void hight_weight()
	{
		user_height.click();
		height_weight_save.click();
		user_weight.click();
		height_weight_save.click();

	}
	public void touch()
	{
		TouchActions action = new TouchActions(androidDriver);
		action.scroll(profilescroll, 10, 100);
		action.perform();
	}
	
	public void signup_done()
	{
		explicitywait(signup_save_btn, 50);
		signup_save_btn.click();
		
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
		Profile_camera_take_PIC();
		explicitywait(signup_save_btn, 40);
		sign_up_name("Manjit");
		hidekeyboard();
		sign_up_email("Manjit.1217@gmail.com");
		hidekeyboard();
		selectgender("Female");
		dob();
		scrollDown();
		hight_weight();
		signup_save_btn.click();
		
	}
	
	
}

