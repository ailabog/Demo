package com.mystore.ui.mystore.pages;

import com.mystore.utils.ui.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TShirtPage extends BasePage {

    private By qty = By.id("quantity_wanted");
    private By size = By.xpath("//select[@id='group_1']/option[@value='1']");
    private By addToCartBtn = By.xpath("//p[@id='add_to_cart']/button[@name='Submit']/span[contains(text(), 'Add to cart')]");
    private By proceedBtn = By.xpath("//a[@class='btn btn-default button button-medium']/span[contains(text(), 'Proceed to checkout')]");
    private By proceedBtn1 = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']/span[contains(text(), 'Proceed to checkout')]");
    private By viewShoppingCartBtn = By.xpath("//a[@title='View my shopping cart']");
    private By removeItem = By.xpath("//a[@title='Subtract']");
    private By msgEmptyCart = By.xpath("//p[@class='alert alert-warning']");

    public TShirtPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        WebDriverUtils.enterTextBox(driver, qty, "2");
        WebDriverUtils.clickOnElementWithWait(driver, size);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.moveToElement(driver, addToCartBtn);
        WebDriverUtils.clickOnElementWithWait(driver, addToCartBtn);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, proceedBtn);
    }

    public void checkout() {
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
        WebDriverUtils.clickOnElementWithWait(driver, proceedBtn1);
    }

    public void checkCart() {
        WebDriverUtils.clickOnElementWithWait(driver, viewShoppingCartBtn);
        WebDriverUtils.clickOnElementWithWait(driver, removeItem);
        WebDriverUtils.clickOnElementWithWait(driver, removeItem);
        WebDriverUtils.getElementText(driver, msgEmptyCart);
    }
}
