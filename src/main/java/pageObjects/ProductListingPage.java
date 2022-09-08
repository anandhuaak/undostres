package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

public class ProductListingPage {
	WebDriver driver;

	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
	private WebElement register_Patient;

	@FindBy(how = How.ID, using = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
	private WebElement find_Patient;

	@FindBy(how = How.NAME, using = "givenName")
	private WebElement gName;

	@FindBy(how = How.NAME, using = "familyName")
	private WebElement lName;

	@FindBy(how = How.NAME, using = "phoneNumber")
	private WebElement phoneNo;

	@FindBy(how = How.ID, using = "gender-field")
	private WebElement gender;

	@FindBy(how = How.ID, using = "birthdateDay-field")
	private WebElement BirthDay;

	@FindBy(how = How.ID, using = "birthdateMonth-field")
	private WebElement MonthSelector;

	@FindBy(how = How.ID, using = "birthdateMonth")
	private WebElement BirthMonth;

	@FindBy(how = How.ID, using = "birthdateYear-field")
	private WebElement BirthYear;

	@FindBy(how = How.ID, using = "address1")
	private WebElement Address;

	@FindBy(how = How.ID, using = "submit")
	private WebElement submit;

	@FindBy(how = How.ID, using = "next-button")
	private WebElement nextBtn;

	@FindBy(how = How.ID, using = "delete-reason")
	private WebElement delreason;

	@FindBy(how = How.ID, using = "patient-search")
	private WebElement patient_search;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@id='patient-search-results-table_wrapper']//td"))
	private List<WebElement> table_rows;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Delete Patient')]")
	private WebElement delete_patient;

	@FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	private List<WebElement> prd_List;

	public void clickOn_Register() {
		register_Patient.click();
		Wait.untilPageLoadComplete(driver);
	}

	public void click_On_find_Patient() throws InterruptedException {
		find_Patient.click();
		Wait.untilPageLoadComplete(driver);
		Thread.sleep(1000);
	}

	public void enterFirstandLastNme(String username, String password) {
		gName.sendKeys(username);
		lName.sendKeys(password);
		nextBtn.click();
		Wait.untilPageLoadComplete(driver);
	}

	public void enter_Dob(String Day, String Month, String Year) {
		BirthDay.sendKeys(Day);
		MonthSelector.click();
		Select dropdown = new Select(MonthSelector);
		dropdown.selectByVisibleText(Month);
		BirthYear.sendKeys(Year);
		nextBtn.click();
		Wait.untilPageLoadComplete(driver);
	}

	public void select_gender(String g) {
		gender.click();
		Select dropdown = new Select(gender);
		dropdown.selectByVisibleText(g);
		nextBtn.click();
		Wait.untilPageLoadComplete(driver);
	}

	public void enter_address(String address) {
		Address.sendKeys(address);
		nextBtn.click();
		Wait.untilPageLoadComplete(driver);
	}

	public void enter_Phone(String phone) {
		phoneNo.sendKeys(phone);
		nextBtn.click();
		nextBtn.click();
		Wait.untilPageLoadComplete(driver);
	}

	public void enter_patient_name(String name) {
		patient_search.sendKeys(name);
		Wait.untilPageLoadComplete(driver);
	}

	public void submit() {
		submit.click();
	}

	public String search_details(int index) {

	  return table_rows.get(index).getText();
	}

	public void click_on_details() {

		table_rows.get(0).click();
	}

	public void delete_patients() {

		delete_patient.click();
		Wait.untilPageLoadComplete(driver);
	}

	public void enter_reason(String reason) {

		delreason.sendKeys(reason);
	}

	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
	}

	public String getProductName(int productNumber) {
		return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
	}

}
