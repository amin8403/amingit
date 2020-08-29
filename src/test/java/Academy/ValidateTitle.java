package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class ValidateTitle extends Base{
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage lp;
	
	@BeforeTest
	public void Initialize() throws Exception{
		driver = IntializeDriver();
		log.info("Driver is Initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
		
	}
	
	@Test
	public void basePage() throws Exception{
		
		lp= new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Succesfully validated Text Message");
		
		Assert.assertTrue(lp.getTitle1().isDisplayed());
		log.info("Navigation bar is displayed");
		
		Assert.assertEquals(lp.getHeader().getText(), "An Academy to learn Everything about Testing");
		
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
	}
	
}
