package demoTest;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.JobsRecruitmentJobSearchPage;
import pages.QAAutomationTestingPunePage;
import pages.RegisterOnNaukri_ComPage;
import pages.SoftwareTestingAndQaEngineerJobPage;

public class TestClass_FindYourDreamJob {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		JobsRecruitmentJobSearchPage jobsRecruitmentJobSearchPage=new JobsRecruitmentJobSearchPage(driver);
		jobsRecruitmentJobSearchPage.selectEnterSkillsDesignationCompanies();
		jobsRecruitmentJobSearchPage.selectExperience();
		jobsRecruitmentJobSearchPage.selectLocation();
		jobsRecruitmentJobSearchPage.clickSearch();
		Thread.sleep(3000);
		
		SoftwareTestingAndQaEngineerJobPage softwareTestingAndQaEngineerJobPage=new SoftwareTestingAndQaEngineerJobPage(driver);
		softwareTestingAndQaEngineerJobPage.clickWorkFromOffice();
		Thread.sleep(3000);
		softwareTestingAndQaEngineerJobPage.clickHybrid();
		Thread.sleep(3000);
		softwareTestingAndQaEngineerJobPage.clickAutomationTesting();
		
		ArrayList<String> addresStrings=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addresStrings.get(1));
		
		QAAutomationTestingPunePage qaAutomationTestingPunePage=new QAAutomationTestingPunePage(driver);
		qaAutomationTestingPunePage.clickLoginToApply();

	}

}
