package identifyingcourses;

import org.testng.annotations.Test;

import pom.CourseraForCampusPage;
import pom.courserapage;
import utilities.ExcelUtility;
import utilities.Screenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ForEnterprise extends DriverSetup{
	
	Screenshot s;
	public ForEnterprise()
	{
		s=new Screenshot();
	}
	
	@Test(priority=0,groups= {"smoke","regression","master"})
	public void clickingEnterprise() throws InterruptedException, IOException {
		courserapage coursera = new courserapage(driver);
		WebElement community = driver.findElement(By.xpath("//*[contains(text(),'Community')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",community);
		Thread.sleep(3000);
		s.screen(driver, "forEnterprise");
		coursera.clickingEnterprise();
	}

	@Test(priority=1,groups= {"smoke","regression","master"})
	public void clickingCourseraForCampus() throws InterruptedException, IOException {
		courserapage coursera = new courserapage(driver);
		coursera.clickingSolutions();
		Thread.sleep(2000);
		s.screen(driver, "clickingSolutions");
		coursera.clickingCourseraForCampus();
		s.screen(driver, "clickingCourseraForCampus");
		Thread.sleep(4000);
	}
	
	@Test(priority=2,groups= {"regression","master"})
	public void readyToTransformForm() throws IOException {
		CourseraForCampusPage course = new CourseraForCampusPage(driver);
		ExcelUtility excel = new ExcelUtility();
		String[] formDetails = new String[5];
		formDetails = excel.readExcelData();
		WebElement scroll2 = driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/main/div/div[7]/div/div[2]/div/div/div/div/div/div[2]/div[2]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",scroll2);
		course.fname(formDetails[0]);
		course.lname1(formDetails[1]);
		course.setEmail(formDetails[2]);
		course.setPhone(formDetails[3]);
		Select institutiontype = new Select(course.InstitutionType());
		institutiontype.selectByVisibleText("University/4 Year College");
		course.setInstitution(formDetails[4]);
		Select JobRole = new Select(course.Jobrole());
		JobRole.selectByVisibleText("Professor");
		Select department = new Select(course.Department());
		department.selectByVisibleText("Teaching/Faculty/Research");
		Select describes = new Select(course.Describes());
		describes.selectByVisibleText("Learner Support");
		Select country = new Select(course.Country());
		country.selectByVisibleText("India");
		Select state = new Select(course.State());
		state.selectByVisibleText("Tamil Nadu");
		s.screen(driver, "fillingForm");
		WebElement scroll3 = driver.findElement(By.xpath("//*[contains(text(),'Get in touch with our sales team')]"));
		js.executeScript("arguments[0].scrollIntoView();",scroll3);
		WebElement button = driver.findElement(By.xpath("//button[@class='mktoButton']"));
		js.executeScript("arguments[0].click();", button);
		s.screen(driver, "errormessage");
	}
	
	@Test(priority=3, groups= {"regression","master"})
	public void gettingErrorMessage() throws InterruptedException {
		CourseraForCampusPage course = new CourseraForCampusPage(driver);
		Thread.sleep(4000);
		System.out.println(course.getErrorMessage());
	}
}
