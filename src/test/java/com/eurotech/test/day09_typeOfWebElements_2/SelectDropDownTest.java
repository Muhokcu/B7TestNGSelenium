package com.eurotech.test.day09_typeOfWebElements_2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        //1- Locate your dropdown just like any other webElement with unique locator which has "select" tag name
        WebElement colorDropdown = driver.findElement(By.id("oldSelectMenu"));

        //2- Create select object by passing that elements as a constructor
        Select color = new Select(colorDropdown);

        //3- getOptions()--> returns all available options from the dropdown
        List<WebElement> colorList = color.getOptions();

        //4- Print size the list of options
        System.out.println("colorList.size() = " + colorList.size());

        //5- Verify the size
        Assert.assertEquals(colorList.size(), 11);

        //6- Print all the options one by one
        for (WebElement element : colorList) {
            System.out.println("element.getText() = " + element.getText());
        }

        //* Verify that the default color is RED --> getFirstSelectedOption()
        String expectedColor = "Red";
        String actualColor = color.getFirstSelectedOption().getText();
        Assert.assertEquals(actualColor, expectedColor, "Verify that default color is Red");


        // *** How to Select option from dropdown? ***

        //1- Select with visible text --> selectByVisibleText("")
        Thread.sleep(1000);
        color.selectByVisibleText("Yellow");// burda degisiyor

        expectedColor = "Yellow";
        actualColor = color.getFirstSelectedOption().getText();

        Assert.assertEquals(actualColor, expectedColor);

        //2- Select using Index --> selectByIndex();
        Thread.sleep(2000);
        color.selectByIndex(0);// burda degisiyor

        expectedColor = "Red";
        actualColor = color.getFirstSelectedOption().getText();
        Assert.assertEquals(actualColor, expectedColor);

        //3- Select by using Value --> selectByValue()
        Thread.sleep(2000);
        color.selectByValue("9");// burda degisiyor
        expectedColor = "Magenta";
        actualColor = color.getFirstSelectedOption().getText();

        Assert.assertEquals(actualColor, expectedColor);


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {


        Thread.sleep(2200);


        driver.close();
    }
}