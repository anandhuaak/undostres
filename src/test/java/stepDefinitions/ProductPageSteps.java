package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import org.junit.Assert;
import pageObjects.ProductListingPage;

public class ProductPageSteps {

	TestContext testContext;
	ProductListingPage productListingPage;

	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		String productName = productListingPage.getProductName(0);
		testContext.getScenarioContext().setContext(Context.PRODUCT_NAME, productName);

		productListingPage.select_Product(0);
		// productListingPage.clickOn_AddToCart();
	}

	@When("^user clicks on register patient$")
	public void choose_to_click_register_patient_() {
		productListingPage.clickOn_Register();

	}

	@When("^user clicks on find patient record$")
	public void choose_to_click_find_patient_() throws InterruptedException {
		productListingPage.click_On_find_Patient();

	}

	@When("^user enter FirstName as \"([^\"]*)\" and LastName as \"([^\"]*)\"$")
	public void enter_Firstname_as_and_Lastname_as(String arg1, String arg2) {
		productListingPage.enterFirstandLastNme(arg1, arg2);

	}

	@When("^user enter dob as \"([^\"]*)\" month as \"([^\"]*)\" and year as \"([^\"]*)\"$")
	public void enter_dob_as(String Day, String Month, String Year) {
		productListingPage.enter_Dob(Day, Month, Year);

	}

	@When("^user selects gender as \"([^\"]*)\"$")
	public void enter_gender_as(String gender) {
		productListingPage.select_gender(gender);

	}

	@When("^user enter address as \"([^\"]*)\"$")
	public void enter_address_as(String arg1) {

		productListingPage.enter_address(arg1);

	}

	@When("^user enter phoneno as \"([^\"]*)\"$")
	public void enter_phoneno_as(String phone) {
		productListingPage.enter_Phone(phone);

	}

	@When("^user search with FirstName as \"([^\"]*)\"$")
	public void enter_firstname_as(String fname) {
		productListingPage.enter_patient_name(fname);

	}

	@Then("^verify saved details are displayed with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void search_patient(String fname, String lname, String gender) {
		
		String name= fname+" "+lname;
		String sex="F";
		if(gender.contentEquals("Male"))
				{
					sex ="M";
				}
		
        Assert.assertEquals("patient name not matching",name, productListingPage.search_details(1));
        Assert.assertEquals("patient name not matching",sex, productListingPage.search_details(2));		
		
		

	}
	
	@When("^user clicks on the patient details$")
	public void choose_to_click_on_patient_() {
		productListingPage.click_on_details();

	}

	@Then("^user clicks on confirm button$")
	public void choose_to_click_confirm_button_() {
		productListingPage.submit();
	}
	
	@Then("^delete the patient with a reason$")
	public void choose_to_delete_patient_() {
		productListingPage.delete_patients();
		productListingPage.enter_reason("reason");
	}
}
