package com.eurotech.test.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest1 {
    public static void main(String[] args) throws InterruptedException {
        Faker faker= new Faker();
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();


        WebElement inputUserName = driver.findElement(By.id("userName"));
        inputUserName.sendKeys(faker.name().firstName());

        WebElement inputUserEmail = driver.findElement(By.id("userEmail"));
        inputUserEmail.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);

        driver.close();
    }
}
