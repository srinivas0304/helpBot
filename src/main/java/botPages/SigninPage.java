package botPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helpBot.baseclass.BaseClass;

public class SigninPage extends BaseClass
{
	By clickingOnSigninBtn=By.xpath("(//ul[@id='gh-topl']//li//span)[1]");
	
	By message=By.xpath("//h1[text()='Hello']");
	
	public void signinBtn() throws Exception
	{	
		Thread.sleep(2000);
		driver.findElement(clickingOnSigninBtn).click();
	}
	
	public LoginPage msg() throws Exception
	{
		Thread.sleep(2000);
		boolean b=driver.findElement(message).isDisplayed();
		System.out.println(b);
		System.out.println("clicking on signin button "+message);
		return new LoginPage();
	}
}
