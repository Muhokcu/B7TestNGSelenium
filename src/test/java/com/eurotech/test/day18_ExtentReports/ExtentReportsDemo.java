package com.eurotech.test.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportsDemo {
    //This class is used for starting and building report;
    ExtentReports report;

    //This class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //This will define a test, enable adding logs, authors and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        //initialize the class
        report=new ExtentReports();

        //project path
        String projectPath=System.getProperty("user.dir");
        //path for report
        String path= projectPath + "/test-output/report.html";

        //initialize the html report with the report path
        htmlReporter=new ExtentHtmlReporter(path);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        // title in report
        htmlReporter.config().setReportName("Eurotech smoke test");

        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Muhammet O");

    }

    @Test
    public void test1(){
        //give a name to the current test
        extentLogger= report.createTest("TC001 Login Test");

        //Test steps
        extentLogger.info("Open the Browser");
        extentLogger.info("Go to url http://eurotech.study/login");
        extentLogger.info("Login as Teacher");
        extentLogger.info("Enter Teacher userEmail");
        extentLogger.info("Enter Teacher password");
        extentLogger.info("Click login button");
        extentLogger.info("Verify logged in");
        extentLogger.info("TC001 Login Test is passed");

    }

    @AfterMethod
    public void tearDown() {
        report.flush();
    }

}
