package com.ea.ui.horizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ea.utils.ui.WebDriverUtils;

/**
 * This page is designed to logged the user from the account
 * 
 * @author abogasieru@contractor.ea.com
 *
 */

public class SignOutPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(SignOutPage.class);

	private By signOutArrow = By.xpath("//img[@alt='This is caret icon']");
	private By signOutBtn = By.xpath("//button[@type='Submit']");
	
	public SignOutPage(WebDriver driver) {
		super(driver);
	}

	public void sign_out() {
		logger.info("Now I am logging out from horizon");
		WebDriverUtils.clickOnElementWithWait(driver, signOutArrow);
		WebDriverUtils.clickOnElementWithWait(driver, signOutBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_20_SECONDS);
		logger.info("I am successfully logged out");
	}
}
