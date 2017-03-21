package com.extentreports.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import org.testng.annotations.Test;

/**
 * Created by phanvantho on 3/21/17.
 */
public class testExtentReports {

    @Test
    public void test() {
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();

        // create ExtentX
        ExtentXReporter extentxReporter = new ExtentXReporter("localhost", 27017);
        extentxReporter.setAppendExisting(true);
        extentxReporter.config().setProjectName("projectName3");
        extentxReporter.config().setReportName("reportName3");
        extentxReporter.config().setServerUrl("http://localhost:1337");

        // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

        // add reporters to extentx
        extent.attachReporter(htmlReporter, extentxReporter);

        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("MyFirstTest3", "Sample description3");

        test.pass("1");
        test.pass("2");
        test.pass("3");
        test.pass("4");
        test.pass("5");

        // calling flush writes everything to the log file
        extent.flush();
    }
}
