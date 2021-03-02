package com.jhipster.config;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumConfig {

    private WebDriver driver;

    public SeleniumConfig() {
//        Capabilities capabilities = DesiredCapabilities.firefox();
        Capabilities capabilities = DesiredCapabilities.chrome();
//        driver = new FirefoxDriver(capabilities);
        driver = new ChromeDriver(capabilities);
        driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    static {
//        System.setProperty("webdriver.gecko.driver", findFile("geckodriver.mac"));
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/active/chromedriver.exe");
    }

    private static String findFile(String filename) {
        String[] paths = { "", "bin/", "target/classes" }; // if you have chromedriver somewhere else on the path, then put it here.
        for (String path : paths) {
            if (new File(path + filename).exists())
                return path + filename;
        }
        return "";
    }

    public void close() {
        driver.close();
    }

    public void navigateTo(String url) {
        driver.navigate()
            .to(url);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
