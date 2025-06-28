package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		//features=	{".//Features/LoginDDT.feature"},
		//features={"@target/rerun.txt"},
				features={".//Features/Login.feature",".//Features/registration.feature"},
					glue={"stepDefinitions","hooks"},
					plugin= {"pretty","html:reports/myreport.html",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"rerun:target/rerun.txt"},
					
					dryRun=false,
					monochrome=true,
					publish=true
					//tags="@regression"
		
		
		
		
		
		
		
		
		
		
		)








public class TestRun {

}
