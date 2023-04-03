package com.eurotech.test.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void clickWithJS() {
        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();
        driver.manage().window().maximize();

        WebElement germany = driver.findElement(By.linkText("Germany"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", germany);

    }

    @Test
    public void typeWithJS() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        String text = "EuroTech Batch_7";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", inputBox);
        // https://stackoverflow.com/questions/25583641/set-value-of-input-instead-of-sendkeys-selenium-webdriver-nodejs *// yukardaki kodlari buldugumuz site siteden bir cok konuda bilgi alinabilir

        Thread.sleep(2000);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {

        driver.get("https://www.amazon.co.uk/");
        driver.manage().window().maximize();
        driver.findElement(By.id("sp-cc-accept")).click();
        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("window.scrollBy(0,1000)");// sayfa icinde kaydirma yapiyor
        for (int i = 0; i < 9; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,500)");


        }
        for (int i = 0; i < 9; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,-500)");

        }
    }

    @Test
    public void scrollToElement() throws InterruptedException {

        driver.get("https://www.amazon.co.uk/");
        driver.manage().window().maximize();
        driver.findElement(By.id("sp-cc-accept")).click();
        Thread.sleep(2000);

        WebElement germany = driver.findElement(By.linkText("Germany"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", germany);
        jse.executeScript("arguments[0].click();", germany);



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.close();
    }

}