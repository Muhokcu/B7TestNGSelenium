package com.eurotech.test.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenBrowser {
    public static void main(String[] args) {
        // we have to enter this line, if we want to open chrome/firefox/safari ...
        WebDriverManager.chromedriver().setup();
        // WebDriver represent the browser, we are creating driver for chrome browser
        WebDriver driver = new ChromeDriver();// polymorphism


        driver.get("https://www.google.com");
        //  driver.get("https://www.amazon.com.tr/");
        //  driver.get("https://www.euroTechStudy.com/");
        //  driver.get("https://www.ebay-kleinanzeigen.de/");
        // driver.get("https://github.com/");


    }
}
