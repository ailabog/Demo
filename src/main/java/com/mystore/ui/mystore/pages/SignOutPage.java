package com.mystore.ui.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page that contains all the elements for Sign In page and its methods:
 * returning customer, create account, forgot password & check order & links to
 * Create Account page
 */

public class SignOutPage extends BasePage {


    private By inputEmail = By.id("email");
    private By createAccountBtn = By.xpath("//input[@value='Create an account']");
    private By fNameInput = By.id("customer_firstname");
    private By lNameInput = By.id("customer_lastname");
    private By pswdInput = By.id("passwd");
    private By signBtn = By.id("SubmitLogin");


    public SignOutPage(WebDriver driver) {
        super(driver);
    }

}
