package com.ea.ui.horizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ea.utils.ui.WebDriverUtils;

public class OrgMngmtPage extends BasePage{

	private static final Logger logger = LoggerFactory.getLogger(OrgMngmtPage.class);

	private By searchField = By.id("search");
	private By profileOrg = By.id("profileInfo");
	private By editBtn = By.xpath("//img[@alt='user edit icon']");
	private By addressField = By.xpath("//input[@name='vendorAddress']");
	private By startDateField = By.xpath("//input[@name='vendorStartDate']");
	private By endDateField = By.xpath("//input[@name='vendorEndDate']");
	private By eaContactNameField = By.xpath("//input[@name='eaContactName']");
	private By eaContactEmailField = By.xpath("//input[@name='eaContactEmail']");
	private By vendorNameField = By.xpath("//input[@name='vendorContactName']");
	private By vendorContactNameField = By.xpath("//input[@name='vendorContactEmail']");
	private By vendorEmailField = By.xpath("//input[@placeholder='example.com']");
	private By saveBtn = By.xpath("//button[@class='save-button']");

	
	protected OrgMngmtPage(WebDriver driver) {
		super(driver);
	}

	public void searchOrg(String orgName){
		WebDriverUtils.sendKeys(driver, searchField, orgName);
		WebDriverUtils.isElementPresent(driver, profileOrg);
	}

	public void viewprofileOrg(String address, String startDate, String endDate, String eaContactName,
			String eaContactEmail, String vendorName, String vendorContactEmail, String domainEmail){
		logger.info("Going to profile..");
		WebDriverUtils.clickOnElementWithWait(driver, profileOrg);
		WebDriverUtils.clickOnElementWithWait(driver, editBtn);
		WebDriverUtils.clearElement(driver, addressField);
		WebDriverUtils.enterTextBox(driver, addressField, address);
		WebDriverUtils.clearElement(driver, startDateField);
		WebDriverUtils.enterTextBox(driver, startDateField, startDate);
		WebDriverUtils.clearElement(driver, endDateField);
		WebDriverUtils.enterTextBox(driver, endDateField, endDate);
		WebDriverUtils.clearElement(driver, eaContactNameField);
		WebDriverUtils.enterTextBox(driver, eaContactNameField, eaContactName);
		WebDriverUtils.clearElement(driver, eaContactEmailField);
		WebDriverUtils.enterTextBox(driver, eaContactEmailField, eaContactEmail);
		WebDriverUtils.clearElement(driver, vendorNameField);
		WebDriverUtils.enterTextBox(driver, vendorNameField, vendorName);
		WebDriverUtils.clearElement(driver, vendorContactNameField);
		WebDriverUtils.enterTextBox(driver, vendorContactNameField, vendorContactEmail);
		WebDriverUtils.clearElement(driver, vendorEmailField);
		WebDriverUtils.enterTextBox(driver, vendorEmailField, domainEmail);
		saveOrg();
	}

	public void saveOrg(){
		WebDriverUtils.clickOnElementWithWait(driver, saveBtn);
	}
}
