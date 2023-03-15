package com.eurotech.test.day05_;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTask {

    /**
     * Class Task
     * go to the amazon webpage
     * write "selenium" to search box
     * verify that the result of the search
     * please use xpath locator
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
        WebElement cerez = driver.findElement(By.xpath("//input[@name='accept']"));
        cerez.click();
        WebElement search = driver.findElement(By.xpath("//input[@aria-label='Ara Amazon.com.tr']"));
        search.sendKeys("Selenium");
        WebElement searchBtn = driver.findElement(By.xpath("//input[@value='Git']"));
        searchBtn.click();


        String sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().toLowerCase();
        System.out.println("sonuc = " + sonuc);

        if (sonuc.contains("selenium")) {

            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        Thread.sleep(2000);
        driver.close();
    }
}