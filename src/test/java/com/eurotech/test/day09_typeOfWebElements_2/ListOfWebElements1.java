package com.eurotech.test.day09_typeOfWebElements_2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfWebElements1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();


    }
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/");
        // we saved 44 webElements into list
        List<WebElement> menuList = driver.findElements(By.xpath("//a[text()='A/B Testing']/../../li"));

        //getting size gives us the axact element number of list
        System.out.println("menuList.size() = " + menuList.size());


        int expectedSize =44;
        int actualSize = menuList.size();
        Assert.assertEquals(actualSize,expectedSize,"verify that the size is 44");

        System.out.println("menuList.get(0) = " + menuList.get(0).getText());
        //print all elements of the list 
        // iter + Enter --
        for (WebElement element : menuList) {
            System.out.println("element.getText() = " + element.getText());

        }

    }
    @Test
    public void test2(){
        driver.get("https://demoqa.com/elements");
        // task ---> go  to this url verify that 6 elements are there
        List<WebElement> menuList= driver.findElements(By.cssSelector(".header-text"));
        System.out.println("menuList.size() = " + menuList.size());
        int expectedSize =6;
        int actualSize = menuList.size();
        Assert.assertEquals(actualSize,expectedSize, "verify that menu list size is 6");
        for (WebElement element : menuList) {
            System.out.println("element.getText() = " + element.getText());
            Assert.assertTrue(element.isDisplayed());// selenium  will all element in the list

        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {


        Thread.sleep(2200);


       driver.close();
    }
}
