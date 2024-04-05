package pageObjects;

import org.openqa.selenium.*;

import java.util.List;


public class PlaceOrder extends BasePage {
    By loginEmail = By.cssSelector("[data-qa=login-email]");
    By password = By.cssSelector("[data-qa=login-password]");
    By loginButton = By.cssSelector("[data-qa=login-button]");
    By loggedInAsUser = By.xpath("//i[@class='fa fa-user']//parent::a");
    By chooseItem = By.className("add-to-cart");
    By cartButton = By.xpath("(//a[@href='/view_cart'])[2]");
    By cartInfo = By.className("cart_info");
    By checkOut = By.className("check_out");
    By textArea = By.className("form-control");
    By placeOrderButton = By.xpath("//a[@href='/payment']");
    By nameCard = By.cssSelector("[data-qa=name-on-card]");
    By numberCard = By.cssSelector("[data-qa=card-number]");
    By cvcNum = By.cssSelector("[data-qa=cvc]");
    By monthData = By.cssSelector("[data-qa=expiry-month]");
    By yearData = By.cssSelector("[data-qa=expiry-year]");
    By payButton = By.cssSelector("[data-qa=pay-button]");
    By confirmationMessage = By.cssSelector("h2[data-qa='order-placed']");
    By price = By.className("cart_price");
    By totalAmountEl = By.xpath("//tr/td[@colspan='2']/h4/b");
    By username = By.className("address_firstname");

    By address1 = By.className("address_address1");


    public PlaceOrder(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillLoginEmail(String value) {
        fillValue(value, webDriver.findElement(loginEmail));
    }

    public void fillPassword(String value) {
        fillValue(value, webDriver.findElement(password));
    }

    public void clickOnLoginButton() {
        clickOnWebElement(webDriver.findElement(loginButton));
    }

    public String loggedInAsUserNameIsTop() {
        return getElementText(loggedInAsUser);
    }

    public void addProducts() {
        List<WebElement> items = webDriver.findElements(chooseItem);
        WebElement firstItem = items.get(2);
        clickOnWebElement(firstItem);
        clickOnWebElement(webDriver.findElement(cartButton));
    }

    public boolean cartPageIsDisplayed() {
        return elementIsDisplayed(cartInfo);
    }

    public void clickOnCheckOutButton() {
        clickOnWebElement(webDriver.findElement(checkOut));
    }


    public String getFirstNameLastNameData() {
        return getElementText(username);
    }

    public String getCompanyName() {
        return webDriver.findElements(address1).get(0).getText().trim();
    }

    public String getAddress() {
        return webDriver.findElements(address1).get(1).getText().trim();
    }

    public String getAddress2() {
        return webDriver.findElements(address1).get(2).getText().trim();
    }

    public void fillAreaAndClickOrderButton(String text) {
        fillValue(text, webDriver.findElement(textArea));
        clickOnWebElement(webDriver.findElement(placeOrderButton));
    }

    public void fillNameCard(String value) {
        fillValue(value, webDriver.findElement(nameCard));
    }

    public void fillNumberCard(String value) {
        fillValue(value, webDriver.findElement(numberCard));
    }

    public void fillCvs(String value) {
        fillValue(value, webDriver.findElement(cvcNum));
    }

    public void fillDataCard(String month, String year) {
        fillValue(month, webDriver.findElement(monthData));
        fillValue(year, webDriver.findElement(yearData));
    }

    public void clickPayButton() {
        clickOnWebElement(webDriver.findElement(payButton));
    }

    public String checkCongratulationsMessage(String text) {
        return getElementText(confirmationMessage);

    }

    public String priceProduct() {
        return getElementText(price);
    }

    public boolean totalAmountIsVisible() {
        return elementIsDisplayed(totalAmountEl);
    }


}
