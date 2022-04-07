package com.mystore.ui.mystore.pages;

import com.mystore.utils.ui.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This page contains all the elements on Create Account page and its methods:
 * create account, mark options and links with My Account page
 */

public class CreateAccountPage extends BasePage {

    private By radioBtn = By.xpath("//input[@id='id_gender1']");
    private By fNameInput = By.id("customer_firstname");
    private By lNameInput = By.id("customer_lastname");
    private By emailInput = By.id("email");
    private By pswdInput = By.id("passwd");
    private By fNameAddressInput = By.id("firstname");
    private By lNameAddressInput = By.id("lastname");
    private By companyInput = By.id("company");
    private By addressInput = By.id("address1");
    private By cityInput = By.id("city");
    private By stateInput = By.id("id_state");
    private By zipCodeInput = By.id("postcode");
    private By countryInput = By.id("id_country");
    private By mobilePhoneInput = By.id("phone_mobile");
    private By aliasAddressInput = By.xpath("//input[@value='My address']");
    private By registerBtn = By.id("submitAccount");
    private By MyAccountLabel = By.xpath("//h1[text(contains(), 'My account')]");
    private By dayOption = By.xpath("//select[@id='days']/option[@value='1']");
    private By monthOption = By.xpath("//select[@id='months']/option[@value='1']");
    private By yearOption = By.xpath("//select[@id='years']/option[@value='1985']");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void createAccount(String firstName, String lastName, String pswd, String addressFName, String addressLName, String address,
                              String company, String city, String state, String zipCode, String country, String mobilePhone, String aliasAddress) {

        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, fNameInput, firstName);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, lNameInput, lastName);
        WebDriverUtils.moveToElement(driver, pswdInput);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, pswdInput, pswd);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, dayOption);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, monthOption);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, yearOption);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, fNameAddressInput, addressFName);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, lNameAddressInput, addressLName);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, addressInput, address);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, companyInput, company);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, cityInput, city);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.selectVisibleText(driver, stateInput, state);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, zipCodeInput, zipCode);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.selectVisibleText(driver, countryInput, country);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, mobilePhoneInput, mobilePhone);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.enterTextBox(driver, aliasAddressInput, aliasAddress);
    }

    public MyAccountPage returnMyAccountPage() {
        WebDriverUtils.clickOnElementWithWait(driver, registerBtn);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(MyAccountLabel));
        return new MyAccountPage(driver);
    }
}

