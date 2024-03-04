package identifyingcourses;

import org.testng.annotations.Test;

import pom.WebDevelopmentPage;
import pom.courserapage;
import pom.firstCoursePage;
import pom.secondCoursePage;
import utilities.ExcelUtility;
import utilities.Screenshot;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebDevelopment extends DriverSetup{
	
	String oldwindow;
	Screenshot s;
	public WebDevelopment()
	{
		s=new Screenshot();
	}
	
	
	@Test(priority=0,groups= {"smoke","regression","master"})
	public void searchingCourse() throws InterruptedException, IOException {
		ExcelUtility excel = new ExcelUtility();
		courserapage coursera = new courserapage(driver);
		coursera.clickSearchBox(excel.readDataweb());
		s.screen(driver, "SearchingWebdev");
		
	}
	
	
	@Test(priority=1,groups= {"regression","master"})
	public void filteringLevel() throws InterruptedException, IOException {
		
		Thread.sleep(6000);
		WebElement level=driver.findElement(By.xpath("//*[contains(text(), 'Level')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",level);
		Thread.sleep(3000);
		s.screen(driver, "scrollTillLevel");
		WebElement levelcheckbox=driver.findElement(By.xpath("//span[@class='cds-checkboxAndRadio-labelContent css-imksha']//*[contains(text(),'Beginner')]"));
		js.executeScript("arguments[0].click();", levelcheckbox);
	}
	
	@Test(priority=2,groups= {"regression","master"})
	public void filteringLanguage() throws InterruptedException, IOException {
		WebDevelopmentPage web = new WebDevelopmentPage(driver);
		Thread.sleep(3000);
		WebElement languages=driver.findElement(By.xpath("//*[contains(text(), 'Language')]"));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView();",languages);
		Thread.sleep(3000);
		WebElement languageshowmore=driver.findElement(By.xpath("//*[@id='search-results-header-wrapper']/div/div[1]/div/div[2]/div[2]/button/span"));
		js1.executeScript("arguments[0].click();", languageshowmore);
		Thread.sleep(3000);
		s.screen(driver, "languagesShowmore");
		web.filteringEnglish("English");
		Thread.sleep(3000);
		web.clickingEnglish();
		Thread.sleep(3000);
		s.screen(driver,"selectingEnglish");
		web.clickingApply();
		}

	@Test(priority=3,groups= {"regression","master"})
	public void scrollUp() throws InterruptedException {
		Thread.sleep(4000);
		WebElement gotop=driver.findElement(By.xpath("//*[@class='rc-SearchResultsHeader']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",gotop);
	}
	
	@Test(priority=4,groups= {"regression","master"})
	public void firstCourseDetails() throws InterruptedException, IOException {
		firstCoursePage course1 = new firstCoursePage(driver);
        Thread.sleep(5000);
        oldwindow=driver.getWindowHandle();
		course1.clickingCourse1();
		Set<String>handle=driver.getWindowHandles();
		for(String newwindow1:handle)
		{
			driver.switchTo().window(newwindow1);
		}
		System.out.println("Course-1");
		s.screen(driver,"firstCourse");
		Thread.sleep(2000);
		System.out.println("Course Name :"+course1.getCourseName());
		System.out.println("Course Duration :"+course1.getCourseDuration());
		System.out.println("Course Rating :"+course1.getCourseRating());
		driver.close();
		driver.switchTo().window(oldwindow);
		System.out.println("---------------------------------");
		Thread.sleep(6000);
	}
	
	@Test(priority=5,groups= {"regression","master"})
	public void secondCourse() throws InterruptedException, IOException {
		secondCoursePage course2 = new secondCoursePage(driver);
		course2.clickingCourse2();
		oldwindow=driver.getWindowHandle();
		Set<String>handles1=driver.getWindowHandles();
		for(String newwindow2:handles1)
		{
		driver.switchTo().window(newwindow2);
		}
		System.out.println("Course-2");
		s.screen(driver, "secondCourse");
		Thread.sleep(3000);
		System.out.println("Course Name :"+course2.getCourseName());
		System.out.println("Course Duration :"+course2.getCourseDuration());
		System.out.println("Course Rating :"+course2.getCourseRating());
		driver.close();
		driver.switchTo().window(oldwindow);
		System.out.println("---------------------------------");
	}
}
