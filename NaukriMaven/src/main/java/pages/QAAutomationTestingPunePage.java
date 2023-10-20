package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAAutomationTestingPunePage {
	
	@FindBy (xpath = "//button[@id='login-apply-button']")
	private WebElement loginToApply;
	
	private WebDriver driver;
	
	public QAAutomationTestingPunePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickLoginToApply()
	{
		loginToApply.click();
	}

}
