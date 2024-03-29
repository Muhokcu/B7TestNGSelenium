package com.eurotech.test.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        /** Class TAsk 3
         * open chrome browser
         * go to http://eurotech.study/login
         * enter email as "eurotech@gmail.com"
         * enter password Test12345!
         * click login btn
         * verify that welcome message is "Welcome Teacher"
         * */


        String email = "eurotech@gmail.com";
        String password = "Test12345!";
        String expectedText = "Welcome Teacher";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();


        //enter email
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys(email);
        Thread.sleep(2000);


        //enter password
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys(password);
        Thread.sleep(2000);


        //click on login button
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        Thread.sleep(2000);


        WebElement welcomeText = driver.findElement(By.id("dashboard-p1"));
        System.out.println("welcomeText = " + welcomeText.getText());

        String actulText = welcomeText.getText();


        if (expectedText.equals(actulText)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
