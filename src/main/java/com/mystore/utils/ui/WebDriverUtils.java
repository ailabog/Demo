package com.mystore.utils.ui;


import java.util.List;
import java.util.HashMap;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class for encapsualting {@linkWebDriver} operations
 * 
 *
 */

public class WebDriverUtils {

	private static final Logger logger = LoggerFactory.getLogger(WebDriver.class);

	public final static long WAIT_60_SECONDS = 60;
	public final static long WAIT_20_SECONDS = 20;
	public final static long WAIT_4000_SECONDS = 4000;

	public static void enterTextBox(WebDriver driver, By locator, String text) {
		String s = "";
		if (!s.equals(text)) {
			logger.debug("Writing \" {}\" to element): {}", text, locator);
		}
		waitUntil(driver, WAIT_60_SECONDS, ExpectedConditions.elementToBeClickable(locator));
		WebElement element = findElement(driver, locator);
		element.clear();
		element.sendKeys(text);
	}

	public static void sendKeys(WebDriver driver, By locator, String text) throws TimeoutException {
		String s = "";
		if (!s.equals(text)) {
			logger.debug("Writing \" {}\" to element): {}", text, locator);
		}
		waitUntil(driver, WAIT_60_SECONDS, ExpectedConditions.elementToBeClickable(locator));
		WebElement element = findElement(driver, locator);
		element.clear();
		element.sendKeys(text);
		element.sendKeys(Keys.ENTER);
	}

	public static void selectDropDown(WebDriver driver, By locator, String option) throws TimeoutException {
		String s = "";
		if (!s.equals(option)) {
			logger.debug("Writing \" {}\" to element): {}", option, locator);
		}
		waitUntil(driver, WAIT_60_SECONDS, ExpectedConditions.elementToBeClickable(locator));
		selectVisibleText(driver, locator, option);
	}

	public static void switchToTab(WebDriver driver, int tab) {
		try {
			driver.switchTo().window((String) driver.getWindowHandles().toArray()[tab]);
		} catch (NoSuchWindowException e) {
			driver.quit();
			throw new WebDriverException(e);
		}
	}

	public static void waitUntil(WebDriver driver, long timeOutInSeconds, ExpectedCondition<?> expectedCondition)
			throws TimeoutException {
		new WebDriverWait(driver, timeOutInSeconds).until(expectedCondition);
	}

	public static void explicitWait(WebDriver driver, long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			driver.quit();
			throw new WebDriverException(e);
		}
	}

	public static void clickOnElement(WebDriver driver, By locator) {
		findElement(driver, locator).click();
	}

	public static WebElement findElement(WebDriver driver, By locator) {
		try {
			return driver.findElement(locator);
		} catch (NoSuchElementException e) {
			driver.quit();
			throw new WebDriverException(e);
		}
	}

	public static void clickOnElementWithWait(WebDriver driver, By locator) throws TimeoutException {
		waitUntil(driver, WAIT_60_SECONDS, ExpectedConditions.elementToBeClickable(locator));
		clickOnElement(driver, locator);
	}

	public static void selectVisibleText(WebDriver driver, By locator, String option)
			throws UnexpectedTagNameException, NoSuchElementException {
		String s = "";
		if (!s.equals(option)) {
			logger.debug("Writing \" {}\" to element): {}", option, locator);
		}
		try {
			new Select(findElement(driver, locator)).selectByVisibleText(option);
		} catch (WebDriverException e) {
			logger.debug("Element was not found in select element", option);
			driver.quit();
			throw new WebDriverException(e);
		}
	}

	public static String getElementText(WebDriver driver, By locator) {
		return findElement(driver, locator).getText();
	}

	public static void scrolltoElement(WebDriver driver, By locator) {
		logger.debug("Scrolling to element {}", locator.toString());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findElement(driver, locator));
	}

	public static void scrollElementToPosition(WebDriver driver, By locator) {
		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("javascript:window.scrollBy(200,500)");
	}

	public static void scrollUp(WebDriver driver, By locator) {
		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("javascript:window.scrollBy(0,-250)");
	}


	public static void moveToElement(WebDriver driver, By locator) {
		logger.debug("Moves to element {}", locator);
		new Actions(driver).moveToElement(findElement(driver, locator)).build().perform();
	}

	public static void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public static void load(WebDriver driver, String url) {
		logger.debug("Loads url {}", url);
		driver.get(url);
	}

	public static void findText(WebDriver driver, String text) {
		logger.debug("Finding the text {}", text);
		driver.getPageSource().contains("text");
	}

	public static void clearElement(WebDriver driver, By locator) {
		logger.debug("Clear the text from this text area:");
		WebElement element = findElement(driver, locator);
		element.clear();
	}

	public static List<WebElement> findElements(WebDriver driver, By locator) {
		try {
			logger.debug("Finding element {}", locator);
			return driver.findElements(locator);
		} catch (org.openqa.selenium.WebDriverException e) {
			logger.error("WebDriverException thrown: {}", e.getMessage());
			driver.quit();
			throw new WebDriverException(e);
		}
	}

	public static boolean isElementPresent(WebDriver driver, By locator) {
		logger.debug("Checking if element {} is present", locator);
		return findElements(driver, locator).stream().findFirst().isPresent();
	}

	public static boolean isElementDisplayed(WebDriver driver, By locator) {
		logger.debug("Checking if element {} is displayed", locator);
		return findElements(driver, locator).stream().filter(WebElement::isDisplayed).findFirst().isPresent();
	}

	public static void disableCookie() {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> contentSettings = new HashMap<String, Object>();
		contentSettings.put("cookies", 2);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		caps.setCapability(ChromeOptions.CAPABILITY, options);
	}

	public static void quit(WebDriver driver) {
		driver.quit();
	}
}
