package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;


public class Login {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	
	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() {
		BaseClass.getlogger().info("Go to myaccount----clickon login");
		hp=new HomePage(BaseClass.driver());
		hp.clickmyaccount();
		hp.clicklogin();
	}
	  
	

	@When("the user enters valid credentials\\(username:{string},password:{string})")
	public void the_user_enters_valid_credentials_username_password(String email, String pwd) {
		BaseClass.getlogger().info("Entering credentials");
		lp=new LoginPage(BaseClass.driver());
		lp.settextemail(email);
		lp.settextpassword(pwd);
		

	}

	@When("the user clicks on Login button")
	public void the_user_clicks_on_login_button() {
		BaseClass.getlogger().info("Clicking on login button");
		lp.clickloginbtn();
		
	}

	@Then("the user should be redirected to the My Account Page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
		macc = new MyAccountPage(BaseClass.driver());
	  boolean status= macc.isMyAccountExists();
	Assert.assertEquals(status, true);
	}

	}
