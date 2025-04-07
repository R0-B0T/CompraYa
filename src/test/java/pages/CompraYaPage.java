package pages;

import locators.CompraYaLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompraYaPage {
    private WebDriver driver;
    private CompraYaLocators locatorMap;

    public CompraYaPage(WebDriver driver) {
        this.driver = driver;
        this.locatorMap = new CompraYaLocators(driver);
    }

    public void openNavegator() {
        String url = utils.PropertiesReader.getProperty("compraya.url");
        driver.get(url);
    }

    public void selectProduct(String producto)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        switch (producto)
        {
            case "POS android P2 Mini" ->
            {
                locatorMap.androidP2Mini.click();
            }
            case "POS android P2 SE" ->
            {
                locatorMap.androidP2SE.click();
            }
            case "POS Android P2 Lite SE" ->
            {
                locatorMap.androidP2LiteSE.click();
            }
            case "QR Parlante" ->
            {
                locatorMap.qrSpeaker.click();
            }
            case "App izipay" ->
            {
                locatorMap.appIzipay.click();
            }
            default ->
            {
                System.out.println("Producto no reconocido");
            }
        }
    }


}
