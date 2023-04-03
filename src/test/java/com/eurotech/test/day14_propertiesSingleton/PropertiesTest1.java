package com.eurotech.test.day14_propertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest1 {

    @Test
    public void test1(){
        String browser= ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);

        String url=ConfigurationReader.get("url");
        System.out.println("url = " + url);
    }

    @Test
    public void openBrowserUsingConfigurationReader() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("loginpage-input-email")).sendKeys(ConfigurationReader.get("usernameTeacher"));
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys(ConfigurationReader.get("passwordTeacher") +Keys.ENTER);

        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void testname(){
        WebDriver driver1=WebDriverFactory.getDriver("chrome");
        driver1.get("https://www.amazon.co.uk/");

        WebDriver driver2=WebDriverFactory.getDriver("chrome");
        driver2.findElement(By.id("sp-cc-accept")).click();
    }


}
