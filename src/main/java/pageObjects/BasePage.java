package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
import java.util.*;
public class BasePage {
    public WebDriver webDriver;
    public WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofMillis(30));
    }

    public void fillValue(String value, WebElement element) {
        waitVisibilityOfElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void clickOnWebElement(WebElement element) {
        scrollIntoElement(element);
        waitElementToBeClickable(element);
        element.click();
    }

    public boolean elementIsDisplayed(By locator) {
        return webDriver.findElement(locator).isDisplayed();
    }

    public String getElementText(By locator) {
        return webDriver.findElement(locator).getText().trim();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void selectRandomOption(By locator) {
        WebElement selectElement = webDriver.findElement(locator);
        Select select = new Select(selectElement);
        List<WebElement> options = select.getOptions();
        int index = new Random().nextInt(options.size());
        select.selectByIndex(index);
    }

    public void waitVisibilityOfElement(WebElement element) throws TimeoutException {
        this.wait.until((ExpectedConditions.visibilityOf(element)));
    }

    public void waitElementToBeClickable(WebElement element) throws TimeoutException {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollIntoElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}


