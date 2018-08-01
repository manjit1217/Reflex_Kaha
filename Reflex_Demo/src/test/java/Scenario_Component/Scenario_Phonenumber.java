package Scenario_Component;

import static org.testng.Assert.assertTrue;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.swing.GroupLayout.ParallelGroup;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_class;
import Generic_Component.Log4j;
import Generic_Component.Screenshoot_Class;
import PageObject_Component.PageObject_OTP;
import PageObject_Component.PageObject_phonenumber;
import PageObject_Component.PageObject_setupprofile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.Logger;


public class Scenario_Phonenumber extends Base_class {

	private static PageObject_phonenumber obj_phoneno; 
	/*private static PageObject_OTP obj_otp;
	private static PageObject_setupprofile obj_setupprofile;
*/	
	//static Logger log= Logger.getLogger(Scenario_Phonenumber.class);
	
		
	@BeforeSuite
	void start() throws ClassNotFoundException, SQLException
	{
		//Database obj = new Database();
		//Database.database();
		
		startServer();
		obj_phoneno = new PageObject_phonenumber(androidDriver) ;
		Log4j.info("SERVER START--log");
		//Log4j.info();
		/*obj_otp=new PageObject_OTP(androidDriver);
		obj_setupprofile=new PageObject_setupprofile(androidDriver);*/
	}
	@BeforeTest
	void initapp() throws InterruptedException, IOException
	{		
		InitApp();
		Log4j.info("Hellooo");
		//specificscreen();
		obj_phoneno = new PageObject_phonenumber(androidDriver) ;
	}
	
	
	@Test(priority=0,groups="PhoneNUmber")
	public void Permission()
	{
		Log4j.info("App Permission");
		obj_phoneno.verify_permission_message();
		obj_phoneno.permission_allow("allow");
	}
	@Test(priority=1,groups="PhoneNUmber")
	public void Phoneno_UI()
	{
		hidekeyboard();
		obj_phoneno.check_phoneno_UI();
	}
	@Test(priority=2,groups="PhoneNUmber")
	public void Phoneno_Toast_Messages() throws TesseractException, InterruptedException
	{		
		obj_phoneno.verify_toastmessages();
	}
	@Test(priority=3,description="Verify the country field")
	public void Verify_Country_UI()
	{
		obj_phoneno.verify_country_UI();
	}
	@Test(priority=4)
	public void Verify_TermPDF()
	{
		obj_phoneno.TermPDF_check();
	}
	
	@Test(priority=5)
	public void Moveto_OTP() throws Exception
	{
		obj_phoneno.Moveto_OTP("7735912808");
		//obj_phoneno.signin_no_validation();
	}
	
	
	
		
/*@Test(enabled=false)
	void countrylist()
	{
		PageObject_phonenumber.country_btn();
		explicitywait(PageObject_phonenumber.country_India, 50);
		PageObject_phonenumber.country_India();
		androidDriver.hideKeyboard();
	}
	
	@Test(priority=2)
	void agreetermconditions()
	{
		String s =PageObject_phonenumber.term_condsn.getText();
		Assert.assertEquals("I agree to the Terms and Conditions ",s);
	}
	
	@Test(priority=3)
	void accept_termandconitions() throws TesseractException, InterruptedException
	{
		PageObject_phonenumber.valid_submit_btn();
		String s=Screenshoot_Class.readToastMessage();
		Thread.sleep(3000);
		assertTrue(s.contains("Please accept the terms and conditions"));
		
	}
	
	
	@Test(priority=5)
	void termPDF()
	{
		PageObject_phonenumber.terms_textview();
		explicitywait(PageObject_phonenumber.term_back_btn, 50);
		PageObject_phonenumber.term_back_btn();
		
	}
	
	@Test(priority=6)
	void phoneno_Blank() throws TesseractException, InterruptedException
	{
		PageObject_phonenumber.checkbox_term();
		PageObject_phonenumber.valid_submit_btn();
		String s=Screenshoot_Class.readToastMessage();
		assertTrue(s.contains("Please enter Valid Phone No"));
		Thread.sleep(5000);
			
	}
	
	@Test(priority=7)
	void phoneno_lessthan10() throws TesseractException, InterruptedException
	{
		String no="889263";
		PageObject_phonenumber.phoneno_field(no);
		PageObject_phonenumber.valid_submit_btn();
		String s=Screenshoot_Class.readToastMessage();
		assertTrue(s.contains("Phone number +91889263 appears to be" + 
				"invalid. Please select a valid number"));
	}
	
	@Test(priority=8)
	void phoneno_morethan10() throws TesseractException
	{
		String no="88926377354";
		PageObject_phonenumber.phoneno_field(no);
		PageObject_phonenumber.valid_submit_btn();
		String s=Screenshoot_Class.readToastMessage();
		assertTrue(s.contains("Enter valid mobile number"));
	}
*/	
		
	/*@Test(priority=9)
	void move_OTP_correwctno() throws InterruptedException, TesseractException
	{
		PageObject_OTP obj = new PageObject_OTP(androidDriver);
		String no="7735912808";
		PageObject_phonenumber.checkbox_term();
		PageObject_phonenumber.phoneno_field(no);
	//	androidDriver.hideKeyboard();
		PageObject_phonenumber.valid_submit_btn();
		//String message = PageObject_phonenumber.dialog_message_tv.getText();
		//Assert.assertEquals("Mobile number entered is +91"+no+". Continue?",message);
		System.out.println("yes");
		PageObject_OTP.delete_existing_profile();
		PageObject_phonenumber.dialog_yes_button();
		System.out.println("clickek on yes");
		Thread.sleep(15000);
		//Thread.sleep(5000);
	}

*/	
	//Scenario_OTP
	
