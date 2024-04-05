package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.*;

import java.io.IOException;


public class PlaceOrderTest extends Base {
    public HomePage homePage;
    public PlaceOrder placeOrderPage;
    public LoginPage loginPage;

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        homePage = new HomePage(driver);
        placeOrderPage = new PlaceOrder(driver);
        loginPage = new LoginPage(driver);
        driver.get(loadProperties().getProperty("baseUrl"));
    }

    @Test
    public void placeOrderWithoutLogin(){
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(homePage.getTitle(), "Automation Exercise", "Home page is not visible");
        homePage.clickOnSignUpLogin();
        placeOrderPage.fillLoginEmail(loadProperties().getProperty("email"));
        placeOrderPage.fillPassword(loadProperties().getProperty("password"));
        placeOrderPage.clickOnLoginButton();
        Assert.assertEquals(placeOrderPage.loggedInAsUserNameIsTop(), "Logged in as " + loadProperties().getProperty("firstName"), "Top name is not correct.");
        placeOrderPage.addProducts();
        Assert.assertTrue(placeOrderPage.cartPageIsDisplayed(), "cart page is not displayed");
        placeOrderPage.clickOnCheckOutButton();

        softAssert.assertEquals(placeOrderPage.getFirstNameLastNameData(), loadProperties().getProperty("title") + " " +
                loadProperties().getProperty("firstName") + " " + loadProperties().getProperty("lastName"), "Username is not correct");
        softAssert.assertEquals(placeOrderPage.getCompanyName(), loadProperties().getProperty("company"), "Company name is not correct");
        softAssert.assertEquals(placeOrderPage.getAddress(), loadProperties().getProperty("address"), "Address is not correct");
        softAssert.assertEquals(placeOrderPage.getAddress2(), loadProperties().getProperty("address2"), "Address2 is not correct");
        softAssert.assertEquals(placeOrderPage.priceProduct(), "Rs. 400", "Price is not correct");
        softAssert.assertTrue(placeOrderPage.totalAmountIsVisible(), "Text total amount not visible" );
        softAssert.assertAll();

        placeOrderPage.fillAreaAndClickOrderButton("very good products");
        placeOrderPage.fillNameCard(loadProperties().getProperty("cardName"));
        placeOrderPage.fillNumberCard(loadProperties().getProperty("cardNumber"));
        placeOrderPage.fillCvs(loadProperties().getProperty("cvc"));
        placeOrderPage.fillDataCard(loadProperties().getProperty("dataMonth"), loadProperties().getProperty("dataYear"));
        placeOrderPage.clickPayButton();
        placeOrderPage.checkCongratulationsMessage("Congratulations! Your order has been confirmed!");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
