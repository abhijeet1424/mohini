package demoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.JobsRecruitmentJobSearchPage;

public class TestClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		
		JobsRecruitmentJobSearchPage jobsRecruitmentJobSearchPage=new JobsRecruitmentJobSearchPage(driver);
		jobsRecruitmentJobSearchPage.clickRegisterButton();

	}

}
