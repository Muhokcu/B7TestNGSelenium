package com.eurotech.test.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonTask {

    /**
     * Class Task
     * go to the amazon webpage
     * write "selenium" to search box
     * verify that the result of the search
     * please use xpath locator
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.co.uk/");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='accept']")).click();

        String product="Selenium";

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(product);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String actualText = driver.findElement(By.xpath("//span[contains(text(),'results for')]/..")).getText();

        System.out.println("actualText = " + actualText);

        if (actualText.contains(product)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        driver.close();


    }
}