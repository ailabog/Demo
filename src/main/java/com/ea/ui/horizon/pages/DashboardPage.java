package com.ea.ui.horizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.ea.utils.ui.WebDriverUtils;

public class DashboardPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);

	private By orgMngmtBtn = By.xpath("//div[contains(text(), 'Organization Management')]");
	private By userMngmtBtn = By.xpath("//div[contains(text(), 'User Management')]");
	private By partnerMngmtBtn = By.xpath("//div[contains(text(), 'Partner Access Management')]");

	private By orgMngmtNav = By.xpath("//div[contains(text(), 'ORGANIZATION MANAGEMENT')]");
	private By userMngmtNav = By.xpath("//div[contains(text(), 'USER MANAGEMENT')]");
	private By partnerMngmtNav = By.xpath("//div[contains(text(), 'PARTNER ACCESS MANAGEMENT')]");

	protected DashboardPage(WebDriver driver) {
		super(driver);
	}

	public String orgLinksAreDisplayed(String orgText) {
		if (orgMngmtBtn != null) {
			logger.info("Organisation Mngmt link is displayed..");
			orgText = WebDriverUtils.getElementText(driver, orgMngmtBtn);
		}
		return orgText;
	}

	public String userLinksAreDisplayed(String userText) {
		if (userMngmtBtn != null) {
			logger.info("User Mngmt link is displayed..");
			userText = WebDriverUtils.getElementText(driver, userMngmtBtn);

		}
		return userText;
	}

	public String partnerLinksAreDisplayed(String partnerText) {
		if (orgMngmtBtn != null) {
			logger.info("Partner Mngmt link is displayed..");
			partnerText = WebDriverUtils.getElementText(driver, partnerMngmtBtn);
		}
		return partnerText;
	}

	public OrgMngmtPage returnOrgMngmtPage() {
		WebDriverUtils.clickOnElementWithWait(driver, orgMngmtBtn);
		 WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_500_MILLISECONDS);
	     WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_60_SECONDS,
	             ExpectedConditions.visibilityOfElementLocated(orgMngmtNav));
		return new OrgMngmtPage(driver);
	}

	public UserMngmtPage returnUserMngmtPage() {
		WebDriverUtils.clickOnElementWithWait(driver, userMngmtBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_500_MILLISECONDS,
				ExpectedConditions.visibilityOfElementLocated(userMngmtNav));
		return new UserMngmtPage(driver);
	}

	public PartnerMngmtPage returnPartnerMngmtPage() {
		WebDriverUtils.clickOnElementWithWait(driver, partnerMngmtBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_500_MILLISECONDS,
				ExpectedConditions.visibilityOfElementLocated(partnerMngmtNav));
		return new PartnerMngmtPage(driver);
	}
}
