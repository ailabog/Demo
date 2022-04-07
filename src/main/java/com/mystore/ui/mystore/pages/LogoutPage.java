package com.mystore.ui.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mystore.utils.ui.WebDriverUtils;

/**
 * Logout from store
 */

public class LogoutPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(LogoutPage.class);

    private By signOutBtn = By.xpath("//a[@title='Log me out']");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void sign_out() {

        WebDriverUtils.clickOnElementWithWait(driver, signOutBtn);
        WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
    }
}
