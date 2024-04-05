package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

import java.io.IOException;
import java.util.Random;

public class RegisterUserTest extends Base {
    public Base base;
    public HomePage homePage;
    public LoginPage loginPage;

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        driver.get(loadProperties().getProperty("baseUrl"));
        base=new Base();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void registerUserTest(){
        Random random = new Random();
        int random_numbers = random.nextInt(233435);
        final String email = "david.sargsyan" + random_numbers + "@gmail.com";

        Assert.assertEquals(homePage.getTitle(),"Automation Exercise", "Home page is not visible.");
        homePage.clickOnSignUpLogin();
        Assert.assertTrue(homePage.isNewUserSignUpIsVisible(), "Message is not correct.");
        loginPage.fillName(base.loadProperties().getProperty("name"));
        loginPage.fillEmail(email);
        loginPage.clickSignUpButton();
        Assert.assertTrue(loginPage.checkTextEnterAccountInfo(), "Text is not visible.");
        loginPage.chooseGenderTitle(loadProperties().getProperty("title"));
        loginPage.fillUserName(base.loadProperties().getProperty("name"));
        loginPage.fillUserPassword(base.loadProperties().getProperty("password"));
        loginPage.selectDataOfBirth();
        loginPage.clickCheckBox1();
        loginPage.clickCheckBox2();
        loginPage.fillFirstName(base.loadProperties().getProperty("firstName"));
        loginPage.fillLastName(base.loadProperties().getProperty("lastName"));
        loginPage.fillCompany(base.loadProperties().getProperty("company"));
        loginPage.fillAddress(base.loadProperties().getProperty("address"));
        loginPage.fillAddress_2(base.loadProperties().getProperty("address2"));
        loginPage.chooseCountry(base.loadProperties().getProperty("country"));
        loginPage.fillState(base.loadProperties().getProperty("state"));
        loginPage.fillCity(base.loadProperties().getProperty("city"));
        loginPage.fillZipcode(base.loadProperties().getProperty("zipCode"));
        loginPage.fillPhoneNumber(base.loadProperties().getProperty("phoneNumber"));
        loginPage.clickOnCreatAccountButton();

        Assert.assertEquals(loginPage.getAccountCreatedText(),"ACCOUNT CREATED!");
        loginPage.clickOnContinueButton();
        Assert.assertTrue(loginPage.loggedInAsUserName(),"Message 'Logged in as username' is not visible.");
        loginPage.clickOnDeletedButton();
        Assert.assertEquals(loginPage.getAccountDeletedText(),"ACCOUNT DELETED!", "Text is not correct");
        loginPage.clickOnContinueButton();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
