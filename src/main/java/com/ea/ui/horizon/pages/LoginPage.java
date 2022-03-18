package com.ea.ui.horizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;


import com.ea.utils.ui.WebDriverUtils;

public class LoginPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

	private By emailAddressField = By.id("email");
	private By pswdField = By.id("password");
	private By signInBtn = By.xpath("//button[contains(text(), 'Sign In')]");

	private By orgMngmtBtn = By
			.xpath("//div[contains(text(), 'Organization Management')]");
	private By userMngmtBtn = By.xpath("//div[contains(text(), 'User Management')]");
	private By partnerMngmtBtn = By
			.xpath("//div[contains(text(), 'Partner Access Management')]");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String email, String pswd) {
		logger.info("loging into horizon..");
		WebDriverUtils.enterTextBox(driver, emailAddressField, email);
		WebDriverUtils.enterTextBox(driver, pswdField, pswd);
	}

	public DashboardPage returnDashboardPage() {
		WebDriverUtils.clickOnElementWithWait(driver, signInBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_20_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(orgMngmtBtn));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_20_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(userMngmtBtn));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_20_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(partnerMngmtBtn));
		return new DashboardPage(driver);
	}
}
