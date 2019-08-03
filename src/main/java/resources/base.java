package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public static WebDriver driver;
	public Properties prop;
	public WebDriver iniilizeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis= new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Drivers\\chromedriver1.exe");
			driver= new ChromeDriver();
		
		}
		else if(browserName.equals("firefox"))
		{
		//Execute in FireFix Driver	
			System.setProperty("webdriver.gecko.driver", "src\\main\\java\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;
	}
}
