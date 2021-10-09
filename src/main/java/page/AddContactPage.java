package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddContactPage extends BasePage{
	
	WebDriver drivers;

	public AddContactPage(WebDriver drivers) {
		this.drivers = drivers;
		
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement CONTACTS_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]") WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]") WebElement SAVE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]") WebElement ZIP_CODE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='tags']") WebElement TAGS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"group\"]") WebElement GROUP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cpassword\"]") WebElement CONFIRM_PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"rform\"]/div[1]/div[2]/div[5]/div/div/div/label[1]") WebElement TOGGLE_WELCOME_EMAIL_BUTTON_ELEMENT;

	public void verifyContactHeaderPage() {

		Assert.assertEquals(CONTACTS_HEADER_ELEMENT.getText(), "Contacts", "Wrong Page!");

	}

	public void insertFullName(String username) {
		
		FULL_NAME_ELEMENT.sendKeys(username + generateRandomNo(999));
	}
	
	public void selectCompany(String company) {
		
		selectFromDropdown(COMPANY_NAME_ELEMENT, company);
	}
	
	public void insertEmail(String email) {
		
		EMAIL_ELEMENT.sendKeys(generateRandomNo(99) + email);
	}

	public void insertPhone(String phone) {
		
		PHONE_ELEMENT.sendKeys(phone + generateRandomNo(999));
	}
	
	public void insertAddress(String address) {
		
		ADDRESS_ELEMENT.sendKeys(generateRandomNo(9999) + address);
	}
	
	public void insertCity(String city) {
		
		CITY_ELEMENT.sendKeys(city);
	}
	
	public void insertState(String state) {
		
		STATE_ELEMENT.sendKeys(state);
	}
	
	public void insertZipCode(String zip) {
		
		ZIP_CODE_ELEMENT.sendKeys(zip + generateRandomNo(9999));
	}
	
	public void selectTag(String tag) {
		
		selectFromDropdown(TAGS_ELEMENT, tag);
	}
	
	public void selectCountry(String country) {
		
		selectFromDropdown(COUNTRY_ELEMENT, country);
	}
	
	public void selectGroup(String group) {
		
		selectFromDropdown(GROUP_ELEMENT, group);
	}
	
	public void insertPassword(String password) {
		
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void confirmPassword(String confirmPassword) {
		
		CONFIRM_PASSWORD_ELEMENT.sendKeys(confirmPassword);
	}
	
	public void clickWelcomeEmailButton() {
		
		TOGGLE_WELCOME_EMAIL_BUTTON_ELEMENT.click();
	}
	
	public void saveAddContactResults() {
		
		SAVE_ELEMENT.click();
	}
	

}

