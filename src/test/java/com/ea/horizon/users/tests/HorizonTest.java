package com.ea.horizon.users.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ea.base.tests.BaseTest;
import com.ea.ui.horizon.pages.DashboardPage;
import com.ea.ui.horizon.pages.LoginPage;
import com.ea.ui.horizon.pages.OrgMngmtPage;
import com.ea.ui.horizon.pages.PartnerMngmtPage;
import com.ea.ui.horizon.pages.UserMngmtPage;
import com.ea.utils.general.ConfigUtils;
import com.ea.utils.ui.SetSelenium;
import com.ea.utils.general.ConfigUtils.ConfigKeys;

/**
 * Login to horizon
 * Check User Management, Organisation Management and Partner Access Management are accessible
 * @author abogasieru@contractor.ea.com
 *
 */

public class HorizonTest extends BaseTest {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private OrgMngmtPage orgMngmtPage;
	private UserMngmtPage userMngmtPage;
	private PartnerMngmtPage partnerMngmtPage;

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test()
	public void organisationMngmtCheckTest() {
		logger.info("Starting Organisation Management check...");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(ConfigUtils.getProperty(ConfigKeys.ENV_DEV_HORIZON));
		loginPage.login(ConfigUtils.getProperty(ConfigKeys.ACCOUNT), ConfigUtils.getProperty(ConfigKeys.PASSWORD));
		dashboardPage = loginPage.returnDashboardPage();
		orgMngmtPage = dashboardPage.returnOrgMngmtPage();
		logger.info("Finishing Organisation Management check");
	}

	@Test()
	public void userMngmtCheckTest() {
		logger.info("Starting Management Tab check");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(ConfigUtils.getProperty(ConfigKeys.ENV_DEV_HORIZON));
		loginPage.login(ConfigUtils.getProperty(ConfigKeys.ACCOUNT), ConfigUtils.getProperty(ConfigKeys.PASSWORD));
		dashboardPage = loginPage.returnDashboardPage();
		userMngmtPage = dashboardPage.returnUserMngmtPage();
		logger.info("Finishing User Management check");
	}

	@Test()
	public void partnerMngmtCheckTest() {
		logger.info("Starting Partner Access Management check..");
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.load(ConfigUtils.getProperty(ConfigKeys.ENV_DEV_HORIZON));
		loginPage.login(ConfigUtils.getProperty(ConfigKeys.ACCOUNT), ConfigUtils.getProperty(ConfigKeys.PASSWORD));
		dashboardPage = loginPage.returnDashboardPage();
		partnerMngmtPage = dashboardPage.returnPartnerMngmtPage();
		logger.info("Finishing Partner Access Management check");
	}

	@AfterTest
	public void tearDown(){
		orgMngmtPage.close();
		userMngmtPage.close();
		partnerMngmtPage.close();
	   }
	}