	/*@Test(priority=8)
	void tollbar_Image()
	{
		if (PageObject_OTP.phone_valid_tool_bar.isDisplayed()){
		       System.out.println("Logo is displaying");
		       Screenshoot_Class.takeScreenShot();
		   }else{
			   System.out.println("Logo is not avaliable");
		       Screenshoot_Class.takeScreenShot();
		   }
		
	}
	@Test(priority=9)
	void verify_phonetitle() throws InterruptedException
	{
		PageObject_OTP obj = new PageObject_OTP(androidDriver) ;
	
		Thread.sleep(5000);
		String Actual=obj.verify_phone_title();
		System.out.println(Actual);
		Assert.assertEquals(Actual,"Verify your phone number");
		
	}
	@Test(priority=10)
	void phone_verify_desc()
	{
		String Actual="A verification code (OTP) has been sent to your number via SMS.Please enter the OTP to verify your phone number.";
		System.out.println(PageObject_OTP.phone_verify_desc.getText());
		Assert.assertEquals(PageObject_OTP.phone_verify_desc.getText(),Actual);
	}
	@Test(priority=11)
	void phone_verify_code()
	{
		String Expected="Enter OTP";
		Assert.assertEquals(Expected,PageObject_OTP.phone_verify_code.getText());
	 
	}
	
	@Test(priority=12)
	void phone_verify_timer() throws InterruptedException
	{
		String Beforetimeout_Expected="Waiting for SMS Code 60 seconds";
		String Aftertimeout_Expected="Verification code not received in 60 seconds";
		Assert.assertEquals(Beforetimeout_Expected,PageObject_OTP.phone_verify_timer.getText());
		Thread.sleep(60000);
		
	 
	}
	@Test(priority=13)
	void ResendOTP_Desc()
	{
		explicitywait(PageObject_OTP.resend_otp_description, 50);
		String Expected="Did not receive the OTP ?";
		Assert.assertEquals(Expected,PageObject_OTP.resend_otp_description.getText());
	}
	
	@Test(priority=14)	
	void verification__button()
	{
		String Aftertimeout_Expected="Verification code not received in 60 seconds";		
		
			Assert.assertEquals(Aftertimeout_Expected,PageObject_OTP.phone_verify_timer.getText());
		
	}
		
	*/
	/*
	@Test
	void correctno_newregister() throws InterruptedException, TesseractException
	{
		String no="8892637756";
	//	String BlankOTP
		PageObject_phonenumber.checkbox_term();
		PageObject_phonenumber.phoneno_field(no);
		PageObject_phonenumber.valid_submit_btn();
		explicitywait(PageObject_phonenumber.dialog_yes_button, 30);
		//String message = PageObject_phonenumber.dialog_message_tv.getText();
	//	Assert.assertEquals("Mobile number entered is +91"+no+". Continue?",message);
		PageObject_OTP.phone_verification_submit();
		Thread.sleep(5000);
		//System.out.println("Dont Enter any OTP");
		//PageObject_OTP.phone_verification_submit();
		Screenshoot_Class.readToastMessage();
		//assertTrue(s.contains("Enter valid mobile number"));
		
		
		
		
		
	}
	*/
	/*
	@Test
	public void test() throws MalformedURLException, InterruptedException {
	PageObject_phonenumber obj = new PageObject_phonenumber(androidDriver) ;
	obj.country_btn();
	Thread.sleep(5000);
	
	
	Thread.sleep(5000);
	
	Thread.sleep(5000);
	obj.checkbox_term();
	String s = obj.term_condsn.getText();
	System.out.println(s);
	obj.terms_textview();
	Assert.assertEquals("I agree to the Terms and Conditions ",s);
	explicitywait(PageObject_phonenumber.term_back_btn, 50);
	obj.term_back_btn();
	obj.valid_submit_btn();
	obj.dialog_yes_button();
	//explicitywait(PageObject_phonenumber.valid_submit_btn, 80);
	PageObject_OTP obj1 = new PageObject_OTP(androidDriver) ;
	explicitywait(PageObject_OTP.phone_verification_submit, 50);
	Thread.sleep(5000);
	System.out.println("Enter otp");
	Thread.sleep(5000);
	obj1.phone_verification_submit();
	obj1.ok_button();
	//Thread.sleep(5000);
	explicitywait(PageObject_OTP.Band1, 50);
	obj1.Band1();
	explicitywait(PageObject_OTP.next, 50);
	obj1.next();
	PageObject_setupprofile obj2 = new PageObject_setupprofile(androidDriver) ;
	explicitywait(PageObject_setupprofile.sign_up_name, 10);
	obj2.sign_up_name();
	System.out.println("name entered");
	androidDriver.hideKeyboard();
	explicitywait(PageObject_setupprofile.sign_up_email, 5);
	obj2.sign_up_email();
	androidDriver.hideKeyboard();
	scrollDown();
//obj2.touch();
	obj2.hight_weight("155","50");
	androidDriver.hideKeyboard();
	//obj2.enterkeys();
//	androidDriver.hideKeyboard();
	obj2.selectgender("Male");
//	obj2.user_gender();
//	obj2.right_hand_tv();
	
	obj2.dob();
	
	obj2.signup_done();
	
	//obj.valid_submit_btn();
	//
	
		}
	
	*/
	@AfterTest
	void uninstall()
	{
		//uninstall_app();
	}
	/*@AfterSuite
	void stopserver()
	{
		stopServer();
		
	}
	*/
}

