package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SoftwareTestingAndQaEngineerJobPage {
	
	@FindBy (xpath = "//span[text()='Work from office']")
	private WebElement workFromOffice;
	
	@FindBy (xpath = "//span[text()='Hybrid']")
	private WebElement hybrid;
	
	@FindBy (xpath = "(//div[@class=' row1'])[1]")
	private WebElement automationTesting;
	
	private WebDriver driver;
	
	public SoftwareTestingAndQaEngineerJobPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public void clickWorkFromOffice()
	{
		workFromOffice.click();
	}
	
	public void clickHybrid()
	{
		hybrid.click();
	}
	
	public void clickAutomationTesting()
	{
		automationTesting.click();
	}
	
	

}
