package com.javatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    @FindBy(css = "a.login")
    //or class = "login"
    private WebElement singInButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignInPage singIn(){
        singInButton.click();
        return new SignInPage(driver);
    }


}
