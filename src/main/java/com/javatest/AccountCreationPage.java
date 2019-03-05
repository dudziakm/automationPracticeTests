package com.javatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AccountCreationPage extends PageObject{

    @FindBy(id = "id_gender1")
    private WebElement titleMRRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement titleMRSRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement dayOfBirth;

    @FindBy(id = "months")
    private WebElement monthOfBirth;

    @FindBy(id = "years")
    private WebElement yearOfBirth;

    // autocopy
    @FindBy(id = "firstname")
    private WebElement firstNameInput;
    // autocopy
    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private Select stateCombo;

    @FindBy(xpath = "//select[@name='id_state']/option[@value='1']")
    private WebElement stateAlabama;

    @FindBy(id = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "id_country")
    private WebElement countryCombo;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    private WebElement addressAliasInput;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    @FindBy(css = "h1.page-heading")
    private WebElement myAccountHeader;

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeader(){
        String header = myAccountHeader.getText();
        return header;
    }

    public MyAccountPage registerNewAccount(String password){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        customerFirstNameInput.sendKeys("Mike");
        customerLastNameInput.sendKeys("DK");
        passwordInput.sendKeys(password);
        addressInput.sendKeys(TestUtils.generateRandToken(4));
        cityInput.sendKeys(TestUtils.generateRandToken(3));
        stateAlabama.click();
        //stateCombo.selectByIndex(2);
        //stateCombo.getFirstSelectedOption();
        //stateCombo.selectByVisibleText("Michigan");
        //stateCombo.selectByValue("22"); //Michigan
        postcodeInput.sendKeys("12345");
        mobilePhoneInput.sendKeys("123456789");

        submitAccountButton.click();
        return new MyAccountPage(driver);
    }
}
