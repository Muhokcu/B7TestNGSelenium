package com.eurotech.test.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));
        //*******************************
        // Actions => class that contains all user interactions
        Actions actions = new Actions(driver);//
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();//burda fareyei harekt ettiriyor //  movetoElement(img1) > moves to the webElement
        //******************************

        WebElement viewProfile1 = driver.findElement(By.linkText("View profile"));
        System.out.println("viewProfile1 = " + viewProfile1.getText());
        Assert.assertTrue(viewProfile1.isDisplayed(), "Verify that the element is displayed");
        /**  Hover class Task
         *      go to https://the-internet.herokuapp.com/hovers url
         *      and get "view profile" elements' text (all of them)
         *      and verify element is displayed (one by one)
         *
         *      hind: Use list and for loop
         */


    }

    @Test
    public void dragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);

        actions.dragAndDrop(source, target).perform();

        WebElement verifyMessage = driver.findElement(By.xpath("//p[.='Dropped!']"));
        System.out.println("verifyMessage = " + verifyMessage);


        //first way
       // Assert.assertEquals(verifyMessage.getText(),"Dropped!", "Verify that the element has been dropped");


        //second way
        Assert.assertTrue(verifyMessage.isDisplayed());




    }
    @Test
    public void dragAndDrop2() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);

        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();

        WebElement verifyMessage = driver.findElement(By.xpath("//p[.='Dropped!']"));
        System.out.println("verifyMessage = " + verifyMessage);


        //first way
        // Assert.assertEquals(verifyMessage.getText(),"Dropped!", "Verify that the element has been dropped");


        //second way
        Assert.assertTrue(verifyMessage.isDisplayed());

    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
