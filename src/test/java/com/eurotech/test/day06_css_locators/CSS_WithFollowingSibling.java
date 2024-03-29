package com.eurotech.test.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_WithFollowingSibling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        WebElement understandBtn = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        understandBtn.click();
        //following sibling with xptah
        String xpathText = driver.findElement(By.xpath("//form[@class='form']/following-sibling::p")).getText();
        System.out.println("xpathText = " + xpathText);

        //following sibling with css
        String cssText = driver.findElement(By.cssSelector("[class='form']~p")).getText();
        System.out.println("cssText = " + cssText);

        Thread.sleep(2000);
        driver.close();

    }
}
