package com.eurotech.test.day17_POM_3;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.PostsPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    PostsPage postsPage = new PostsPage();
    @Test
    public void verifyList() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in is successful");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        List<String> actualList=new ArrayList<>();
        for (WebElement menu : dashboardPage.menuList) {
            System.out.println("menu.getText() = " + menu.getText());
            actualList.add(menu.getText());
        }
        Assert.assertEquals(actualList,expectedList,"Verify that the lists are matched");
    }

    @Test
    public void verifyList2() {
        //Use BrowserUtils in this test
        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in is successful");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        //1st way -- Lazy way
        //Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.menuList),expectedList);

        //2nd way
        List<String> actualList= BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(actualList,expectedList);
    }

    @Test
    public void navigateToSubmenu() {
        /** Class Task
         *  Go to http://eurotech.study/login
         *  Login with teacher credentials
         *  Navigate to My Posts and verify that submit button is visible then
         *  Navigate to Log Out and verify that log out successfully
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        String expectedText = "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText);

        //Navigate to My Posts and verify that submit button is visible
        dashboardPage.navigateToMenu("My Account");
        dashboardPage.navigateToSubmenu("My Posts");
        Assert.assertTrue(postsPage.submitBtn.isDisplayed(),"Verify that the submit button is visible");
        //BrowserUtils.verifyElementDisplayed(postsPage.submitBtn);

        //Navigate to Log Out and verify that log out successfully
        dashboardPage.navigateToMenu("My Account");
        dashboardPage.navigateToSubmenu("Logout");
        Assert.assertTrue(loginPage.loginBtn.isDisplayed());
        // BrowserUtils.verifyElementDisplayed(loginPage.loginBtn);


    }
}
