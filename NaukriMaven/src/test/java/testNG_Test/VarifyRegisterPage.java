package testNG_Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.JobsRecruitmentJobSearchPage;
import pages.QAAutomationTestingPunePage;
import pages.RegisterOnNaukri_ComPage;
import pages.SoftwareTestingAndQaEngineerJobPage;

public class VarifyRegisterPage {
	
	private WebDriver driver;
	private JobsRecruitmentJobSearchPage jobsRecruitmentJobSearchPage;
	private RegisterOnNaukri_ComPage registerOnNaukri_ComPage;
	private SoftwareTestingAndQaEngineerJobPage softwareTestingAndQaEngineerJobPage;
	private QAAutomationTestingPunePage qaAutomationTestingPunePage;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.contains("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Software Testing class\\Atomation Testing\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		if(browserName.contains("Edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\Admin\\Desktop\\Software Testing class\\Atomation Testing\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
	}
	
	@BeforeClass
	public void beforeClass()
	{
        jobsRecruitmentJobSearchPage=new JobsRecruitmentJobSearchPage(driver);
		registerOnNaukri_ComPage=new RegisterOnNaukri_ComPage(driver);
		softwareTestingAndQaEngineerJobPage=new SoftwareTestingAndQaEngineerJobPage(driver);
		qaAutomationTestingPunePage=new QAAutomationTestingPunePage(driver);

	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		//WebDriverManager.chromedriver().setup();
		
		
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}
	
	@Test
	public void test1() throws InterruptedException, EncryptedDocumentException, IOException
	{
		 
		jobsRecruitmentJobSearchPage.clickRegisterButton();
		 
		registerOnNaukri_ComPage.sendFullName();
		registerOnNaukri_ComPage.sendEmailID();
		registerOnNaukri_ComPage.sendPassword();
		registerOnNaukri_ComPage.sendMobileNumber();
		registerOnNaukri_ComPage.selectWorkStatus();
		registerOnNaukri_ComPage.clickRegisterNow();
	}
	
	@Test
	public void test2() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		jobsRecruitmentJobSearchPage.selectEnterSkillsDesignationCompanies();
		jobsRecruitmentJobSearchPage.selectExperience();
		jobsRecruitmentJobSearchPage.selectLocation();
		jobsRecruitmentJobSearchPage.clickSearch();
		Thread.sleep(3000);
		
		
		softwareTestingAndQaEngineerJobPage.clickWorkFromOffice();
		Thread.sleep(3000);
		softwareTestingAndQaEngineerJobPage.clickHybrid();
		Thread.sleep(3000);
		softwareTestingAndQaEngineerJobPage.clickAutomationTesting();
		
		ArrayList<String> addresStrings=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addresStrings.get(1));
		
		qaAutomationTestingPunePage.clickLoginToApply();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method");
	}
	
	
	@AfterClass
	public void afterClass()
	{
		jobsRecruitmentJobSearchPage=null;
		registerOnNaukri_ComPage=null;
		softwareTestingAndQaEngineerJobPage=null;
		qaAutomationTestingPunePage=null;
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
	

}
