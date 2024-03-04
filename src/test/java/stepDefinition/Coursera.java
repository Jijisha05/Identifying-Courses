package stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.CourseraForCampusPage;
import pom.LanguageLearningPage;
import pom.WebDevelopmentPage;
import pom.courserapage;
import pom.firstCoursePage;
import pom.secondCoursePage;
import utilities.ExcelUtility;

public class Coursera {
    
	public static WebDriver driver;
	
	
	@Given("user navigates to Coursera website")
	public void user_navigates_to_coursera() throws InterruptedException {
		int browser;
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Select a browser");
		System.out.println("1.Chrome     2.Edge");
		browser=sc.nextInt();
		if(browser==1)
			driver = new ChromeDriver();
		else if(browser==2)
			driver=new EdgeDriver();
		else
			System.out.println("Invalid Browser");
		driver.manage().deleteAllCookies();
		driver.get("https://www.coursera.org/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
	}
	
	@When("searches for Web Development Courses")
	public void searches_for_web_development_courses() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		ExcelUtility excel = new ExcelUtility();
		courserapage coursera = new courserapage(driver);
		coursera.clickSearchBox(excel.readDataweb());
	}

	@When("level is selected as beginner")
	public void level_is_selected_as_beginner() throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(6000);
		WebElement level=driver.findElement(By.xpath("//*[contains(text(), 'Level')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",level);
		Thread.sleep(3000);
		WebElement levelcheckbox=driver.findElement(By.xpath("//span[@class='cds-checkboxAndRadio-labelContent css-imksha']//*[contains(text(),'Beginner')]"));
		js.executeScript("arguments[0].click();", levelcheckbox);
	}

	@When("language is selected as English")
	public void language_is_selected_as_english() throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		WebDevelopmentPage web = new WebDevelopmentPage(driver);
		Thread.sleep(3000);
		WebElement languages=driver.findElement(By.xpath("//*[contains(text(), 'Language')]"));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView();",languages);
		Thread.sleep(3000);
		WebElement languageshowmore=driver.findElement(By.xpath("//*[@id='search-results-header-wrapper']/div/div[1]/div/div[2]/div[2]/button/span"));
		js1.executeScript("arguments[0].click();", languageshowmore);
		Thread.sleep(3000);
		web.filteringEnglish("English");
		Thread.sleep(3000);
		web.clickingEnglish();
		Thread.sleep(3000);
		web.clickingApply();
	}

	@Then("get first course details")
	public void get_first_course_details() throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(4000);
		WebElement gotop=driver.findElement(By.xpath("//*[@class='rc-SearchResultsHeader']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",gotop);
		firstCoursePage course1 = new firstCoursePage(driver);
		Thread.sleep(5000);
		String oldwindow = driver.getWindowHandle();
		course1.clickingCourse1();
		Set<String>handle=driver.getWindowHandles();
		for(String newwindow1:handle)
		{
			driver.switchTo().window(newwindow1);
		}
		System.out.println("Course-1");
		Thread.sleep(2000);
		System.out.println("Course Name :"+course1.getCourseName());
		System.out.println("Course Duration :"+course1.getCourseDuration());
		System.out.println("Course Rating :"+course1.getCourseRating());
		driver.close();
		driver.switchTo().window(oldwindow);
		System.out.println("---------------------------------");
		Thread.sleep(6000);
	}

	@Then("get second course details")
	public void get_second_course_details() throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		secondCoursePage course2 = new secondCoursePage(driver);
		course2.clickingCourse2();
		String oldwindow = driver.getWindowHandle();
		Set<String>handles1=driver.getWindowHandles();
		for(String newwindow2:handles1)
		{
			driver.switchTo().window(newwindow2);
		}
		System.out.println("Course-2");
		Thread.sleep(3000);
		System.out.println("Course Name :"+course2.getCourseName());
		System.out.println("Course Duration :"+course2.getCourseDuration());
		System.out.println("Course Rating :"+course2.getCourseRating());
		driver.close();
		driver.switchTo().window(oldwindow);
		System.out.println("---------------------------------");	

	}
 
	@Given("user navigates to the home page")
	public void user_navigates_to_the_home_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(6000);
		courserapage coursera = new courserapage(driver);
		coursera.homePage();
	}

	@When("searches for Language Learning")
	public void searches_for_language_learning() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		courserapage coursera = new courserapage(driver);
		Thread.sleep(6000);
		coursera.searchingLanguageLearning("Language Learning");
	}

	@Then("count of levels available is taken")
	public void count_of_levels_available_is_taken() {
		// Write code here that turns the phrase above into concrete actions
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

	@Then("count of languages available is taken")
	public void count_of_languages_available_is_taken() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
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
		lang.clickingApply();	}

	@Given("user navigates back to the home page")
	public void user_navigates_back_to_the_home_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(6000);
		courserapage coursera = new courserapage(driver);
		coursera.homePage();
	}

	@Given("clicks for enterprise")
	public void clicks_for_enterprise() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		courserapage coursera = new courserapage(driver);
		WebElement community = driver.findElement(By.xpath("//*[contains(text(),'Community')]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",community);
		Thread.sleep(3000);
		coursera.clickingEnterprise();
	}

	@When("solution is selected")
	public void solution_is_selected() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		courserapage coursera = new courserapage(driver);
		coursera.clickingSolutions();
		Thread.sleep(2000);
	}

	@When("clicks coursera for campus")
	public void clicks_coursera_for_campus() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		courserapage coursera = new courserapage(driver);
		coursera.clickingCourseraForCampus();
		Thread.sleep(4000);
	}

	@Then("fills ready to transform form")
	public void fills_ready_to_transform_form() throws IOException {
		// Write code here that turns the phrase above into concrete actions
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
	
	}

	@Then("clicks submit button")
	public void clicks_submit_button() {
		// Write code here that turns the phrase above into concrete actions
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement scroll3 = driver.findElement(By.xpath("//*[contains(text(),'Get in touch with our sales team')]"));
		js.executeScript("arguments[0].scrollIntoView();",scroll3);
		WebElement button = driver.findElement(By.xpath("//button[@class='mktoButton']"));
		js.executeScript("arguments[0].click();", button);
	}

	@Then("captures error message")
	public void captures_error_message() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		CourseraForCampusPage course = new CourseraForCampusPage(driver);
		Thread.sleep(4000);
		System.out.println(course.getErrorMessage());
	    driver.quit();
	}
}

