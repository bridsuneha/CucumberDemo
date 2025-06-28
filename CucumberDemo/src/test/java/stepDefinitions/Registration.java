package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationpPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Registration {

	 WebDriver driver;
     HomePage hp;
     LoginPage lp;
     AccountRegistrationpPage regpage;
     
	@Given("the user is  navigates to  registration page")
	public void user_navigates_to_register_account_page() {
	
		hp=new HomePage(BaseClass.driver());
    	hp.clickmyaccount();
        hp.clickregister();
                   
	}

	@When("the user enters below data in below field")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	    
		regpage=new AccountRegistrationpPage(BaseClass.driver());
		regpage.setfname(dataMap.get("firstName"));
		regpage.setlname(dataMap.get("lastName"));
		regpage.setmail(BaseClass.AlphaNumeric()+"@gmail.com");
		regpage.setTelephone(dataMap.get("telephone"));
		regpage.setpassword(dataMap.get("password"));
		regpage.confpass(dataMap.get("password"));
		
		
	}

	@When("user selects the privacy policy")
	public void user_selects_privacy_policy() {
		regpage.setpolbutn();
	}

	@When("users clicks on continue button")
	public void user_clicks_on_continue_button() {
		regpage.clickconbutton();;
	}

	@Then("user acoount registration is done successfully")
	public void user_account_should_get_created_successfully() {
		
		String confmsg=regpage.getconfmsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
 }
