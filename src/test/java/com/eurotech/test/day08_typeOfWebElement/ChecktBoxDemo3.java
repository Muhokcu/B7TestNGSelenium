package com.eurotech.test.day08_typeOfWebElement;

import com.eurotech.utilities.WebDriverFactory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChecktBoxDemo3 {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        Assert.assertTrue(checkBox2.isSelected(), "verify .............");
        Assert.assertFalse(checkBox1.isSelected(), "verify.............");
        Thread.sleep(2000);
        checkBox1.click();
        Thread.sleep(2000);

        checkBox2.click();
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertFalse(checkBox2.isSelected());
        Thread.sleep(2000);


        driver.close();


    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
//        Dimension dem = new Dimension(1200,1000);
//        driver.manage().window().setSize(dem);

        WebElement sports = driver.findElement(By.id("hobbies-checkbox-1"));
        Assert.assertFalse(sports.isSelected());

        WebElement reading = driver.findElement(By.id("hobbies-checkbox-2"));
        Assert.assertFalse(reading.isEnabled());

        WebElement music = driver.findElement(By.id("hobbies-checkbox-3"));
        Assert.assertFalse(music.isSelected());

        // Class Task
        // complete the task
        // click all the checkboxes
        // then assert that is selected or not

        // This webElement is NOT suitable to click
        //sports.click();

        WebElement sportsCheck= driver.findElement(By.cssSelector("[for='hobbies-checkbox-1']"));

        sportsCheck.click();
        Thread.sleep(2000);
        Assert.assertTrue(sports.isSelected(),"Verify that sport is selected");

        driver.close();

    }


}
