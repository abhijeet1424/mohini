package demoTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.JobsRecruitmentJobSearchPage;
import pages.RegisterOnNaukri_ComPage;

public class TestClass2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		
		JobsRecruitmentJobSearchPage jobsRecruitmentJobSearchPage=new JobsRecruitmentJobSearchPage(driver);
		jobsRecruitmentJobSearchPage.clickRegisterButton();
		
		RegisterOnNaukri_ComPage registerOnNaukri_ComPage=new RegisterOnNaukri_ComPage(driver);
		registerOnNaukri_ComPage.sendFullName();

	}

}
