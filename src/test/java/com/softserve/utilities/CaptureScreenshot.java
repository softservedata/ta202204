package com.softserve.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	public static void takeScreenshot(WebDriver driver, String methodName) {
		try {
			String directory = "./screenshots/";
			String timeTemplate = "yyyy-MM-dd_HH-mm-ss-S";
			String currentTime = new SimpleDateFormat(timeTemplate).format(new Date());
			String filename = methodName + "_" + currentTime + ".png";
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(directory + filename));
		} catch (Exception e) {
			System.out.println("Failed to place screenshot on failure");
		}
	}

}
