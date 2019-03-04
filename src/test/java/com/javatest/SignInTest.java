package com.javatest;

import org.junit.Test;

public class SignInTest extends SeleniumTest {
    private static final String SHOP = "http://automationpractice.com";

    @Test
    public void shouldSuccessfullyFindPostAndDisplayCommentSection() {
        driver.get(SHOP);
        HomePage homePage = new HomePage(driver);

        SignInPage signInPage = homePage.singIn();


        System.out.println("test");

    }
}
