package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;
	
	By email = By.id("user_email");
	By sendMeInstruction = By.xpath("//input[@name='commit']");
	
	public ForgotPassword(WebDriver driver){
		this.driver=driver;
	}
	public WebElement getEmail(){
		return driver.findElement(email);
	}
	public WebElement sendMeInstructions()
	{
		return driver.findElement(sendMeInstruction);
	}	
	
}
