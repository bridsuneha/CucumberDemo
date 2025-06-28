package factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	static WebDriver driver;
	static Properties p;
	static Logger logger;
	
	public static Properties getProperties() throws Exception
	{
		p=new Properties();
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p.load(file);
		return p;
	}
	
	public static WebDriver initializebrowser() throws Exception
	
	{
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//OS
			if(getProperties().getProperty("os").equalsIgnoreCase("windows"))
				capabilities.setPlatform(Platform.WIN11);
			else if(getProperties().getProperty("os").equalsIgnoreCase("mac"))
				capabilities.setPlatform(Platform.MAC);
			else if (getProperties().getProperty("os").equalsIgnoreCase("linux"))
				capabilities.setPlatform(Platform.LINUX);
			else {
				System.out.println("No matching operating system provided");
				
				}
			//browser
			
			switch(getProperties().getProperty("browser").toLowerCase())
			{
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge":capabilities.setBrowserName("edge");break;
			case "firefox":capabilities.setBrowserName("firefox");break;
			default:System.out.println("No matching browser provided");return null;
			
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(getProperties().getProperty("browser").toLowerCase()) {
			case "chrome":driver=new ChromeDriver();break;
			case "firefox": driver=new FirefoxDriver();break;
			case "edge":driver=new EdgeDriver();break;
			default:System.out.println("No matching input found");return null;}
			
			
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
			
		}
	public static WebDriver driver()
	{
		return driver;
	}
	public static Logger getlogger()
	{
		logger=LogManager.getLogger();
		return logger;
	}
	public static String randomString()
	{
		String genstring=RandomStringUtils.randomAlphabetic(5);
		return genstring;
	}

	public static String randomNumber()
	{
		String genNumber=RandomStringUtils.randomNumeric(10);
		return genNumber;
	}
	public static String AlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(5);
		 String num=RandomStringUtils.randomNumeric(10);
		return str+num;
	}

	
	}
	


