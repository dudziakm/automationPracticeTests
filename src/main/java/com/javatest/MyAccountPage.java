package com.javatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject {

    @FindBy(css = "h1.page-heading")
    private WebElement myAccountHeader;

    @FindBy(className = "logout")
    private WebElement logOutButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeader(){
        String header = myAccountHeader.getText();
        return header;
    }

    public boolean isUserLogged() {
        return getPageHeader().equals("MY ACCOUNT");
    }

    public SignInPage logOut(){
        logOutButton.click();
        return new SignInPage(driver);
    }
}
