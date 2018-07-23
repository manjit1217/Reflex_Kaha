package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Priority;
import org.testng.Assert;

import PageObject_Component.PageObject_OTP;
import PageObject_Component.PageObject_phonenumber;
import PageObject_Component.PageObject_setupprofile;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Component.Base_class;
import Generic_Component.Log4j;

public class Scenario_setupprofile extends Base_class {
	
	
	
	/*@BeforeSuite
	void start()
	{
		startServer();
	}
	@BeforeTest
	void initapp() throws InterruptedException, IOException
	{		
	specificscreen();
		
	}*/
	
	
	
	/*@DataProvider
	public Object[][] loginData(){
		Object[][] data = new Object[2][2];
		
		data[0][0]="Manjit";
		data[0][1]="kjasbkdaskdakjhdjka";
		data[0][2]="M";
				
		return data;
	}
	@Test(dataProvider="loginData")
	void verifyname(String Name)
	{
		
		PageObject_setupprofile obj = new PageObject_setupprofile(androidDriver);
	obj.sign_up_name.sendKeys(Name);;
	Assert.assertEquals("Manjit",PageObject_setupprofile.sign_up_name.getText());
		
	}*/
	
	/*@Test(priority=13)
	void Signup_profile_UI() throws InterruptedException
	{
		Thread.sleep(5000);
		explicitywait(PageObject_setupprofile.sign_up_email, 50);
		PageObject_setupprofile obj = new PageObject_setupprofile(androidDriver);
		obj.Signup_profile_UI();
	}*/
	@Test(priority=13)
	void cameraui() {
		//PageObject_setupprofile obj = new PageObject_setupprofile(androidDriver);
		//obj.addphotolist();
	}
	
	/*@Test(priority=14)
	void camera_UI()
	{
		PageObject_setupprofile obj = new PageObject_setupprofile(androidDriver);
	//	obj.signup_camera_Addphoto_UI();
	}*/
	@Test(priority=15)
	void input_setup_profile()
	{
		PageObject_setupprofile obj = new PageObject_setupprofile(androidDriver);
		obj.input_setup_profile();
	}
	
	
	/*@Test(priority=20)
	void verifyname()
	{
	Assert.assertEquals("Manjit",PageObject_setupprofile.sign_up_name.getText());
	}
	@Test(priority=21)
	void verifyemail()
	{
		Assert.assertEquals("Manjit.1217@gmail.com",PageObject_setupprofile.sign_up_email.getText());	
	}
	@Test(priority=22)
	void verifyhight()
	{
		scrollDown();
		Assert.assertEquals("155",PageObject_setupprofile.user_height.getText());	
	}
	@Test(priority=23)
	void signup_success_last() throws InterruptedException
	{
		PageObject_setupprofile obj3=new PageObject_setupprofile(androidDriver);
		obj3.signup_done();
		Thread.sleep(5000);
	}
*/	
		
}
