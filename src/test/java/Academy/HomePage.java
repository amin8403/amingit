package Academy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base{
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test(dataProvider = "getData")
	public void basePage(String Email, String Password, String Message) throws Exception{
		driver = IntializeDriver();
		driver.get(prop.getProperty("url"));
		
		LandingPage lp= new LandingPage(driver);
		lp.getLogin().click();
		LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys(Email);
		login.getPassword().sendKeys(Password);
		
		login.getLogin().click();
		//System.out.println(Message);
		log.info(Message);
			
		ForgotPassword fp = login.forgotPassword();
		fp.getEmail().sendKeys("sahidhussain012@gmail.com");
		fp.sendMeInstructions().click();
	}

	@AfterTest
	public void teardown(){
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		//Row stands for how many different data types test should run starting from 0
		//column stands for how many values per each test staring from 0 
		Object[][] obj = new Object[2][3];
		
		//0th row
		obj[0][0] = "sahidhussain012@gmail.com";   //1st column
		obj[0][1] = "sahid012"; 				   //2nd column
		obj[0][2] = "Restricted student";		   //3rd column	
		
		//1st row
		obj[1][0] = "aminhussain255@gmail.com";		//1st column
		obj[1][1] = "amin3154";						//2nd column
		obj[1][2] = "Non Restricted student";		//3rd column			
		return obj;

	}
	
}
