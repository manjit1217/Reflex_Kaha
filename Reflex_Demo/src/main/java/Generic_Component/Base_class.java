package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject_Component.PageObject_setupprofile;
public class Base_class {

	//public static AppiumDriver<MobileElement> androidDriver;
	public static AppiumDriver androidDriver;
	static DesiredCapabilities capabilities;
	public AppiumDriverLocalService service;
	public AppiumServiceBuilder builder;
	public static AndroidDriver driver;
	

	
	public void startServer() {
		//Set Capabilities
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("noReset", "false");
		
		//Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4727);
		builder.withCapabilities(capabilities);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		
		//Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		System.out.println("Server Started");
		
	}
	
	public static void InitApp() throws MalformedURLException, InterruptedException
	{
		
		URL remote_grid = new URL("http://127.0.0.1:4727/wd/hub");
			
		capabilities.setCapability("platformName","Android");
	    capabilities.setCapability("deviceName","ZY222ZVH7G");
	    //capabilities.setCapability("avd","LKAndroidEmulator");
	    //capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "LKAndroidEmulator");
	    capabilities.setCapability("app","/Users/lenovo/eclipse-workspace/Reflex_Demo/src/APk/base.apk");
	    capabilities.setCapability("newCommandTimeout", 600);
	    capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
		androidDriver = new AndroidDriver<MobileElement>(remote_grid, capabilities);    
		androidDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(5000);
		System.out.println("Install Successfully");
	}
	
	public static void specificscreen() throws MalformedURLException, InterruptedException {
		
		URL remote_grid = new URL("http://127.0.0.1:4727/wd/hub");
		
		//DesiredCapabilities caps = new DesiredCapabilities();
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("deviceName","FA7A51A01792");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("appPackage", "com.isport.fastrack");
		//capabilities.setCapability("appActivity", "com.isport.fastrack.views.acitvities.HomeActivity");
		capabilities.setCapability("appActivity", "clovewearable.commons.phonevalid.ui.PhoneValidationActivity");
		capabilities.setCapability("noReset", "true");
		androidDriver = new AndroidDriver<MobileElement>(remote_grid, capabilities);    
		androidDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println("called");
			
	}
	
	
	public static void relunch()
	{
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("noReset", true);
	}
	public void stopServer() {
		service.stop();
		System.out.println("Appium Server Stop");
	}
 
	
	public void uninstall_app()

		{		
			androidDriver.removeApp("com.isport.fastrack");
			System.out.println("uninstall");
			
		}
		
		
	public static void explicitywait(WebElement ele,long t1) {
		try {
		WebDriverWait wait = new WebDriverWait(androidDriver, t1);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		//System.out.println("Wait");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void scrollToElement(AndroidDriver driver, String elementName, boolean scrollDown) {
        String listID = ((RemoteWebElement) driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ScrollView\")")).getId();
        String direction;
        if (scrollDown) {
            direction = "down";
        } else {
            direction = "up";
        }
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        scrollObject.put("element", listID);
        scrollObject.put("text", elementName);
        driver.executeScript("mobile: scrollTo", scrollObject);
    }
	
	 public MobileElement scrollToElementByName(String elementName, String listId) {
	        MobileElement element = (MobileElement) ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" +
	                ".resourceId(\"" + listId + "\"))" +
	                ".scrollIntoView(new UiSelector().text(\"" + elementName + "\"));");
	        return element;
	    }

	 
	 public void clearappdata()
	 {
		 androidDriver.resetApp();
	 }
	 
	 
	 public void scrollDown() {
		//if pressX was zero it didn't work for me
		int pressX = androidDriver.manage().window().getSize().width / 2;
		// 4/5 of the screen as the bottom finger-press point
		int bottomY = androidDriver.manage().window().getSize().height * 4/5;
		// just non zero point, as it didn't scroll to zero normally
		int topY = androidDriver.manage().window().getSize().height / 8;
		//scroll with TouchAction by itself
		scroll(pressX, bottomY, pressX, topY);
		}
		private void scroll(int fromX, int fromY, int toX, int toY) {
		TouchAction touchAction = new TouchAction(androidDriver);
		touchAction.longPress(fromX, fromY).moveTo(toX, toY).release().perform();
		}
		
		public void scrollup()
		{
			//if pressX was zero it didn't work for me
			int pressX = androidDriver.manage().window().getSize().width / 2;
			// 4/5 of the screen as the bottom finger-press point
			int bottomY = androidDriver.manage().window().getSize().height * 1/5;
			// just non zero point, as it didn't scroll to zero normally
			int topY = androidDriver.manage().window().getSize().height  / 2;
			System.out.println("hii");
			//scroll with TouchAction by itself
			scroll1(pressX, bottomY, pressX, topY);
			}
			private void scroll1(int fromX, int fromY, int toX, int toY) {
			TouchAction touchAction = new TouchAction(androidDriver);
			touchAction.longPress(fromX, fromY).moveTo(toX, toY).release().perform();
		}
	
	 public void touch_action(int xPoint,int yPoint)
	 {
		 
		 TouchAction touchAction=new TouchAction(androidDriver);
			touchAction.tap(xPoint, yPoint).perform();
	 }
	 public AppiumDriver<MobileElement> getDriver()
	    {

	        return  androidDriver;
	    }
	 public void close_lunchapp()
	 {
		androidDriver.closeApp();
		androidDriver.launchApp();
	 }

	 public void hidekeyboard()
	 {
		 try {
		 androidDriver.hideKeyboard();
	 }
		 catch(Exception e){
			 System.out.println(e);
		 }
	 }
	 
	 
	 
/*	 public void if_appinstalled()
	 {
		 public class MainActivity extends AppCompatActivity {
			    @Override
			    protected void onCreate(Bundle savedInstanceState) {
			        super.onCreate(savedInstanceState);

			        // Add respective layout
			        setContentView(R.layout.main_activity);

			        // Use package name which we want to check
			        boolean isAppInstalled = appInstalledOrNot("com.check.application");  

			        if(isAppInstalled) {
			            //This intent will help you to launch if the package is already installed
			            Intent LaunchIntent = getPackageManager()
			                .getLaunchIntentForPackage("com.check.application");
			            startActivity(LaunchIntent);

			            Log.i("Application is already installed.");       
			        } else {
			            // Do whatever we want to do if application not installed
			            // For example, Redirect to play store

			            Log.i("Application is not currently installed.");
			        }
			    }

			    private boolean appInstalledOrNot(String uri) {
			        PackageManager pm = getPackageManager();
			        try {
			            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
			            return true;
			        } catch (PackageManager.NameNotFoundException e) {
			        }

			        return false;
			    }

			} 
	 }*/
}
