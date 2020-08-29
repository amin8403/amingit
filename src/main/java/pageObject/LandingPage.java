package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
		
	By login = By.xpath("//*[text()='Login']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By title1 = By.xpath("//nav[@class='navbar-collapse collapse']");
	By header = By.xpath("//h3[contains(text(),'An Academy to learn Everything about Testing')]");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getLogin(){
		return driver.findElement(login);
	}
	
	public WebElement getTitle(){
		return driver.findElement(title);
	}
	
	public WebElement getTitle1(){
		return driver.findElement(title1);
	}
	
	public WebElement getHeader(){
		return driver.findElement(header);
	}

}
