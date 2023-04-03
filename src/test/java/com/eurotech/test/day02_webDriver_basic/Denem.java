package com.eurotech.test.day02_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Denem {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.getTitle();

        String title = driver.getTitle();
        System.out.println("title = " + title);

        WebElement cookis = driver.findElement(By.xpath("//div[@class='QS5gu sy4vM'][1]"));
        Thread.sleep(3000);

        cookis.click();

        Thread.sleep(3000);
        driver.close();


    }
}
