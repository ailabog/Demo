package com.mystore.ui.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.mystore.utils.ui.WebDriverUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

    private By signInBtn = By.xpath("//a[@title='Log in to your customer account']");
    private By createAccountBtn = By.id("SubmitCreate");
    private By loginBtn = By.id("SubmitLogin");
    private By inputEmail = By.id("email_create");
    private By fNameInput = By.id("customer_firstname");
    private By lNameInput = By.id("customer_lastname");
    private By pswdInput = By.id("passwd");
    private By searchInput = By.id("search_query_top");
    private By searchBtn = By.xpath("//button[@name='submit_search']");
    private By imgTshirt = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
    private By TshirtLabel = By.xpath("//h1[contains(text(), 'Faded Short Sleeve T-shirts')]");
    private By emailField = By.id("email");
    private By addToCartBtn = By.xpath("//p[@id='add_to_cart']/button[@name='Submit']/span[contains(text(), 'Add to cart')]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToSignIn() {
        WebDriverUtils.clickOnElementWithWait(driver, signInBtn);
    }


    public void searchProduct(String productValue) {
        WebDriverUtils.enterTextBox(driver, searchInput, productValue);
        WebDriverUtils.clickOnElementWithWait(driver, searchBtn);
    }

    public CreateAccountPage returnCreateAccountPage(String email) {
        WebDriverUtils.enterTextBox(driver, inputEmail, email);
        WebDriverUtils.moveToElement(driver, createAccountBtn);
        WebDriverUtils.clickOnElementWithWait(driver, createAccountBtn);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(fNameInput));
        return new CreateAccountPage(driver);
    }

    public SignInPage returnSignInPage() {
        WebDriverUtils.clickOnElementWithWait(driver, signInBtn);
        return new SignInPage(driver);
    }

    public TShirtPage returnTshirtPage() {
        WebDriverUtils.clickOnElementWithWait(driver, imgTshirt);
        return new TShirtPage(driver);
    }
}
