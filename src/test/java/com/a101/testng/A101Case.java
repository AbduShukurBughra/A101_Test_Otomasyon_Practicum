package com.a101.testng;

import com.a101.BasePage;
import com.a101.testutility.ConfigurationReader;
import com.a101.testutility.TestUtility;
import com.a101.ui.CartPage;
import com.a101.ui.CheckOutPage;
import com.a101.ui.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class A101Case extends BasePage {
    static DashboardPage dashboardPage;
    static CartPage cartPage;
    static CheckOutPage checkOutPage;
    static TestUtility testUtility;
    static String url = ConfigurationReader.readConfigProperties("url");

    @BeforeClass(alwaysRun = true)
    public static void setUp(){
        setUpBrowser(url);
        dashboardPage = new DashboardPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        testUtility = new TestUtility(driver);
    }

    @Test
    public static void dashBoardPageSteps(){
        dashboardPage.dashboardPageActions();
        Assert.assertTrue(dashboardPage.isSocksBlack());
    }

    @Test(dependsOnMethods = "dashBoardPageSteps")
    public static void cartPageSteps(){
        cartPage.cartPageActions();
    }

    @Test(dependsOnMethods = "cartPageSteps")
    public static void checkOutPageActions(){
        checkOutPage.checkOutPage();
        Assert.assertTrue(checkOutPage.verifyMessage());
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown(){
        teardown();
    }
}