package com.mystore.tests;

import com.mystore.ui.mystore.pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.mystore.base.tests.BaseTest;
import com.mystore.utils.general.ConfigUtils;
import com.mystore.utils.ui.SetSelenium;
import com.mystore.utils.general.ConfigUtils.ConfigKeys;
import com.mystore.utils.general.GenerateRandomDataUtils;


public class SignUpLoginSignOutTest extends BaseTest {

	private SignInPage signInPage;
	private CreateAccountPage createAccountPage;
	private HomePage homePage;
	private SignOutPage signOutPage;
	private MyAccountPage myAccountPage;

	public static final String FNAME = "Auto"+ GenerateRandomDataUtils.generateRandomString(4);
	public static final String LNAME = "Auto"+ GenerateRandomDataUtils.generateRandomString(4);
	public static final String EMAIL = "Auto"+ GenerateRandomDataUtils.generateEmail(12);
	public static final String COMPANY = "Auto" + GenerateRandomDataUtils.generateRandomString(3);
	public static final String PASSWORD = "Auto" + GenerateRandomDataUtils.generateRandomString(3);
	public static final String ADDRESS = "Auto" + GenerateRandomDataUtils.generateRandomString(3) +
			                                      GenerateRandomDataUtils.generateRandomNumber(2);

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test()
	public void createUserTest() {
		logger.info("Staring to create user...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(ConfigUtils.getProperty(ConfigKeys.ENV_AUTO.toString()));
		homePage.goToSignIn();
		createAccountPage = homePage.returnCreateAccountPage(EMAIL);
		createAccountPage.createAccount(FNAME, LNAME, PASSWORD, FNAME, LNAME, ADDRESS, COMPANY, "Miami", "Florida", "00000", "United States", "+0023427545", FNAME);
		logger.info("User with email address :" +EMAIL+ "is created successfully");
		myAccountPage = createAccountPage.returnMyAccountPage();
		signOutPage = myAccountPage.returnSignOutPage();
		signInPage = homePage.returnSignInPage();
		signInPage.login(EMAIL, PASSWORD);
		signOutPage = signInPage.returnSignOutPage();
	}

	@AfterTest
	public void clearBrowserSession() {
		homePage.quit();
		createAccountPage.quit();
	}
}
