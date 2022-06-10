package botPages;

import org.openqa.selenium.By;

import com.helpBot.baseclass.BaseClass;

public class HelpBotWindowPage extends BaseClass
{
	By feedBack=By.xpath("(//div[@id='ocs_help_bot']//div[3]//button[1])[1]");
	
	public void clickingOnFeedback()
	{
		driver.findElement(feedBack).click();
	}
}
