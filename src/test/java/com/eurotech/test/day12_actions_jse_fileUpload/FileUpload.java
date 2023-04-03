package com.eurotech.test.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void fileUploadTest1() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:/Users/user/OneDrive/Desktop/Batch_7.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualText = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualText, "Batch_7.txt");


    }

    @Test
    public void fileUploadTest2() throws InterruptedException {
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        // System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        //System.out.println("System.getenv(\"Path\") = " + System.getenv("Path"));

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/EuroTech_Batch7.txt";
        String fullPath = projectPath + "/" + filePath;
        System.out.println("fullPath = " + fullPath);


        chooseFile.sendKeys(fullPath);
        Thread.sleep(2000);
        driver.findElement(By.id("file-submit")).click();
        String actualText = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualText, "EuroTech_Batch7.txt");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}

