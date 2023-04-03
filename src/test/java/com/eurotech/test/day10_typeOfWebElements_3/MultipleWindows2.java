package com.eurotech.test.day10_typeOfWebElements_3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @Test
    public void twoWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();

//        String titleAfterClick=driver.getTitle();
//        System.out.println("titleAfterClick = " + titleAfterClick);

        String currentTab = driver.getWindowHandle(); // Title => The internet
        // and has ID Window-> 94E17EBC31B458F5CB74D5CFA1C39492
        // and has ID Window-> 5EB978AEB0E36DD165BD83C8138A1DC3
        // 45F872F8CE7F24DCA4C9578F0155A49C
        System.out.println("currentTab = " + currentTab);

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) { // go and check one by one
            System.out.println("tab = " + tab);
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }

    @Test
    public void multipleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);
        String currentTab = driver.getWindowHandle();
        System.out.println("currentTab = " + currentTab);
        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        click_here.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
//            if (driver.getTitle().equals("New Window")){
//                System.out.println("driver.getTitle() = " + driver.getTitle());
//                System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
//            }
            if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new")) {
                System.out.println("driver.getTitle() = " + driver.getTitle());
                System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
                break;
            }

        }

        System.out.println("driver.getTitle() = " + driver.getTitle());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        //driver.close();
        driver.quit();
    }
}
