package com.eurotech.test.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_AttributeValue {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        understandBtn.click();
        //CSS with Attribute & Value
        WebElement userEmail = driver.findElement(By.cssSelector("[type='email']"));
        userEmail.sendKeys("valencia@eurotech.com");
        //CSS with Attribute & Value with tagName
        WebElement userPassword = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        userPassword.sendKeys("Test1234");

        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
