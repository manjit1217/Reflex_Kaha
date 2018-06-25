package Generic_Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Read properties file
public class Utility_Class {
	
	
	protected static int APPIUM_SERVER_PORT;
	protected static String APK_PATH;
	private static String AUTOMATION_NAME;
	protected static String PLATFORM_NAME;
	protected static String DEVICE_NAME;
	private static Properties prop = new Properties();
    private static String loadAndroidPropertyFile = "og_android.properties";

	protected void loadConfigProp(String sample) throws IOException {
		System.err.println("manjit"+System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/resources/" + sample);
		prop.load(fis);
		APPIUM_SERVER_PORT = Integer.parseInt(prop.getProperty("appium.server.port"));
		APK_PATH = prop.getProperty("application.app");
		DEVICE_NAME = prop.getProperty("device.name");
		AUTOMATION_NAME = prop.getProperty("AutomationName");
		PLATFORM_NAME = prop.getProperty("platform.name");
	}
	

}
