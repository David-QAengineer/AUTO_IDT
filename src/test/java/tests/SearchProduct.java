package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

public class SearchProduct extends Base {
    public HomePage homePage;
    public ProductPage productPage;

    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
        driver.get(loadProperties().getProperty("baseUrl"));
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void searchProduct() {
        final String searchProductValue = "Sleeves";
        Assert.assertEquals(homePage.getTitle(), "Automation Exercise", "Home page is not visible");
        productPage.clickOnProductButton();
        Assert.assertTrue(productPage.verifyAllProductsIsVisible(), "All products is not visible");
        productPage.fillValueInSearch(searchProductValue);
        productPage.clickOnSearchButton();
        Assert.assertTrue(productPage.verifySearchProductIsVisible(), "Searched products is not visible");
        productPage.checkProductsRelatedToSearch(searchProductValue);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
