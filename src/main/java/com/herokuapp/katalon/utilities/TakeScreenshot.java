package com.herokuapp.katalon.utilities;

import com.herokuapp.katalon.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TakeScreenshot {

    public static void takeScreenshot(String testName) {
        try{
        File file = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        String screenshotName = testName + DateFormatUtils.format(new Date(), " hh.mm.dd.MM.yyyy") + ".png";
        FileUtils.copyFile(file, new File("build/tmp/Screenshots" + screenshotName));}
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
