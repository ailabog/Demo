package com.mystore.ui.mystore.pages;

import com.mystore.utils.ui.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page that contains all the elements for Sign In page and its methods:
 * returning customer, create account, forgot password & check order & links to
 * Create Account page
 *
 */

public class SignInPage extends BasePage {


	private By inputEmail = By.id("email");
	private By pswdInput = By.id("passwd");
	private By signBtn = By.id("SubmitLogin");
	private By signOutBtn = By.xpath("//a[@title='Log me out']");


	public SignInPage(WebDriver driver) {
		super(driver);
	}

	public void login(String emailValue, String passwordValue) {
		WebDriverUtils.enterTextBox(driver, inputEmail, emailValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
		WebDriverUtils.enterTextBox(driver, pswdInput, passwordValue);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, signBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_60_SECONDS);
	}

	public SignOutPage returnSignOutPage() {
		WebDriverUtils.clickOnElementWithWait(driver, signOutBtn);
		return new SignOutPage(driver);
	}
}
