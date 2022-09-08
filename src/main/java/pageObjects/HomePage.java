package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import selenium.Wait;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "username") 
	private WebElement uName;
	
	@FindBy(how = How.ID, using = "password") 
	private WebElement uPass;
	
	@FindBy(how = How.ID, using = "Inpatient Ward") 
	private WebElement ward;
	
	@FindBy(how = How.ID, using = "loginButton") 
	private WebElement loginBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-12 col-sm-12 col-md-12 col-lg-12']//h4") 
	private WebElement loginheader;
	
	
	@FindBy(how = How.CSS, using = ".checkout-button.alt") 
	private WebElement btn_ContinueToCheckout;
	
	public void enterUsernamePassword(String username, String password) {
		uName.sendKeys(username);
		uPass.sendKeys(password);
	}
	
	
	public void clickOn_Ward() {
		ward.click();
	}
	
	public void clickOn_Login(){
		loginBtn.click();
		Wait.untilPageLoadComplete(driver);
	}
		
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	public String read_Header() {
		return loginheader.getText();
	}

}