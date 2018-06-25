package Scenario_Component;

import org.testng.Assert;

import PageObject_Component.PageObject_OTP;
import PageObject_Component.PageObject_setupprofile;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Component.Base_class;

public class Scenario_setupprofile extends Base_class {
	
	
	
	
	
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
	
	@Test(priority=20)
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
	void signup_success_last()
	{
		PageObject_setupprofile obj3=new PageObject_setupprofile(androidDriver);
		obj3.signup_done();
	}
	
		
}
