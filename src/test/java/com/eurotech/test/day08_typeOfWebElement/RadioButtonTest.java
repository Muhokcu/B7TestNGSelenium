package com.eurotech.test.day08_typeOfWebElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {


    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");
        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));
      //  System.out.println("vegetablesRadio.isSelected() = " + vegetablesRadio.isSelected());
        Assert.assertTrue(vegetablesRadio.isSelected(),"Verify that vegetableRadio is selected");
        WebElement legumesRadio = driver.findElement(By.xpath("//div[text()='Legumes']/../input"));
        Assert.assertFalse(legumesRadio.isSelected(),"Verifey that legumesRadio is NOT selected");
        //legumesRadio.click();//ElementNotInteractableException: element not interactable hatasi verdi
        WebElement legumesClickable =driver.findElement(By.xpath("//div[text()='Legumes']/../div"));
        legumesClickable.click();
        Thread.sleep(3000);
        Assert.assertTrue(legumesRadio.isSelected());
        Assert.assertFalse(vegetablesRadio.isSelected());


        driver.close();


    }
}
