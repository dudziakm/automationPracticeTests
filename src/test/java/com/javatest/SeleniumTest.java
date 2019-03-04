package com.javatest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    protected static WebDriver driver;
    //private MyProperties myProperties = new MyProperties();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
