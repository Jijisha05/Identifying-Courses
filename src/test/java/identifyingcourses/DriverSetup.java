package identifyingcourses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class DriverSetup {

	public static WebDriver driver;
	
	@BeforeTest(groups = {"smoke","regression","master"})
	@Parameters("browser")
	public void launchBrowser(String Browser) throws InterruptedException {
				
		switch(Browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		default:
			System.out.println("No matching browser");
		}
			
		driver.manage().deleteAllCookies();
		driver.get("https://www.coursera.org/");
		//Thread.sleep(20000);
		driver.manage().window().maximize();
	}
	
	@AfterTest(groups = {"smoke","regression","master"})
	public void closeBrowser() {
		driver.quit();
	}
}
