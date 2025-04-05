package pages;

import locators.CompraYaLocators;
import org.openqa.selenium.WebDriver;

public class CompraYaPage
{
    private WebDriver driver;
    private CompraYaLocators locatorMap;

    public CompraYaPage(WebDriver driver) {
        this.driver = driver;
        this.locatorMap =new CompraYaLocators(driver);
    }

    public void openNavegador() {
        String url = utils.PropertiesReader.getProperty("compraya.url");
        driver.get(url);
    }


}
