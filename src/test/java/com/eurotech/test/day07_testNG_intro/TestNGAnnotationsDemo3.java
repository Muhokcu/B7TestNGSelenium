package com.eurotech.test.day07_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo3 {

    @BeforeMethod
    public void setUp() {
        System.out.println("Open Browser");


    }

    @Test
    public void Test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("title", "title");// true =true => pass

        System.out.println("Second Assertion");
        Assert.assertEquals("url", "url");


    }

    @Test
    public void test2() {
        System.out.println("Test 2 Assertion");
        Assert.assertEquals("test2", "test2");
    }

    @Test
    public void test3() {
        String expectedTitle = "Ex";
        String actualTitle = "DevEx";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void test4() {
        //verify that email contains @ sign
        String email = "student@eurotech.com";
//        if (email.contains("@")){
//            System.out.println("PASSED");
//        }else{
//            System.out.println("FAILED");
//        }
        Assert.assertTrue(email.contains("@"));// expected => True

    }

    @Test
    public void test5() {
        Assert.assertFalse(0 > 1,"verify that 0 is NOt greater than 1");// expected => False

    }
    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    }


    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }
}
