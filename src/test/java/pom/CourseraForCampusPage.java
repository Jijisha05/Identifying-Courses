package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseraForCampusPage extends BaseClass{

	public CourseraForCampusPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="FirstName") WebElement firstname;
    @FindBy(id="LastName") WebElement lastname;
    @FindBy(id="Email") WebElement email;
    @FindBy(id="Phone") WebElement phone;
    @FindBy(id="Institution_Type__c") WebElement institutionType;
    @FindBy(id="Company") WebElement institution;
    @FindBy(id="Title") WebElement jobRole;
    @FindBy(id="Department") WebElement department;
    @FindBy(id="What_the_lead_asked_for_on_the_website__c") WebElement describes;
    @FindBy(id="Country") WebElement country;
    @FindBy(id="State") WebElement state;
    @FindBy(xpath="//*[@class='mktoErrorMsg']") WebElement errormsg;
    
    public void fname(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void lname1(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void setEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void setPhone(String Phone) {
		phone.sendKeys(Phone);
	}

	public WebElement InstitutionType() {
		return institutionType;
	}
	
	public void setInstitution(String Institution) {
		institution.sendKeys(Institution);
	}
	
	public WebElement Jobrole() {
		return jobRole;
	}
	
	public WebElement Department() {
		return department;
	}
	
	public WebElement Describes() {
		return describes;
	}
	
	public WebElement Country() {
		return country;
	}
	
	public WebElement State() {
		return state;
	}
	
	public String getErrorMessage() {
		return errormsg.getText();
	}
	
}
