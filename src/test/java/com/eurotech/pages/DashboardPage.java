package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{


    @FindBy(id = "dashboard-h1")
    public WebElement dashboardText;

    @FindBy(xpath = "//p[contains(text(),'Welcome')]")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    public WebElement jobTitle;

    public String getTitle(String title){
        return Driver.get().findElement(By.xpath("//td[text()='"+title+"']")).getText();
    }

    public  String getCompany(String companyName){
        return Driver.get().findElement(By.xpath("//td[text()='"+companyName+"']")).getText();
    }
    //We combined the two methods above in BasePage Class as getCommonText().
}
