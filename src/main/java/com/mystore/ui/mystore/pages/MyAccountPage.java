package com.mystore.ui.mystore.pages;

import com.mystore.utils.ui.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page that contains all the elements for Sign In page and its methods:
 * returning customer, create account
 * Create Account page
 */

public class MyAccountPage extends BasePage {

    private By signOutBtn = By.xpath("//a[@title='Log me out']");
    private By authenticationLabel = By.xpath("//h1[text(contains(), 'Authentication')]");
    private By signInBtn = By.xpath("//a[@title='Log in to your customer account']");


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    public SignOutPage returnSignOutPage() {
        WebDriverUtils.clickOnElementWithWait(driver, signOutBtn);
        WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
                ExpectedConditions.invisibilityOfElementLocated(authenticationLabel));
        return new SignOutPage(driver);
    }

}
