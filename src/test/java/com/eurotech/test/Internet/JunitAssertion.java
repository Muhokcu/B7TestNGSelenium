package com.eurotech.test.Internet;

import com.eurotech.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JunitAssertion {
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url2"));
        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());
        WebElement signUp = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUp.click();
        WebElement LogintoAccount = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(LogintoAccount.isDisplayed());
        WebElement emailAdres = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailAdres.sendKeys(ConfigurationReader.get("usernameDeveloper"));
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys(ConfigurationReader.get("passwordDeveloper"));
        WebElement login = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        login.click();
        WebElement logged = driver.findElement(By.xpath(" //a[text()=' Logged in as '] "));
        System.out.println(logged.getText());


        Assert.assertTrue(logged.isDisplayed());
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        String expectedUrl="https://automationexercise.com/login";
        System.out.println(expectedUrl);
        String actualUrl=driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);


        Thread.sleep(2000);
        driver.close();


    }
}
