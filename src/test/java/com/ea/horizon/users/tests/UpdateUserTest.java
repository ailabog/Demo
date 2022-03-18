package com.ea.horizon.users.tests;

import com.ea.base.tests.BaseTest;
import com.ea.ui.horizon.pages.DashboardPage;
import com.ea.ui.horizon.pages.LoginPage;
import com.ea.ui.horizon.pages.SignOutPage;
import com.ea.ui.horizon.pages.UserMngmtPage;
import com.ea.utils.general.ConfigUtils;
import com.ea.utils.general.ConfigUtils.ConfigKeys;
import com.ea.utils.general.GenerateRandomDataUtils;
import com.ea.utils.ui.SetSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * update user in horizon
 * 
 * @author abogasieru@contractor.ea.com
 *
 */

public class UpdateUserTest extends BaseTest {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private SignOutPage signOutOPage;
	private UserMngmtPage userMngmtPage;

    public static final String FNAME = "Auto"+ GenerateRandomDataUtils.generateRandomString(4);
    public static final String LNAME = "Auto"+ GenerateRandomDataUtils.generateRandomString(4);
    public static final String PREFFNAME = "Auto"+ GenerateRandomDataUtils.generateRandomString(7);
    public static final String EMAIL = "Auto"+ GenerateRandomDataUtils.generateEmail(12);
    public static final String ROLE = "Auto" + GenerateRandomDataUtils.generateRandomNumber(4);

	String pattern = "mm-dd-yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String DATE = simpleDateFormat.format(new Date());
	

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test()
	public void updateUserTest() {
		logger.info("Starting to create/update user...");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(ConfigUtils.getProperty(ConfigKeys.ENV_DEV_HORIZON));
		loginPage.login(ConfigUtils.getProperty(ConfigKeys.ACCOUNT), ConfigUtils.getProperty(ConfigKeys.PASSWORD));
		dashboardPage = loginPage.returnDashboardPage();
		userMngmtPage = dashboardPage.returnUserMngmtPage();
		userMngmtPage.createUser(FNAME, LNAME, PREFFNAME, DATE, EMAIL, ROLE);
		userMngmtPage.searchUser(PREFFNAME);
		userMngmtPage.checkUserAction(PREFFNAME);
        userMngmtPage.updateProfile(DATE);
		logger.info("User:" +PREFFNAME+ "is updated successfully...");
	}

	@AfterTest
	public void tearDown(){
		loginPage.close();
	}
}