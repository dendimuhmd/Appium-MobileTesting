package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class RootApp {
	public static AndroidDriver driver;
	public static UiAutomator2Options options;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");

		String url = "http://127.0.0.1:4723/wd/hub";
		driver = new AndroidDriver(new URL(url), desiredCapabilities);

		accessibilityNodeProvider();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		Thread.sleep(2000);
//		driver.quit();
	}

	static void accessibilityNodeProvider() {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Accessibility Node Provider\"]"))
				.click();
		try {
			// Block of code to try
			String textIs = driver.findElement(By.xpath(
					"//android.widget.TextView[@content-desc=\"Enable TalkBack and Explore-by-touch from accessibility settings. Then touch the colored squares.\"]"))
					.getText();
			System.out.println("Is displayed " + textIs);
			Point boxColor = driver.findElement(By.className("android.view.View")).getLocation();

			System.out.println("Location " + boxColor);

		} catch (Exception e) {
			// Block of code to handle errors
			System.out.println("Fail to get");
		}

	}

}
