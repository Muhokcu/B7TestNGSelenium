package com.eurotech.test.day13_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverOverText1 {
    /**
     * Hover class Task
     * go to https://the-internet.herokuapp.com/hovers url
     * and get "view profile" elements' text (all of them)
     * and verify element is displayed (one by one)
     * <p>
     * hind: Use list and for loop
     */


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void hoverTask() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        // WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));
        List<WebElement> imgList = driver.findElements(By.tagName("img"));
        System.out.println("imgList.size() = " + imgList.size());// size=4
        for (int i = 2; i <= imgList.size(); i++) {
            String imgXpath = "(//img)[" + i + "]";
            System.out.println("imgXpath = " + imgXpath);
            WebElement img = driver.findElement(By.xpath(imgXpath));
            //   WebElement imgNormal = driver.findElement(By.xpath("(//img)[" + i + "]"));
            Actions actions = new Actions(driver);
            Thread.sleep(2000);
            actions.moveToElement(img).perform();
            String textPath = "//h5[.='name: user" + (i - 1) + "']";
            System.out.println("textPath = " + textPath);
            WebElement text = driver.findElement(By.xpath(textPath));
            Assert.assertTrue(text.isDisplayed(), "Verify that the user " + (i - 1) + " is displayed ");
            System.out.println("Verify that the user " + (i - 1) + " is displayed ");
        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }
}