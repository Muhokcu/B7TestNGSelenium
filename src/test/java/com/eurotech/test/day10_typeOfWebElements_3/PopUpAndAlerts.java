package com.eurotech.test.day10_typeOfWebElements_3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void PopUp() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=37ab5");
        //click the Confirm Button
        driver.findElement(By.xpath("//span[.='Confirm']")).click();

        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

        Thread.sleep(3000);
        String expectedMessage = "You have accepted";
        driver.findElement(By.xpath("//p[text()='You have accepted']")).click();


    }

    @Test
    public void jsAlerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);


        //click => Click for JS Alert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        //e.g. : swirtch to JS alrt button
        Alert alert = driver.switchTo().alert();// bska bir html e geciyor gecis yapiyor
        Thread.sleep(2000);
        //click to ok
        alert.accept();

        //click => Click for JS Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        // click to cansel
        alert.dismiss();
        Thread.sleep(2000);


        //click => Click for JS Prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        //------
        System.out.println("alert.getText() = " + alert.getText());
        // send keys to JS Prompt
        alert.sendKeys("B7 is here");
        Thread.sleep(2000);
        alert.accept();


        // homework : verify all result above JS alert
        // home task**********
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
}
