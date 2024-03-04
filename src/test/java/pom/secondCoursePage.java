package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class secondCoursePage extends BaseClass{
	
	public secondCoursePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(linkText="Introduction to Web Development")
	WebElement course2;
	@FindBy(xpath="/html/body/div[2]/div/main/section[2]/div/div/div[1]/div[1]/section/div/div[1]/h1")
	WebElement courseName;
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/section/div/div[3]/div/div/div[2]")
	WebElement courseDuration;
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/section/div/div[1]/div/div/div[1]")
	WebElement courseRating;
	
	public void clickingCourse2() {
		course2.click();
	}
	
	public String getCourseName() {
		return courseName.getText();
	}
	
	public String getCourseDuration() {
		return courseDuration.getText();
	}
	
	public String getCourseRating() {
		return courseRating.getText();
	}
	
}
