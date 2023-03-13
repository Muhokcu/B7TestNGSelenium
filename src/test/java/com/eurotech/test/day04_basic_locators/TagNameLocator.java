package com.eurotech.test.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.manage().window().maximize();


        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        //1st way
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Test12345!");

        //2nd way-lazy way
        //driver.findElement(By.name("password")).sendKeys("Test12345!");

        //1st way
        WebElement loginButton= driver.findElement(By.id("loginpage-form-btn"));
        loginButton.click();

        //2nd way-lazy way
        //driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(2000);

        //verify that Experience Credentials is here/displayed
        WebElement verifyExperienceCredentials = driver.findElement(By.tagName("h2"));
        System.out.println("verifyExperienceCredentials.getText() = " + verifyExperienceCredentials.getText());

        Thread.sleep(4000);

        driver.get("http://the-internet.herokuapp.com/inputs");

        System.out.println("driver.findElement(By.tagName(\"h3\")) = " + driver.findElement(By.tagName("h3")).getText());
        System.out.println("driver.findElement(By.tagName(\"p\")) = " + driver.findElement(By.tagName("p")).getText());


        driver.close();

    }
}
