package com.ea.horizon.orgs.tests;

import com.ea.base.tests.BaseTest;
import com.ea.ui.horizon.pages.*;
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
 * update org in horizon
 * 
 * @author abogasieru@contractor.ea.com
 *
 */

public class UpdateOrgTest extends BaseTest {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private SignOutPage signOutOPage;
	private OrgMngmtPage orgMngmtPage;

    public static final String ORG_NAME = "SONY MUSIC ENTERTAINMENT ESPANA SL";
	public static final String ADDRESS = "Auto"+ GenerateRandomDataUtils.generateRandomString(4);
	public static final String EA_CONTACT_NAME = "Auto"+ GenerateRandomDataUtils.generateRandomString(4);
	public static final String VENDOR_NAME = "Auto"+ GenerateRandomDataUtils.generateRandomString(4);
	public static final String EA_CONTACT_EMAIL = "Auto" + GenerateRandomDataUtils.generateEmail(12);
	public static final String VENDOR_CONTACT_EMAIL = "Auto"+ GenerateRandomDataUtils.generateEmail(12);
	public static final String VENDOR_DOMAIN = "yopmail.com";
	String pattern = "mm-dd-yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String START_DATE = simpleDateFormat.format(new Date());
	String END_DATE = simpleDateFormat.format(new Date());

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test()
	public void updateUserTest() {
		logger.info("Starting to update org...");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(ConfigUtils.getProperty(ConfigKeys.ENV_DEV_HORIZON));
		loginPage.login(ConfigUtils.getProperty(ConfigKeys.ACCOUNT), ConfigUtils.getProperty(ConfigKeys.PASSWORD));
		dashboardPage = loginPage.returnDashboardPage();
		orgMngmtPage = dashboardPage.returnOrgMngmtPage();
		orgMngmtPage.searchOrg(ORG_NAME);
		orgMngmtPage.viewprofileOrg(ADDRESS, START_DATE, END_DATE, EA_CONTACT_NAME, EA_CONTACT_EMAIL, VENDOR_NAME, VENDOR_CONTACT_EMAIL, VENDOR_DOMAIN);
		logger.info("Org:" +ORG_NAME+ "is updated successfully...");
	}

	/*@AfterTest
	public void tearDown(){
		loginPage.close();
	}*/
}
