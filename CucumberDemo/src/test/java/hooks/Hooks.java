package hooks;

import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.*;



public class Hooks {
	WebDriver driver;
	Properties p;
	@Before
	public void setup() throws Exception
	{
		driver=BaseClass.initializebrowser();
		p=BaseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	@After
	
	public void teardown()
	{
		driver.quit();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
		byte[] screenshot=	ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
	

}
