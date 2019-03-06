package com.javatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignInPage extends PageObject {

    // Create new account:
    @FindBy(id = "email_create")
    private WebElement newAccountEmailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateAccountButton;

    @FindBy(id = "create_account_error")
    private WebElement errorMsg;

    // Log in to existing account:
    @FindBy(id = "email")
    private WebElement loginEmailInput;

    @FindBy(id = "passwd")
    private WebElement loginPasswordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public AccountCreationPage createNewAccount(String email){
        newAccountEmailInput.sendKeys(email);
        submitCreateAccountButton.submit();
        return new AccountCreationPage(driver);
    }

    public MyAccountPage signInToExistingAccount(String email, String password){
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        submitLoginButton.click();
        return new MyAccountPage(driver);
    }

    public String getErrorMsg(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error")));
        return errorMsg.getText();
    }

    public boolean isEmailAlreadyExists() {
        return getErrorMsg().contains("An account using this email address has already been registered");
    }
}
