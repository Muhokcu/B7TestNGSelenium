package com.eurotech.test.day10_typeOfWebElements_3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest3 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @Test
    public void twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //How to switch to iframe

        //first way using name or ID value
        driver.switchTo().frame("mce_0_ifr");

        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        Thread.sleep(1000);
        textArea.clear();
        textArea.sendKeys("Eurotech B7 is here");

        //second way switching with index
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        textArea.clear();
        textArea.sendKeys("Eurotech B7 is here second time");

        driver.switchTo().parentFrame();

        //third way using web Element
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        Thread.sleep(1000);
        textArea.clear();
        textArea.sendKeys("Eurotech B7 is here third time");
    }

    @Test
    public void nestedIframe() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //go to frame-top
        driver.switchTo().frame("frame-top"); //by name
        // driver.switchTo().frame(0); //by index

        // go to Middle frame
        driver.switchTo().frame("frame-middle");

        String textMiddle = driver.findElement(By.cssSelector("#content")).getText();
        System.out.println("textMiddle = " + textMiddle);

        //go to Right frame

        //1. go to parent frame
        //first way to go parent
        driver.switchTo().parentFrame(); //selenium sw,tvh to parent
        // driver.switchTo().frame("frame-top"); // NOT working

        // second way to go parent  => selenium switch to directly default
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("frame-top");

        //2. go to frame right
        //driver.switchTo().frame("frame-right");
        driver.switchTo().frame(2);

        String textRight = driver.findElement(By.tagName("body")).getText();
        System.out.println("textRight = " + textRight);

        //go to bottom frame and get text
        driver.switchTo().defaultContent(); // to go to first HTML/default

        // driver.switchTo().frame("frame-bottom");
        driver.switchTo().frame(1);
        String textBottom=driver.findElement(By.tagName("body")).getText();
        System.out.println("textBottom = " + textBottom);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        //driver.close();
        driver.quit();
    }
}