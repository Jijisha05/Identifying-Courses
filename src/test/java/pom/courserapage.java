package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class courserapage extends BaseClass{
	
	public courserapage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@class='react-autosuggest__input']")
	WebElement searchtxt;
    @FindBy(xpath="//img[@class='rc-CourseraLogo' ]")
    WebElement coursera;
    @FindBy(xpath="//input[@class='react-autosuggest__input']")
	WebElement searchtxt1;
    @FindBy(linkText="For Enterprise")
    WebElement enterprise;
    @FindBy(xpath="//*[@id=\"rendered-content\"]/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div/div/div/div[2]/div/div[2]/a/p")
    WebElement courseraForCampus;
    @FindBy(linkText="Solutions")
    WebElement solutions;
    
    
	public void clickSearchBox(String val) {
		searchtxt.sendKeys(val,Keys.ENTER);
	}
	
	public void homePage() {
		coursera.click();
	}
	
	public void searchingLanguageLearning(String name) {
		searchtxt1.sendKeys(name,Keys.ENTER);
	}
	
	public void clickingEnterprise() {
		enterprise.click();
	}
	
	public void clickingSolutions() {
		solutions.click();
	}
	
	public void clickingCourseraForCampus() {
		courseraForCampus.click();
	}
	
}
