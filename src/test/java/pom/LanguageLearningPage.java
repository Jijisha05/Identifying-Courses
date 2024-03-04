package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageLearningPage extends BaseClass {

	public LanguageLearningPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@data-testid=\"search-filter-group-Level\"]/div/div//span[@class=\"cds-checkboxAndRadio-labelContent css-imksha\"]/span")
	List<WebElement> level;
    @FindBy(xpath="//div[@class='css-11krhap']/div[@id='checkbox-group']/div//div/span/span")
    List<WebElement> language;
    @FindBy(xpath="/html/body/div[7]/div[3]/div/div/div[2]/div[3]/button[1]")
    WebElement apply;
    
    public List<WebElement> levelCount(){
		return level;
	}
	
	public List<WebElement> languageCount(){
		return language;
	}
	
	public void clickingApply() {
		apply.click();
	}
}
