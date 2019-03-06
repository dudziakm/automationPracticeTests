package com.javatest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SignInTest extends SeleniumTest {

    @Test
    public void shouldLoginToExistingAccount(){
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.singIn();
        MyAccountPage myAccountPage =  signInPage.signInToExistingAccount("fads@wp.pl", "Password1");
        Assert.assertTrue(myAccountPage.isUserLogged());
    }

    @Test
    public void shouldCreateNewAccount() {
        String email = TestUtils.generateRandEmail();
        String password = TestUtils.generateRandToken(3);
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.singIn();
        AccountCreationPage accountCreationPage = signInPage.createNewAccount(email);
        MyAccountPage myAccountPage = accountCreationPage.registerNewAccount(password);
        Assert.assertTrue(myAccountPage.isUserLogged());
    }

    @Test
    public void shouldNotAllowToUseExistingEmail(){
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.singIn();
        AccountCreationPage accountCreationPage = signInPage.createNewAccount("test1234@o2.pol");
        Assert.assertTrue(signInPage.isEmailAlreadyExists());
    }

    @Test
    public void shouldCreateNewAccountAndLogin() {
        String email = TestUtils.generateRandEmail();
        String password = TestUtils.generateRandToken(3);
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.singIn();
        AccountCreationPage accountCreationPage = signInPage.createNewAccount(email);
        MyAccountPage myAccountPage = accountCreationPage.registerNewAccount(password);
        Assert.assertTrue(myAccountPage.isUserLogged());
        //log out:
        signInPage = myAccountPage.logOut();
        //log in:
        myAccountPage =  signInPage.signInToExistingAccount(email, password);
        Assert.assertTrue(myAccountPage.isUserLogged());
    }

    @Ignore
    @Test
    public void test(){
        System.out.println(TestUtils.generateRandToken(1));
        System.out.println(TestUtils.generateRandToken(5));
        System.out.println(TestUtils.generateRandToken(12));
    }


}
