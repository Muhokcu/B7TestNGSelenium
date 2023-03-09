package com.eurotech.test.day02_webDriver_basic;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/");
        Thread.sleep(2000);
        driver.close();

        /**
         * go to DevEx website
         * expected title =devex
         * get title an verify that title is devex
         */

       driver = WebDriverFactory.getDriver("chorome");

        driver.get("http://eurotech.study/");
        String expectedTitle = "DevEx";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        Thread.sleep(2000);
        driver.close();

    }
}
