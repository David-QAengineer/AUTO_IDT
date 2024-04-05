package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Base;
import pageObjects.HomePage;

public class ScrollUpScrollDownTest extends Base {
    public HomePage homePage;

    @BeforeTest
    public void initialize()  {
        driver=initializeDriver();
        driver.get(loadProperties().getProperty("baseUrl"));
        homePage=new HomePage(driver);
    }

    @Test
    public void verifyHomePageIsVisible()  {
        Assert.assertEquals(homePage.getTitle(),"Automation Exercise", "Home page is not visible");
        homePage.scrollDownPage();
        Assert.assertTrue(homePage.checkSubscription(), "Subscription is not displayed");
        homePage.clickScrollUpButton();
        Assert.assertEquals(homePage.getFullFledgedText(), loadProperties().getProperty("fullFledgedText"),"Text is not visible");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
