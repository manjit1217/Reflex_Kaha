package Scenario_Component;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Generic_Component.Base_class;
import Generic_Component.Screenshoot_Class;
import PageObject_Component.PageObject_OTP;
import PageObject_Component.PageObject_phonenumber;
import PageObject_Component.PageObject_setupprofile;
import net.sourceforge.tess4j.TesseractException;

public class Scenario_OTP extends Base_class {
	

	@Test(priority=6)
	void Verify_OTP_UI()
	{
		PageObject_OTP obj_OTP=new PageObject_OTP(androidDriver);
		explicitywait(obj_OTP.phone_verification_submit, 50);
		obj_OTP.Verify_OTP_UI();
	}
	@Test(priority=7)
	void blank_OTP() throws TesseractException
	{
		PageObject_OTP obj_OTP=new PageObject_OTP(androidDriver);

		obj_OTP.BlankOTP();
	}
	@Test(priority=8)
	void verify_retry() throws InterruptedException
	{
		PageObject_OTP obj_OTP=new PageObject_OTP(androidDriver);

		obj_OTP.verify_retry_button_Success();
	}
	@Test(priority=9)
	void band_turned_on_UI()
	{
		PageObject_OTP obj_OTP=new PageObject_OTP(androidDriver);

		obj_OTP.band_turned_on_UI();
		obj_OTP.ok_button.click();
	}
	@Test(priority=10)
	void Verify_Band_listscreen() throws InvocationTargetException
	{
		PageObject_OTP obj_OTP=new PageObject_OTP(androidDriver);
		explicitywait(obj_OTP.Band1, 100);
		obj_OTP.band_list_screen_UI();
		obj_OTP.Band1.click();	
	}
	@Test(priority=11)
	void Verify_Band_cnnected()
	{
		
		PageObject_OTP obj_OTP=new PageObject_OTP(androidDriver);

		obj_OTP.Band_pair_screen();
	}

	
	/*

	@Test(priority=10)
	void tollbar_Image()
	{
		
		explicitywait(PageObject_OTP.phone_valid_tool_bar_OTP, 40);
		if (PageObject_OTP.phone_valid_tool_bar_OTP.isDisplayed()){
		       System.out.println("Logo is displaying");
		       Screenshoot_Class.takeScreenShot();
		   }else{
			   System.out.println("Logo is not avaliable");
		       Screenshoot_Class.takeScreenShot();
		   }
		
	}
	
	@Test(priority=11)
	void verify_phonetitle() throws InterruptedException
	{
		
		explicitywait(PageObject_OTP.verify_phone_title, 50);
		PageObject_OTP obj = new PageObject_OTP(androidDriver) ;
		Thread.sleep(5000);
		String Actual=PageObject_OTP.verify_phone_title.getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual,"Verify your phone number");
		
	}
	@Test(priority=12)
	void phone_verify_desc()
	{
		String Actual="A verification code (OTP) has been sent to your number via SMS.Please enter the OTP to verify your phone number.";
		System.out.println(PageObject_OTP.phone_verify_desc.getText());
		Assert.assertEquals(PageObject_OTP.phone_verify_desc.getText(),Actual);
	}
	@Test(priority=13)
	void phone_verify_code()
	{
		String Expected="Enter OTP";
		Assert.assertEquals(Expected,PageObject_OTP.phone_verify_code.getText());
	 
	}
	
	@Test(priority=14)
	void phone_verify_timer() throws InterruptedException
	{
		String Beforetimeout_Expected="Waiting for SMS Code 60 seconds";
		String Aftertimeout_Expected="Verification code not received in 35 seconds";
		Assert.assertEquals(Beforetimeout_Expected,PageObject_OTP.phone_verify_timer.getText());
		Thread.sleep(60000);
		if(PageObject_OTP.verification_resend_otp_button.isDisplayed())
		{
			Assert.assertEquals(Aftertimeout_Expected,PageObject_OTP.phone_verify_timer.getText());
		}
		
		
		
	 
	}
	@Test(priority=15)
	void ResendOTP_Desc() throws InterruptedException
	{
		explicitywait(PageObject_OTP.verification_resend_otp_button, 60);
		String Expected="Did not receive the OTP ?";
		Assert.assertEquals(Expected,PageObject_OTP.resend_otp_description.getText());
	}
	
	@Test(priority=16)
	void enterOTP_COnnectband()
	{
		PageObject_OTP obj = new PageObject_OTP(androidDriver) ;
		System.out.println("Enter OTP");
		PageObject_OTP.phone_verification_submit();
		PageObject_OTP.ok_button();
		explicitywait(PageObject_OTP.Band1, 50);
		PageObject_OTP.Band1();
		//explicitywait(PageObject_OTP.next, 100);
		PageObject_OTP.next();
	}
	
	@Test(priority=17)
	void setupprofile() throws InterruptedException
	{
		Thread.sleep(5000);
		PageObject_setupprofile obj2 = new PageObject_setupprofile(androidDriver) ;
		obj2.input_setup_profile();
		obj2.signup_done();
		Thread.sleep(3000);
		Screenshoot_Class.takeScreenShot();
		Thread.sleep(2000);
	}
	
	@Test(priority=18)
	void oldno_existingprofile() throws InterruptedException
	{
		clearappdata();
		PageObject_OTP obj = new PageObject_OTP(androidDriver) ;
		String no="7735912808";
		//explicitywait(PageObject_phonenumber.permission_allow, 40);
		Scenario_Phonenumber.Permission();
		PageObject_phonenumber.checkbox_term();
		PageObject_phonenumber.phoneno_field(no);
		PageObject_phonenumber.valid_submit_btn();
		Thread.sleep(1000);
		explicitywait(PageObject_phonenumber.dialog_yes_button, 30);
		PageObject_phonenumber.dialog_yes_button();
		Thread.sleep(60000);
		explicitywait(PageObject_OTP.phone_verification_submit, 50);
		System.out.println("Enter OTP");
		PageObject_OTP.phone_verification_submit();
		explicitywait(PageObject_OTP.dialog_no_profile, 50);
		PageObject_OTP.dialog_no_profile.click();
		explicitywait(PageObject_OTP.remove_profile, 40);
		PageObject_OTP.remove_profile.click();
		Thread.sleep(5000);
		//PageObject_OTP.dialog_yes_profile.click();
		PageObject_OTP.ok_button();
		explicitywait(PageObject_OTP.Band1, 50);
		PageObject_OTP.Band1();
		explicitywait(PageObject_OTP.next, 50);
		PageObject_OTP.next();
		setupprofile();
	}
	
	
	@Test(priority=19)
	void finallogin() throws InterruptedException
	{
		clearappdata();
		PageObject_OTP obj = new PageObject_OTP(androidDriver) ;
		String no="7735912808";
		explicitywait(PageObject_phonenumber.permission_allow, 40);
		Scenario_Phonenumber.Permission();
		PageObject_phonenumber.checkbox_term();
		PageObject_phonenumber.phoneno_field(no);
		PageObject_phonenumber.valid_submit_btn();
		Thread.sleep(1000);
		explicitywait(PageObject_phonenumber.dialog_yes_button, 30);
		PageObject_phonenumber.dialog_yes_button();
		Thread.sleep(60000);
		explicitywait(PageObject_OTP.phone_verification_submit, 50);
		System.out.println("Enter OTP");
		PageObject_OTP.phone_verification_submit();
		explicitywait(PageObject_OTP.dialog_yes_profile, 50);
		PageObject_OTP.dialog_yes_profile.click();
		PageObject_OTP.ok_button();
		explicitywait(PageObject_OTP.Band1, 50);
		PageObject_OTP.Band1();
		explicitywait(PageObject_OTP.next, 50);
		PageObject_OTP.next();
		
	}
	
	
	
	*/
	
	
}

