package resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver IntializeDriver() throws Exception{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
		
		prop.load(fis);
		
		//String browserName = System.getProperty("browser");  //to get the browser property directly from maven using "mvn test -Dbrowser=chrome"
		String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);
		
		if(browserName.contains("chrome")){
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"\\drivers\\chromedriver.exe"));
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir")+"\\drivers\\geckodriver.exe"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver", (System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe"));
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		return driver;
		
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws Exception{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		
	}

}
