package com.eurotech.test.day14_propertiesSingleton;

import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {
    /** Class
     * go to url
     * enter username
     * enter password
     * click login button
     */


    @Test
    public void testName() {
        driver.get(ConfigurationReader.get("url"));//url i okumak icin burayi kullaniyoruz
        WebElement usernameInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher") + Keys.TAB+ Keys.TAB+Keys.ENTER);

    }




    @Test
    public void test(){
//        WebDriver driver1= WebDriverFactory.getDriver("chrome");
//        WebDriver driver2= WebDriverFactory.getDriver("chrome");

        WebDriver driver1= Driver.get();
        WebDriver driver2= Driver.get();

        driver1.get("http://eurotech.study/login");
        driver2.findElement(By.id("loginpage-input-email")).sendKeys("B7  is here");
    }
}
