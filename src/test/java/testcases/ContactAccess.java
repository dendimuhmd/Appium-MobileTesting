package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ContactAccess {
	public static AndroidDriver driver;
	public static UiAutomator2Options options;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"com.android.contacts.activities.PeopleActivity");

		String url = "http://127.0.0.1:4723/wd/hub";
		driver = new AndroidDriver(new URL(url), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Pilihan lagi\"]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Nama']")).sendKeys("M4maT K0r3Ng");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Telepon']")).sendKeys("0898998798");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys("kiwkiw@gmail.com");
		driver.findElement(By.xpath("//android.widget.Button[@text='Simpan']")).click();

		System.out.println("Save number");
		if (driver.findElement(By.xpath("//android.widget.Button[@text='Tetap simpan']")).isDisplayed()) {
//			driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigasi ke atas\"]")).click();
			driver.findElement(By.xpath("//android.widget.Button[@text='Tetap simpan']")).click();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
}
