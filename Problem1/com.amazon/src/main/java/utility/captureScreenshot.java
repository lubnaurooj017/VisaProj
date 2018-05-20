package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class captureScreenshot extends businessClass{

	static String filePath = System.getProperty("user.dir") + "/Screenshots/";
	
	public static void captureScreenshotMethod(String screenshotName)
	{
		File scrFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(scrFile, new File(filePath + screenshotName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
