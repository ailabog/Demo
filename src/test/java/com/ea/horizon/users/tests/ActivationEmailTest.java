package com.ea.horizon.users.tests;

import com.ea.base.tests.BaseTest;
import com.ea.ui.horizon.pages.DashboardPage;
import com.ea.ui.horizon.pages.LoginPage;
import com.ea.ui.horizon.pages.SignOutPage;
import com.ea.ui.horizon.pages.UserMngmtPage;
import com.ea.utils.general.GenerateRandomDataUtils;
import com.ea.utils.ui.SetSelenium;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create user in horizon
 * 
 * @author abogasieru@contractor.ea.com
 *
 */

public class ActivationEmailTest extends BaseTest {

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
	public void activateTest() {

	}

	@AfterTest
	public void tearDown(){

		loginPage.close();
	}
}
