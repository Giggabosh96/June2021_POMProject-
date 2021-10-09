package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	
	WebDriver drivers;
	String userName = "demo@techfios.com";
	String password = "abc123";
	
	@Test
	public void verifiedUserShouldBeAbleToLogin() {
		
		drivers = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(drivers, LoginPage.class);
		login.insertUserName(userName);
		login.insertPassword(password);
		
		login.clickSignInButton();
		DashboardPage dashboard = PageFactory.initElements(drivers, DashboardPage.class);
		dashboard.verifyDashboard();
		
		BrowserFactory.tearDown();
	}
}
