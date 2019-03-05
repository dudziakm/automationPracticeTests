package com.javatest;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SignInTest extends SeleniumTest {
    private static final String SHOP = "http://automationpractice.com";

    @Ignore
    @Test
    public void shouldLoginToExistingAccount(){
        driver.get(SHOP);
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.singIn();
        MyAccountPage myAccountPage =  signInPage.signInToExistingAccount("fads@wp.pl", "Password1");

        Assert.assertTrue(myAccountPage.isUserLogged());
    }

    @Test
    public void shouldCreateNewAccount() {
        driver.get(SHOP);
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.singIn();
        AccountCreationPage accountCreationPage = signInPage.createNewAccount("test1234@o2.pol");
        MyAccountPage myAccountPage = accountCreationPage.registerNewAccount("Password1");
        Assert.assertTrue(myAccountPage.isUserLogged());

        System.out.println("test");
    }

    @Test
    public void shouldNotAllowToUseExistingEmail(){
        driver.get(SHOP);
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.singIn();
        AccountCreationPage accountCreationPage = signInPage.createNewAccount("test1234@o2.pol");
        Assert.assertTrue(signInPage.isEmailAlreadyExists());
    }

    @Ignore
    @Test
    public void shouldCreateNewAccountAndLogin() {
        driver.get(SHOP);
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.singIn();
        AccountCreationPage accountCreationPage = signInPage.createNewAccount("test@o2.pol");
        //MyAccountPage myAccountPage = accountCreationPage.registerNewAccount();


        System.out.println("test");
    }

    @Ignore
    @Test
    public void test(){
        System.out.println(TestUtils.generateRandToken(1));
        System.out.println(TestUtils.generateRandToken(5));
        System.out.println(TestUtils.generateRandToken(12));
    }


}
