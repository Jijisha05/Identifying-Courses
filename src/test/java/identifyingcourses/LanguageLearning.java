package identifyingcourses;

import org.testng.annotations.Test;

import pom.LanguageLearningPage;
import pom.courserapage;
import utilities.ExcelUtility;
import utilities.Screenshot;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LanguageLearning extends DriverSetup {

	Screenshot s;
	public LanguageLearning()
	{
		s=new Screenshot();
	}
	
	@Test(priority=0,groups= {"smoke","regression","master"})
	public void searchingLanguageLearning() throws InterruptedException, IOException {
		Thread.sleep(6000);
		ExcelUtility excel = new ExcelUtility();
		courserapage coursera = new courserapage(driver);
		coursera.homePage();
		Thread.sleep(6000);
		coursera.searchingLanguageLearning(excel.readDatalang());
		s.screen(driver, "searchingLanguage");
		
	}
	
	@Test(priority=1,groups= {"regression","master"})
	public void countOfLevel() {
		LanguageLearningPage lang = new LanguageLearningPage(driver);
		WebElement scroll1=driver.findElement(By.xpath("//*[contains(text(), 'Level')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",scroll1);
		List<WebElement>levels=new ArrayList<WebElement>();
		levels = lang.levelCount();
		for (WebElement webElement : levels) {
			String levelname = webElement.getText();
			System.out.println(levelname);
		}
		System.out.println("Count of levels are "+ levels.size());
	}
	
	@Test(priority=2,groups= {"regression","master"})
	public void countOfLanguage() throws InterruptedException {
		LanguageLearningPage lang = new LanguageLearningPage(driver);
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[contains(text(), 'Language')]")));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='search-results-header-wrapper']/div/div[1]/div/div[2]/div[2]/button/span")));
		Thread.sleep(7000);
	    List<WebElement>langlist=new ArrayList<WebElement>();
	    langlist = lang.languageCount();
		
	    for (WebElement webElement : langlist) {
			String langname = webElement.getText();
			System.out.println(langname);
		}
		
		System.out.println(langlist.size());
		Thread.sleep(5000);
		lang.clickingApply();
	}
}
