package Runners;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class base extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	public static String Browser, Owner, Admin, cohost, Owner_password, Admin_password, cohost_password, url;

	public WebDriver launchbrowser(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome": {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--use-fake-ui-for-media-stream");
			options.addArguments("--disable-notifications");
//			options.addArguments("--headless"); // Enable headless mode
//			options.addArguments("--disable-gpu"); // Optional: For Windows systems
			return new ChromeDriver(options);
		}
		case "edge": {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--use-fake-ui-for-media-stream");
			options.addArguments("--disable-notifications");
			return new EdgeDriver(options);
		}
		case "firefox": {
			FirefoxOptions options = new FirefoxOptions();
			return new FirefoxDriver(options);
		}
		case "safari": {
			SafariOptions options = new SafariOptions();
			return new SafariDriver(options);
		}
		default:
			return null;
		}
	}

	public void Environment(String Env, String Url_QA, String Url_Dev, String Url_Prod) {
		switch (Env.toLowerCase()) {
		case "qa":
			url = Url_QA;

			Owner = "guruprasad.b@contus.in";
			Owner_password = "Welcome@123";
			Admin = "SuperAdmin!@#$1234";
			Admin_password = "";
			cohost = "rahul.s@contus.in";
			cohost_password = "";
			break;

		case "dev":
			url = Url_Dev;

			Owner = "rahul.s@contus.in";
			Owner_password = "";
			Admin = "SuperAdmin!@#$1234";
			Admin_password = "";
			cohost = "rahul.s@contus.in";
			cohost_password = "";
			break;

		case "prod":
			url = Url_Prod;

			Owner = "guruprasad.b@contus.in";
			Owner_password = "Welcome@123";
			Admin = "SuperAdmin!@#$1234";
			Admin_password = "";
			cohost = "rahul.s@contus.in";
			cohost_password = "";
			break;
		}
	}

	public static void offline() throws InterruptedException {
		Map<String, Object> offlineParams = new HashMap<>();
		offlineParams.put("offline", true);
		offlineParams.put("latency", 0); // Latency in ms (no delay)
		offlineParams.put("downloadThroughput", 0); // Download speed (0 = disconnected)
		offlineParams.put("uploadThroughput", 0); // Upload speed (0 = disconnected)

		switch (Browser) {
		case "chrome":
			((ChromeDriver) driver).executeCdpCommand("Network.emulateNetworkConditions", offlineParams);
			System.out.println("Network disconnected");
			break;

		case "firefox":
			// not working
			((FirefoxDriver) driver)
					.executeScript("window.navigator.serviceWorker.controller.postMessage({offline: true});");
			break;
		case "edge":
			((EdgeDriver) driver).executeCdpCommand("Network.emulateNetworkConditions", offlineParams);
			break;
		}
	}

	public static void online() {
		Map<String, Object> onlineParams = new HashMap<>();
		onlineParams.put("offline", false);
		onlineParams.put("latency", 0); // Set small latency to simulate a real connection
		onlineParams.put("downloadThroughput", -1); // -1 for normal speed
		onlineParams.put("uploadThroughput", -1); // -1 for normal speed

		switch (Browser) {
		case "chrome":
			((ChromeDriver) driver).executeCdpCommand("Network.emulateNetworkConditions", onlineParams);
			System.out.println("Network connected");
			break;

		case "firefox":
			// not working
			((FirefoxDriver) driver)
					.executeScript("window.navigator.serviceWorker.controller.postMessage({offline: false});");
			break;

		case "edge":
			((EdgeDriver) driver).executeCdpCommand("Network.emulateNetworkConditions", onlineParams);
			break;
		}
	}
}
