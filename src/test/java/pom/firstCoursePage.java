
package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class firstCoursePage extends BaseClass {
	
	public firstCoursePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(linkText="Meta Front-End Developer")
	WebElement course1;
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[1]/div[1]/section/h1")
	WebElement coursename;
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[3]/div[1]")
	WebElement courseDuration;
	@FindBy(xpath="//*[@id='rendered-content']/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]")
	WebElement courseRating;
	
	public void clickingCourse1() {
		course1.click();
	}
	
	public String getCourseName() {
		return coursename.getText();
	}
	
	public String getCourseDuration() {
		return courseDuration.getText();
	}

	public String getCourseRating() {
		return courseRating.getText();
	}
}
