package com.javatest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    private static final String SHOP = "http://automationpractice.com";

    protected static WebDriver driver;
    //private MyProperties myProperties = new MyProperties();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SHOP);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
