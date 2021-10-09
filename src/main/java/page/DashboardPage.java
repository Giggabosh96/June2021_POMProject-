package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.html5.AddApplicationCache;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	WebDriver drivers;

	public DashboardPage(WebDriver drivers) {
		this.drivers = drivers;

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]")
	WebElement CUSTOMERS_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement ADD_CUSTOMERS_BUTTON_ELEMENT;

	public void verifyDashboard() {

		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard", "Wrong Page!");
	}

	public void clickCustomerButton() {

		CUSTOMERS_BUTTON_ELEMENT.click();
	}

	public void clickAddCustomerButton() {
		ADD_CUSTOMERS_BUTTON_ELEMENT.click();
	}
}
