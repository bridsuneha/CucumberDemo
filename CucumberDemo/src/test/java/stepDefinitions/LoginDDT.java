package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginDDT {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	
	List<HashMap<String,String>> datamap;
	@Given("the user navigate to login page")
	public void the_user_navigate_to_login_page() {
		BaseClass.getlogger().info("Go to myaccount----clickon login");
		hp=new HomePage(BaseClass.driver());
		hp.clickmyaccount();
		hp.clicklogin();
	}

	@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	public void the_user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel_row(String rows) {
		datamap=DataReader.data(System.getProperty("user.dir")+"\\test data\\Opencart_LoginData.xlsx", "Sheet1");
		int index=Integer.parseInt(rows)-1;
		String email=datamap.get(index).get("username");
		String pwd=datamap.get(index).get("password");
		String exp_res=datamap.get(index).get("res");
		
		lp=new LoginPage(BaseClass.driver());
		lp.settextemail(email);
	    lp.settextpassword(pwd);
	    lp.clickloginbtn();
	    
	    macc=new MyAccountPage(BaseClass.driver());
	    
	    Boolean status= macc.isMyAccountExists();
	    if(exp_res.equalsIgnoreCase("Valid"))
	    {
	    	if(status==true)
	    	{
	    		macc.logout();
	    		Assert.assertTrue(true);
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    
	    if(exp_res.equalsIgnoreCase("Invalid"))
	    {
	    	if(status==false)
	    	{
	    		
	    		Assert.assertTrue(true);
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    
		
		
	}



}
