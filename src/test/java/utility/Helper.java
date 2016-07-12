package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

	public static String captureScreenshot(WebDriver driver,
			String screenshotName) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = "C:\\Workspace_FeDoraSchool_30May\\com.learnautomation.hybrid\\Screenshots\\"
				+ screenshotName + System.currentTimeMillis() + ".png";

		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {

			System.out.println("Failed to capture screenshots "
					+ e.getMessage());
		}

		return destination;
	}

	public static WebElement highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript(
				"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
				element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript(
				"arguments[0].setAttribute('style','border: solid 2px white');",
				element);

		return element;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String datenew= dateFormat.format(date);
		 
		 return datenew;
	}

}
