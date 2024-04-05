package pageObjects;

import org.openqa.selenium.*;

import java.util.List;

public class ProductPage extends BasePage {

    By productButton = By.xpath("//a[@href='/products']");
    By checkAllProductsVisible = By.xpath("//h2[contains(text(),'All Products')]");
    By inputSearchProduct = By.id("search_product");
    By searchButton = By.id("submit_search");
    By checkSearchProductVisible = By.xpath("//h2[contains(text(),'Searched Products')]");

    By productInfo=By.className("productinfo");
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnProductButton() {
        clickOnWebElement(webDriver.findElement(productButton));
    }

    public boolean verifyAllProductsIsVisible() {
       return elementIsDisplayed(checkAllProductsVisible);
    }

    public void fillValueInSearch(String value) {
        fillValue(value, webDriver.findElement(inputSearchProduct));
    }

    public void clickOnSearchButton() {
        clickOnWebElement(webDriver.findElement(searchButton));
    }

    public boolean verifySearchProductIsVisible() {
       return elementIsDisplayed(checkSearchProductVisible);
    }

    public void checkProductsRelatedToSearch(String searchProductValue) {
        List<WebElement>products=webDriver.findElements(productInfo);
         for (WebElement product:products){
             assert product.getText().contains(searchProductValue);
             }
         }
    }


