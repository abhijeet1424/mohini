package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

import utils.Utility;

public class RegisterOnNaukri_ComPage {
	
	@FindBy (xpath = "//input[@id='name']")
	private WebElement fullName;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailID;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath = "(//button[@type='button'])[1]")
	private WebElement eyeButton;
	
	@FindBy(xpath = "//input[@id='mobile']")
	private WebElement mobileNumber;
	
	@FindBy(xpath = "//div[@class='focusable optionWrap  ']")
	private WebElement workStatusExperienced;
	
	@FindBy (xpath = "//button[text()='Register now']")
	private WebElement registerNow;
	
	private WebDriver driver;
	
	public RegisterOnNaukri_ComPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendFullName() throws EncryptedDocumentException, IOException
	{
		String fullNameData=Utility.getDataFromExcelsheet("Register", 2, 0);
		fullName.sendKeys(fullNameData);
	}
	
	public void sendEmailID() throws EncryptedDocumentException, IOException
	{
		String emailIDData=Utility.getDataFromExcelsheet("Register", 2, 1);
		emailID.sendKeys(emailIDData);
	}
	
	public void sendPassword() throws EncryptedDocumentException, IOException
	{
		String passwordData=Utility.getDataFromExcelsheet("Register", 2, 2);
		password.sendKeys(passwordData);
	}
	
	public void clickEyeButton()
	{
		eyeButton.click();
	}
	
	public void sendMobileNumber() throws EncryptedDocumentException, IOException
	{
		String mobileNumberData=Utility.getDataFromExcelsheet("Register", 2, 3);
		mobileNumber.sendKeys(mobileNumberData);
	}
	
	public void selectWorkStatus() throws InterruptedException
	{
		workStatusExperienced.click();
		Thread.sleep(2000);
		
	}
	
	public void clickRegisterNow()
	{
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,300);");
		registerNow.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
