package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By email = By.id("user_email");
	By password = By.id("user_password");
	By Login = By.xpath("//input[@class='btn btn-primary btn-md login-button']");
	By forgotpassword = By.xpath("//a[@class='link-below-button']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public ForgotPassword forgotPassword(){
		driver.findElement(forgotpassword).click();
		return new ForgotPassword(driver);
	}
	public WebElement getEmail(){
		return driver.findElement(email);
	}
	public WebElement getPassword(){
		return driver.findElement(password);
	}
	public WebElement getLogin(){
		return driver.findElement(Login);
	}
}
