package pages;

import locators.LibroReclamacionesLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class LibroReclamacionesPage
{
    private final WebDriver driver;
    private LibroReclamacionesLocators lbLocator;
    private WebDriverWait wait;

    // Constructor
    public LibroReclamacionesPage()
    {
        this.driver = DriverManager.getDriver();
        LibroReclamacionesLocators lbLocators = new LibroReclamacionesLocators(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrirNavegadorIzivendo()
    {
        String envKey = utils.PropertiesReader.getProperty("env.web");
        String url = utils.PropertiesReader.getProperty(envKey);
        driver.get(url);
    }
}
