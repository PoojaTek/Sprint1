package applaunch;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.InteractsWithApps;

public class UserStory {

	public static void main(String[] args)throws MalformedURLException, InterruptedException {
		
	//1.1 If the app is present on device, uninstall it. 
				
		DesiredCapabilities capabilities = new DesiredCapabilities();
				
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "R9ZW4030QYT");
		capabilities.setCapability(MobileCapabilityType.UDID, "R9ZW4030QYT");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			    
		// capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.alveo.bewell.development");
		// capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY ,"com.alveo.bewell.MainActivity");
			    
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
			    
		Thread.sleep(1000);
			    
		InteractsWithApps interactsWithApps = (InteractsWithApps) driver;
		   
		boolean IsAppInstalled = driver.isAppInstalled("com.alveo.bewell.development");
			if (IsAppInstalled) 
			{
			    driver.removeApp("com.alveo.bewell.development");
			    System.out.println("App Uninstalled");
			    Thread.sleep(1000);
		    	
			  }
			  else {
				 System.out.println("App Not present"); 
			    }
			    
	//1.2 Install the app on target through Appium. InstallBeWellOnTarget()
			    
		driver.installApp(System.getProperty("user.dir")+"\\APK\\beWell_2.0.0(218)-development-release.apk\\beWell_2.0.0(218)-development-release.apk");
			    
		System.out.println("App Installed !!!");
		    	
	//1.3 Check if app is correctly installed. CheckIfBeWellAppIsPresentonTarget() 
		    	
		 driver.isAppInstalled("com.alveo.bewell.development");
		   	   
		 System.out.println("App is Installed"); 
			    
			
	//2.1. Check if the Application is closed. CheckIfBewellAppIsRunning() 
			
		ApplicationState AppState1 = driver.queryAppState("com.alveo.bewell.development");
		    
		System.out.println("Current AppState 1 - " + AppState1);
				  
			}
	}

