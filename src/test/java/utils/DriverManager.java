package utils;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class DriverManager
{
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = getBrowserFromConfig();

            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--width=1400", "--height=800");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "safari":
                    // SafariDriver no necesita WebDriverManager en MacOS
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--window-size=1400,800");
                    driver = new ChromeDriver(chromeOptions);
                    break;
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static String getBrowserFromConfig() {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("browser", "chrome"); // Por defecto usa Chrome
    }
}
