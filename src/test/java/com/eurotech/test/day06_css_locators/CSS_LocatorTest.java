package com.eurotech.test.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_LocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#loginpage-input-email")).sendKeys("eurotech@gmail.com");
        Thread.sleep(2000);
        WebElement sifre = driver.findElement(By.cssSelector("#loginpage-form-pw-input"));
        sifre.sendKeys("Test12345!");

        driver.findElement(By.cssSelector("#loginpage-form-btn")).click();

        Thread.sleep(2000);
        driver.close();

    }
}
