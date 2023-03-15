package com.eurotech.test.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_Class {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        understandBtn.click();

        WebElement userEmail = driver.findElement(By.cssSelector("input#loginpage-input-email"));
        userEmail.sendKeys("CSS with ID with TagName");
        WebElement userPassword = driver.findElement(By.cssSelector("#loginpage-form-pw-input"));
        userPassword.sendKeys("CSS with ID");

        //CSS with class
        String loginPageWarnText = driver.findElement(By.cssSelector(".my-1")).getText();
        System.out.println("loginPageWarnText = " + loginPageWarnText);

        //CSS with class (with space)
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        Thread.sleep(2000);

        driver.close();


    }
}
