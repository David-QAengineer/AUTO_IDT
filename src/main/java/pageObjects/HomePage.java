package pageObjects;

import org.openqa.selenium.*;

public class HomePage extends BasePage {

    By textNewUserSignUp = By.xpath("//h2[contains(text(),'New User Signup!')]");
    By signupLoginTab = By.xpath("//a[@href='/login']");
    By scrollToSub = By.xpath("//h2[text()='Subscription']");
    By scrollUp = By.className("fa-angle-up");
    By fullFledgedText = By.xpath("//div[@class='col-sm-6']/h2");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnSignUpLogin() {
        clickOnWebElement(webDriver.findElement(signupLoginTab));
    }

    public boolean isNewUserSignUpIsVisible() {
        return webDriver.findElement(textNewUserSignUp).isDisplayed();
    }

    public void scrollDownPage() {
        scrollIntoElement(webDriver.findElement(scrollToSub));
    }

    public boolean checkSubscription() {
        return webDriver.findElement(scrollToSub).isDisplayed();
    }

    public void clickScrollUpButton() {
        clickOnWebElement(webDriver.findElement(scrollUp));
    }

    public String getFullFledgedText() {
        return webDriver.findElement(fullFledgedText).getText();
    }
}


