package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public void screen(WebDriver driver,String name) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source1=screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"\\Screenshots\\"+name+".png");
		FileHandler.copy(source1,destination);
	}
}
