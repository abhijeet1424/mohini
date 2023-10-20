package pages;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class JobsRecruitmentJobSearchPage {
	
	@FindBy (xpath = "//a[@title='Jobseeker Register']")
	private WebElement register;
	
	@FindBy (xpath = "(//input[@class='suggestor-input '])[2]")
	private WebElement location;
	
	@FindBy (xpath = "//input[@id='expereinceDD']")
	private WebElement experience;
	
	@FindBy (xpath = "(//input[@class='suggestor-input '])[1]")
	private WebElement enterSkill;
	
	@FindBy (xpath = "//div[text()='Search']")
	private WebElement search;
	
	private WebDriver driver;
	
	public JobsRecruitmentJobSearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickRegisterButton()
	{
		register.click();
	}
	
	public void clickSearch()
	{
		search.click();
	}
	
	public void selectLocation() throws EncryptedDocumentException, IOException
	{
		String locationData=Utility.getDataFromExcelsheet("Find your dream job now", 2, 1);
		location.sendKeys(locationData);
	}
	
	public void selectExperience()
	{
		experience.click();
		List<WebElement> experienceList=driver.findElements(By.xpath("//ul[@class='dropdown ']//li"));
		System.out.println(experienceList.size());
		for(int i=0;i<experienceList.size();i++)
		{
			String result=experienceList.get(i).getText();
			if(result.contains("3 years"))
			{
				experienceList.get(i).click();
				break;
			}
		}
	}
	
	public void selectEnterSkillsDesignationCompanies() throws EncryptedDocumentException, IOException
	{
		String enterSkillsData=Utility.getDataFromExcelsheet("Find your dream job now", 2, 0);
		
		enterSkill.sendKeys(enterSkillsData);
		
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='layer-wrap']//li"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			String result=list.get(i).getText();
			if(result.contains("Software testing And QA Engineer"))
			{
				list.get(i).click();
				break;
			}
			
		}
	}
	
	
	

}
