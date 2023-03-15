package com.eurotech.test.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_StartsWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        WebElement understandBtn = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        understandBtn.click();
        //starts-with xptah=> //input[starts-with(@placeholder,'Email')]

        //CSS with starts-with
        WebElement userEmail = driver.findElement(By.cssSelector("input[placeholder^='Email']"));
        userEmail.sendKeys("valencia@eurotech.com");

        WebElement userPassword = driver.findElement(By.cssSelector("#loginpage-form-pw-input"));
        userPassword.sendKeys("Test1234");

        driver.findElement(By.cssSelector("input[class^='btn']")).click();

        Thread.sleep(2000);
        driver.close();

    }
}
