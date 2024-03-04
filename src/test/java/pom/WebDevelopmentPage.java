package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebDevelopmentPage extends BaseClass{

	public WebDevelopmentPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@placeholder='Search for Language']")
	WebElement selectlanguagetxt;
	@FindBy(xpath="//*[@id='checkbox-group']/div/label/span")
	WebElement selectEnglish;
    @FindBy(xpath="/html/body/div[7]/div[3]/div/div/div[2]/div[3]/button[1]")
    WebElement apply;
    
    public void filteringEnglish(String name) {
		selectlanguagetxt.sendKeys(name);
	}
	
	public void clickingEnglish() {
		selectEnglish.click();
	}
	
	public void clickingApply() {
		apply.click();
	}
}
