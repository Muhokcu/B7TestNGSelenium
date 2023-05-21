package com.eurotech.test.Internet;

import com.eurotech.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebElemen03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url1"));
        List<WebElement> button = driver.findElements(By.tagName("button"));
        System.out.println(button.size());
        for (WebElement each : button
        ) {
            System.out.println(each.getText());

        }


        Thread.sleep(3000);
        driver.close();

    }
}
