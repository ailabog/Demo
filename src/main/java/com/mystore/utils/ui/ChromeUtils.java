package com.mystore.utils.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class that provides method when working with Chrome Driver
 *
 */

public class ChromeUtils {

    private static final Logger logger = LoggerFactory.getLogger(ChromeUtils.class);

    private static WebDriver chromeDesktop() {
        logger.info("Returning normal Chrome driver for desktop.......");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--disable-extensions");
        co.addArguments("--start-maximized");
        return new ChromeDriver(co);
    }

    private static WebDriver chromeMobile() {
        logger.info("Returning mobile Chrome driver.......");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--disable-extensions");
        co.addArguments("--start-maximized");
        String chromeMobile = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
        co.addArguments("--user-agent=" + chromeMobile);
        return new ChromeDriver(co);
    }


    public static WebDriver openChrome(String device) {

        switch (device.toUpperCase()) {
            case "DESKTOP":
                logger.info("Returning Chrome Desktop...");
                return chromeDesktop();
            case "MOBILE":
                logger.info("Returning Chrome Mobile...");
                return chromeMobile();
            default:
                logger.info("Couldn't understand device sent.. defaulting to Chrome Desktop");
                return chromeDesktop();
        }
    }
}

