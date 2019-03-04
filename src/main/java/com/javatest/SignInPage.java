package com.javatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject {

    // Create new account:
    @FindBy(id = "email_create")
    private WebElement newAccountEmailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateAccountButton;


    // Log in to existing account:
    @FindBy(id = "email")
    private WebElement loginEmailInput;

    @FindBy(id = "passwd")
    private WebElement loginPasswordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;


    public SignInPage(WebDriver driver) {
        super(driver);
    }
}
