/*package Scenario_Component;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Generic_Component.Base_class;
import PageObject_Component.PageObject_Dashboard;

public class Scenario_Dashboard extends Base_class {

	
	@Test
	public void dashboardscreen() throws MalformedURLException, InterruptedException
	{
		startServer();
		specificscreen();
	}
	
	
	@Test(priority=24)
	public void logo()
	{
		PageObject_Dashboard obj1=new PageObject_Dashboard(androidDriver);
		
		PageObject_Dashboard.logo();
	}
	
	@Test(priority=25)
	public void dashboard_BT()
	{
		//PageObject_Dashboard obj1=new PageObject_Dashboard(androidDriver);
		PageObject_Dashboard.dashboard_BT();
	}
	@Test(priority=26)
	public void steps_cal_km()
	{
		//PageObject_Dashboard obj1=new PageObject_Dashboard(androidDriver);
		PageObject_Dashboard.step_cal_km();
	}
}
*/