//package com.example.polishCommunity.DevOpsTests;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertTrue;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ChromeDriverPageTests {
//
//    //    private WebDriver webDriver;
////
////    driver = new ChromeDriver();
//    @Value("${local.server.port}")
//    private int port;
//
//    //    an alternative really good resource:   https://github.com/bonigarcia/webdrivermanager
//    WebDriver webDriver;
//
//    @BeforeAll
//    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
//    }
//
//    @BeforeEach
//    void setupTest() {
//        FirefoxOptions options = new FirefoxOptions();
//        webDriver = new FirefoxDriver(options);
//        options.addArguments("--headless");
//    }
//
//    @AfterEach
//    void teardown() {
//        webDriver.quit();
//    }
//
//
//
//
//
//    @Test
//    public void testingPageContents() {
//
//
//        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/home");
//        assertTrue(webDriver.findElement(By.cssSelector("h2")).getText().contains("Latest Events"));
//
//        this.webDriver.get("http://localhost:" + Integer.toString(port) + "/signin-register");
//        this.webDriver.findElement(By.id("loginEmail")).sendKeys("ian@gmail.com");
//        this.webDriver.findElement(By.id("loginPassword")).sendKeys("@Hajar18");
//        this.webDriver.findElement(By.id("loginButton")).click();
//        assertTrue(webDriver.findElement(By.cssSelector("h2")).getText().contains("Latest Events"));
//
//    }
//
//
//}
