package com.eurotech.pages;

import com.eurotech.test.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends TestBase {


    @FindBy(name = "githubusername")
    public WebElement githubusername;
    @FindBy(linkText = "Go Back")
    public WebElement goBackBnt;


}
