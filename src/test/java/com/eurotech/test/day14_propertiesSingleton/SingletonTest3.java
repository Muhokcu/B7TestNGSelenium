package com.eurotech.test.day14_propertiesSingleton;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest3 {

//    @Test
//    public void test1(){
//      //  Singleton singleton=new Singleton();
//        String driver1=Singleton.getInstance();
//        String driver2=Singleton.getInstance();
//
//        System.out.println("s1 = " + driver1);
//        System.out.println("s2 = " + driver2);
//
//    }
//
//    @Test
//    public void test2() {
//      //  WebDriver driver=WebDriverFactory.getDriver("chrome");
//
//        WebDriver driver= Driver.get();
//
//      //  driver.get("https://www.amazon.co.uk/");
//        driver.get(ConfigurationReader.get("url"));
//
//        driver.close();
//    }

    @Test
    public void test3() throws InterruptedException {
        //  WebDriver driver=WebDriverFactory.getDriver("chrome");

        // WebDriver driver=Driver.get();
        Thread.sleep(2000);
        // driver.get("https://www.google.com/");
        // lazy way
        com.eurotech.utilities.Driver.get().get("https://www.google.com/");

    }

    @Test
    public void test4() throws InterruptedException {
        //WebDriver driver=WebDriverFactory.getDriver("chrome");

        WebDriver driver= Driver.get();
        Thread.sleep(2000);
        driver.get("https://www.amazon.co.uk/");
    }
}
