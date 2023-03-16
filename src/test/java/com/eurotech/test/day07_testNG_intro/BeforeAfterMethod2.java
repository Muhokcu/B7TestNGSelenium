package com.eurotech.test.day07_testNG_intro;

import org.testng.annotations.*;

public class BeforeAfterMethod2 {
    @BeforeClass
    public void setUpClass() {
        System.out.println("--------- Before Class----------");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("********* Before Method **********");
        System.out.println("WebDriver, Opening Browser");
    }

    @Test
    public void vtest1() {//3.
        System.out.println("First Test Case");
    }

    //@Test  @Ignore yaparsak // eger bu testi calistirmak istemiyorsak comment yapilabilir  @Ignore yapabiliriz ignore sadece testi etkiler ignore kullanilmali
    public void Atest2() {//1.
        System.out.println("Second Test Case");
    }

    @Test
    public void Ztest3() {//2.
        System.out.println("Third Test Case");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("*********** After Method ***********");
        System.out.println("Closing Browser, quit");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("------------After Class----------");
    }
}
