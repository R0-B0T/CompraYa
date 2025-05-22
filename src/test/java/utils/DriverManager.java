package utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class DriverManager
{
    public static WebDriver driver;

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
                    /*
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    break;
                    */
                    throw new UnsupportedOperationException("SafariDriver solo está disponible en macOS.");

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
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
