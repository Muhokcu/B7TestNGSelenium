package com.eurotech.test.Internet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        WebElement cerez = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _al66 _4jy3 _4jy1 selected _51sy']"));
        cerez.click();
        WebElement mail = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
        mail.sendKeys("muhokcu@gmail.com");
        WebElement sifre = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']"));
        sifre.sendKeys("okcrgwagfwa");
        WebElement giris = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']"));
        giris.click();
        WebElement yaziSonucu= driver.findElement(By.className("_9ay7"));
        String expectedYaziSonucu="Girdiğin e-posta bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
        String actualYaziSonucu=yaziSonucu.getText();
        System.out.println(expectedYaziSonucu);
        System.out.println(actualYaziSonucu);
        if (expectedYaziSonucu.equals(actualYaziSonucu)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }



        driver.close();
    }
}
