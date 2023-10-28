package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestWebApp {
	public static AndroidDriver driver;
	public static DesiredCapabilities desiredCapabilities;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
//		desiredCapabilities.setCapability("deviceName", "your_device_name");
//		desiredCapabilities.setCapability("appPackage", "your_app_package");
//		desiredCapabilities.setCapability("appActivity", "your_app_activity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		driver.get("https://backoffice.smarco.co.id");
//		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Hallo Smarco!");
		Thread.sleep(2000);
		driver.quit();
	}
}
