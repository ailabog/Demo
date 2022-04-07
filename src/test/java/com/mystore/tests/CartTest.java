package com.mystore.tests;

import com.mystore.base.tests.BaseTest;
import com.mystore.ui.mystore.pages.*;
import com.mystore.utils.general.ConfigUtils;
import com.mystore.utils.general.ConfigUtils.ConfigKeys;
import com.mystore.utils.ui.SetSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CartTest extends BaseTest {

	private HomePage homePage;
	private TShirtPage tshirtPage;

	@BeforeTest
	public void setSeleniumUP() {
		SetSelenium setPath = new SetSelenium();
		setPath.setSelenium();
	}

	@Test()
	public void addCartTest() {
		logger.info("Staring add products to the cart...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(ConfigUtils.getProperty(ConfigKeys.ENV_AUTO.toString()));
		homePage.searchProduct("T-shirt");
		tshirtPage = homePage.returnTshirtPage();
		tshirtPage.addToCart();
		tshirtPage.checkout();
	}

	@Test()
	public void removeItemCartTest() {
		logger.info("Staring add products to the cart...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(ConfigUtils.getProperty(ConfigKeys.ENV_AUTO.toString()));
		homePage.searchProduct("T-shirt");
		tshirtPage = homePage.returnTshirtPage();
		tshirtPage.addToCart();
		tshirtPage.checkCart();
	}

	@AfterTest
	public void clearBrowserSession() {
		homePage.quit();
		tshirtPage.quit();
	}
}
