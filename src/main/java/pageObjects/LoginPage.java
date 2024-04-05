package pageObjects;

import org.openqa.selenium.*;

import java.util.List;

public class LoginPage extends BasePage {

    By nameElement = By.cssSelector("[data-qa='signup-name']");
    By emailElement = By.cssSelector("[data-qa='signup-email']");
    By signUpButton = By.cssSelector("[data-qa='signup-button']");
    By textEnterAccountInformation = By.className("text-center");
    By genderTitleElem = By.className("radio-inline");
    By nameUser = By.cssSelector("[data-qa=name]");
    By passwordUser = By.cssSelector("[data-qa=password]");
    By birthDay = By.id("days");
    By birthMonth = By.id("months");
    By birthYear = By.id("years");
    By firstNameElement = By.cssSelector("[data-qa=first_name]");
    By lastNameElement = By.cssSelector("[data-qa=last_name]");
    By company = By.cssSelector("[data-qa=company]");
    By address = By.cssSelector("[data-qa=address]");
    By address2 = By.cssSelector("[data-qa=address2]");
    By countryElement = By.cssSelector("[data-qa=country] > option");
    By state = By.cssSelector("[data-qa=state]");
    By city = By.cssSelector("[data-qa=city]");
    By zipcode = By.cssSelector("[data-qa=zipcode]");
    By phoneNumber = By.cssSelector("[data-qa=mobile_number]");
    By greatAccountButton = By.cssSelector("[data-qa=create-account]");
    By checkAccountCreated = By.cssSelector("[data-qa=account-created]");
    By continueButton = By.cssSelector("[data-qa=continue-button]");
    By checkLogged = By.className("fa-user");
    By deletedLink = By.xpath("//a[@href='/delete_account']");
    By checkAccountDeleted = By.cssSelector("[data-qa=account-deleted]");
    By checkBoxNewsletter = By.xpath("//label[@for='newsletter']");
    By checkBoxReceiveSpecial = By.xpath("//label[@for='optin']");


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillName(String value) {
        fillValue(value, webDriver.findElement(nameElement));
    }

    public void fillEmail(String value) {
        fillValue(value, webDriver.findElement(emailElement));
    }

    public void clickSignUpButton() {
        clickOnWebElement(webDriver.findElement(signUpButton));
    }

    public boolean checkTextEnterAccountInfo() {
        return elementIsDisplayed(textEnterAccountInformation);
    }

    public void chooseGenderTitle(String genderTitle) {
        List<WebElement> gendersElem = webDriver.findElements(genderTitleElem);
        for (WebElement genderEl : gendersElem) {
            if (genderEl.getText().trim().equals(genderTitle)) {
                clickOnWebElement(genderEl);
                break;
            }
        }
    }

    public void fillUserName(String value) {
        if (webDriver.findElement(nameUser).isDisplayed()) {
            fillValue(value, webDriver.findElement(nameUser));
        }
    }

    public void fillUserPassword(String value) {
        if (webDriver.findElement(nameUser).isDisplayed()) {
            fillValue(value, webDriver.findElement(passwordUser));
        }
    }

    public void selectDataOfBirth() {
        selectRandomOption(birthDay);
        selectRandomOption(birthMonth);
        selectRandomOption(birthYear);
    }

    public void clickCheckBox1() {
        clickOnWebElement(webDriver.findElement(checkBoxNewsletter));
    }

    public void clickCheckBox2() {
        clickOnWebElement(webDriver.findElement(checkBoxReceiveSpecial));
    }


    public void fillFirstName(String value) {
        fillValue(value, webDriver.findElement(firstNameElement));
    }

    public void fillLastName(String value) {
        fillValue(value, webDriver.findElement(lastNameElement));
    }

    public void fillCompany(String value) {
        fillValue(value, webDriver.findElement(company));
    }

    public void fillAddress(String value) {
        fillValue(value, webDriver.findElement(address));
    }

    public void fillAddress_2(String value) {
        fillValue(value, webDriver.findElement(address2));
    }

    public void chooseCountry(String countryName) {
        final List<WebElement> countries = webDriver.findElements(countryElement);
        for (WebElement country : countries) {
            if (country.getText().equals(countryName)) {
                clickOnWebElement(country);
                break;
            }
        }

    }

    public void fillState(String value) {
        fillValue(value, webDriver.findElement(state));
    }

    public void fillCity(String value) {
        fillValue(value, webDriver.findElement(city));
    }

    public void fillZipcode(String value) {
        fillValue(value, webDriver.findElement(zipcode));
    }

    public void fillPhoneNumber(String value) {
        fillValue(value, webDriver.findElement(phoneNumber));
    }

    public void clickOnCreatAccountButton() {
        clickOnWebElement(webDriver.findElement(greatAccountButton));
    }

    public String getAccountCreatedText() {
        return getElementText(checkAccountCreated);
    }

    public String getAccountDeletedText() {
        return getElementText(checkAccountDeleted);
    }


    public void clickOnContinueButton() {
        clickOnWebElement(webDriver.findElement(continueButton));
    }

    public boolean loggedInAsUserName() {
        return elementIsDisplayed(checkLogged);
    }

    public void clickOnDeletedButton() {
        clickOnWebElement(webDriver.findElement(deletedLink));
    }

}
