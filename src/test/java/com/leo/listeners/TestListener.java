package com.leo.listeners;

import com.leo.base.BaseTest;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    @Attachment(
            value = "Screenshot",
            type = "image/png"
    )
    public byte[] attach(byte[] screenshot){

        return screenshot;

    }

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();

        WebDriver driver =
                ((BaseTest)testClass).driver;

        File src =
                ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.FILE);

        try{

            FileUtils.copyFile(
                    src,
                    new File(
                            "screenshots/"
                                    + result.getName()
                                    + ".png"
                    )
            );

        }catch(IOException e){

            e.printStackTrace();

        }
        attach(
                ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.BYTES)
        );

    }

}