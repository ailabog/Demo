package com.ea.ui.horizon.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ea.utils.ui.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserMngmtPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(UserMngmtPage.class);

	private By createUserBtn = By.xpath("//button[@class='save-button']");
	private By addUserBtn = By.xpath("//button[contains(text(), 'Add user')]");
	private By firstNameFiled = By.xpath("//input[@name='firstName']");
	private By lastNameField = By.xpath("//input[@name='lastName']");
	private By preferredNameField = By.xpath("//input[@name='preferredName']");
	private By contractEndDateField = By.xpath("//input[@name='contractEndDate']");
	private By emailField = By.xpath("//input[@name='partnerCompanyEmail']");
	private By eaORG = By.xpath("//div[@id='eaOrg']/div/div/div/div/div[2]/div");
	private By orgValue = By.xpath("//div[contains(text(), 'Corporate - HQ')]");
	private By businessTileField = By.xpath("//input[@name='partnerBusinessTitle']");
	private By partnerName = By.xpath("//div[@id='partnerCompanyName']/div/div/div/div/div/div");
	private By businessValue = By.xpath("//div[contains(text(), 'SOURCING NETWORK STOCKHOLM AB')]");
	private By searchField = By.id("search");
	private By usersTable = By.id("tableBulk");

	private By viewProfileLink = By.xpath("//img[@id='profileInfo']");
	private By sendActivationEmailLink = By.xpath("//img[@id='activateEmail']");
	private By deactivateAccountLink = By.xpath("//img[@id='deActivateEmail']");
	private By editBtn = By.xpath("//img[@alt='user edit icon']");
	private By saveBtn = By.xpath("//button[contains(text(), 'Save')]");
	private By sendBtn = By.xpath("//button[contains(text(), 'Send')]");
	private By deactivateAccountBtn = By.xpath("//button[contains(text(), 'Yes, Deactivate')]");

	private By signOutArrow = By.xpath("//img[@alt='This is caret icon']");
	private By signOutBtn = By.xpath("//button[contains(text(), 'Sign Out')]");

	private By emailAddressField = By.id("email");
	private By pswdField = By.id("password");

	
	public UserMngmtPage(WebDriver driver) {
		super(driver);
	}

	public void createUser(String firstNameValue, String lastNameValue, String preferredValue, String date,
			String email, String role) {
		WebDriverUtils.clickOnElementWithWait(driver, addUserBtn);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_4000_SECONDS);
		WebDriverUtils.enterTextBox(driver, firstNameFiled, firstNameValue);
		WebDriverUtils.enterTextBox(driver, lastNameField, lastNameValue);
		WebDriverUtils.enterTextBox(driver, preferredNameField, preferredValue);
		WebDriverUtils.clickOnElementWithWait(driver, eaORG);
		WebDriverUtils.clickOnElementWithWait(driver, orgValue);
		WebDriverUtils.enterTextBox(driver, contractEndDateField, date);
		WebDriverUtils.clickOnElementWithWait(driver, partnerName);
		WebDriverUtils.clickOnElementWithWait(driver, businessValue);
		WebDriverUtils.enterTextBox(driver, emailField, email);
		WebDriverUtils.enterTextBox(driver, businessTileField, role);
		clickAddUser();
	}
	
	public void clickAddUser(){
		WebDriverUtils.clickOnElementWithWait(driver, createUserBtn);
	}

	public void searchUser(String userName){
		WebDriverUtils.sendKeys(driver, searchField, userName);
	}

	public String saveUser(String userName) {
		searchUser(userName);
		return userName;
	}

	public boolean checkUserAction(String userName){
		boolean checkAction = false;
		if (WebDriverUtils.isElementPresent(driver, viewProfileLink)
				&& WebDriverUtils.isElementPresent(driver, sendActivationEmailLink)
		        && WebDriverUtils.isElementPresent(driver, deactivateAccountLink))
			{
			logger.info("User {}" + userName
					+ "was created with success and actions are allowed");
		}
		else logger.info("User {}" + userName
				+ "was not created with success and actions are allowed");

		return checkAction;
	}

	public boolean checkUserDetails(String userName){
		boolean checkDetails = false;
		if (WebDriverUtils.isElementPresent(driver, viewProfileLink)
				&& WebDriverUtils.isElementPresent(driver, sendActivationEmailLink)
				&& WebDriverUtils.isElementPresent(driver, deactivateAccountLink))
		{
			logger.info("User {}" + userName
					+ "was created with success with expected details");
		}
		else logger.info("User {}" + userName
				+ "was not created with success and expected details");

		return checkDetails;
	}

	public void updateProfile(String date) {
		WebDriverUtils.clickOnElementWithWait(driver, viewProfileLink);
		WebDriverUtils.clickOnElementWithWait(driver, editBtn);
		WebDriverUtils.clearElement(driver, contractEndDateField);
		WebDriverUtils.enterTextBox(driver, contractEndDateField, date);
		WebDriverUtils.clickOnElementWithWait(driver, saveBtn);
	}

	public void checkUserIsAdded(String name, String email, String companyName, String businessTitle, String eaOrg, String status) {
		WebElement tbl = driver.findElement(By.id("tableBulk"));
		List<WebElement> rows = tbl.findElements(By.tagName("tr"));
			for (int i = 0; i < rows.size(); i++) {
				List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < cols.size(); j++) {
					if (cols.get(j).getText() == name && cols.get(j).getText() == email && cols.get(j).getText() == companyName &&
							cols.get(j).getText() == businessTitle
							&& cols.get(j).getText() == eaOrg && cols.get(j).getText() == status) {
						logger.info(
								"User with:{}" + name + email + companyName + businessTitle + eaOrg + status + "was created with success");
					} else {
						logger.info("User with{}" + name + email + companyName + businessTitle + eaOrg + status + "was not created");
					}
				}
			}
		}

	public void sendActivationLink()  {
		WebDriverUtils.clickOnElementWithWait(driver, sendActivationEmailLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_3_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, sendBtn);
	}

	public void deactivateAccount() {
		WebDriverUtils.clickOnElementWithWait(driver, deactivateAccountLink);
		WebDriverUtils.explicitWait(driver, WebDriverUtils.WAIT_3_SECONDS);
		WebDriverUtils.clickOnElementWithWait(driver, deactivateAccountBtn);
	}

	public SignOutPage returnSignOutPage() {
		WebDriverUtils.clickOnElementWithWait(driver, signOutArrow);
		WebDriverUtils.clickOnElementWithWait(driver, signOutBtn);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_20_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(emailAddressField));
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_20_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(pswdField));
		return new SignOutPage(driver);
	}
}
