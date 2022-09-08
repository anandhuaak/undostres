package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;

public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() {
		homePage.navigateTo_HomePage();
	}

	@When("^user enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void I_enter_Username_as_and_Password_as(String arg1, String arg2) {
		homePage.enterUsernamePassword(arg1, arg2);
		homePage.clickOn_Ward();
		homePage.clickOn_Login();
	}
	
	
	@Then("^verify login is successful$")
	public void  Login_Success() {
		
		Assert.assertEquals("Logged in message not found", "Logged in as Super User (admin) at Inpatient Ward.",homePage.read_Header());
		
	}

}
