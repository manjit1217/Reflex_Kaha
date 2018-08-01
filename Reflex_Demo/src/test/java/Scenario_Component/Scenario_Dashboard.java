package Scenario_Component;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Generic_Component.Base_class;
import PageObject_Component.PageObject_Dashboard;

public class Scenario_Dashboard extends Base_class {

	
	
	
	@Test(priority=15)
	public void dashboard_UI()
	{
		PageObject_Dashboard obj1=new PageObject_Dashboard(androidDriver);
		obj1.All_UI_dashboard();
	}
	
	@Test(priority=16)
	public void dashboard_BT()
	{
		PageObject_Dashboard obj1=new PageObject_Dashboard(androidDriver);
		obj1.dashboard_BT();
	}
	
	
	@Test(priority=17)
	public void steps_cal_km()
	{
		//PageObject_Dashboard obj1=new PageObject_Dashboard(androidDriver);
		PageObject_Dashboard.step_cal_km();
	}
}
