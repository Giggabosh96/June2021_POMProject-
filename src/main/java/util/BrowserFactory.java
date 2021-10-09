package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver drivers;
	static String browser;
	static String url;

	public static void readConfig() {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Browser used " + browser);
			url = prop.getProperty("url");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver init() {
		readConfig();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			drivers = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			drivers = new FirefoxDriver();
		}
		drivers.manage().window().maximize();
		drivers.manage().deleteAllCookies();
		drivers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		drivers.get(url);
		return drivers;
	}

	public static void tearDown() {

		drivers.close();
		drivers.quit();
	}
}
