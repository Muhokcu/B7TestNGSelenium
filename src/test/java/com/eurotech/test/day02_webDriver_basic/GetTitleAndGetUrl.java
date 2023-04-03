package com.eurotech.test.day02_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {
        /*Task => open chrome and navigation https://www.eurotechstudy.com/

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //driver.get("https://www.eurotechstudy.com/");
        driver.get("https://www.facebook.com/");
        // getting title with selenium=> getTitle()
        String title = driver.getTitle();
        //soutv +enter =>print variable name and value
        System.out.println("title = " + title);


        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";// Facebook - log in or sign up
        //
        String actualTitle = driver.getTitle();
        System.out.println("expectedTitle.equals(actualTitle) = " + expectedTitle.equals(actualTitle));

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        // get the url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        // get the source of the page
        String pageSource = driver.getPageSource();
        //System.out.println("pageSource = " + pageSource);

    }
}
