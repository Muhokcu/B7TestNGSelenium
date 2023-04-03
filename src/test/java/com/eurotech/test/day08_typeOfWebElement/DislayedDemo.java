package com.eurotech.test.day08_typeOfWebElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DislayedDemo {
    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton= driver.findElement(By.cssSelector("#start>button"));
        WebElement hello= driver.findElement(By.xpath("//*[.='Hello World!']"));
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());

        Assert.assertFalse(hello.isDisplayed(),"verify that hello world! is NOT displayed");
        startButton.click();
        Thread.sleep(8000);
        System.out.println("---------------------");
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());


        Assert.assertTrue(hello.isDisplayed());
        System.out.println("hello.getText() = " + hello.getText());
       // driver.close();
    }
    @Test
    public void test2() throws InterruptedException {
        //odev
        /**
         * Class Task
         * go to https://the-internet.herokuapp.com/dynamic_loading/2
         * see Example 2: Element rendered after the fact -->click
         * Then do this task;
         *    verify that hello world is not displayed
         *    click start button
         *    verify that hello element is displayed
         *    and verify that "Hello World!" text is present
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");


        //Assert.assertFalse(hello.isDisplayed());
        WebElement startButton= driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        Thread.sleep(6000);

        WebElement hello= driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(hello.isDisplayed());

        //driver.close();
    }
}
