package com.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Make sure chromedriver is on your PATH or set the system property
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginNoOK() {
        System.out.println("testLoginNoOK");
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
        driver.get(baseUrl);
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("errore");
        driver.findElement(By.className("mt-2")).click();
        System.out.println(driver.getCurrentUrl());

        assertTrue(driver.findElement(By.id("invalid")).isDisplayed());
    }

    @Test
    public void testLoginOK() {
        System.out.println("testLoginOK");
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
        driver.get(baseUrl);
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("user");
        driver.findElement(By.className("mt-2")).click();
        System.out.println(driver.getCurrentUrl());

        assertTrue(driver.findElement(By.id("success")).isDisplayed());
    }
}
