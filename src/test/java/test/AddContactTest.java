package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {

	WebDriver drivers;

	String userName = "demo@techfios.com";
	String password = "abc123";
	String Full_Name_for_Add_Contact = "Test Test";
	String Company_Name_for_Add_Contact = "Techfios";
	String Email_for_Add_Contact = "testinput@techfios.com";
	String Phone_for_Add_Contact = "12312367";
	String Country_for_Add_Contact = "Italy";

	@Test
	public void validUserShouldBeAbletoAddCustomer() {

		drivers = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(drivers, LoginPage.class);
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSignInButton();

		DashboardPage dashboard = PageFactory.initElements(drivers, DashboardPage.class);
		dashboard.verifyDashboard();
		dashboard.clickCustomerButton();
		dashboard.clickAddCustomerButton();

		AddContactPage addContactPage = PageFactory.initElements(drivers, AddContactPage.class);
		addContactPage.verifyContactHeaderPage();
		addContactPage.insertFullName(Full_Name_for_Add_Contact);
		addContactPage.selectCompany(Company_Name_for_Add_Contact);
		addContactPage.insertEmail(Email_for_Add_Contact);
		addContactPage.insertPhone(Phone_for_Add_Contact);
		addContactPage.selectCountry(Country_for_Add_Contact);
		addContactPage.saveAddContactResults();
		
	}
}
