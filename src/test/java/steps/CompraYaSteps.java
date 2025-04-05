package steps;

import io.cucumber.java.en.Given;
import locators.CompraYaLocators;
import org.openqa.selenium.WebDriver;
import pages.CompraYaPage;
import utils.DriverManager;

public class CompraYaSteps
{
    private WebDriver driver;
    private CompraYaPage CompraYaPage;
    private CompraYaLocators locatorMap;

    @Given("que el usuario ingresa a la página de Compraya")
    public void que_el_usuario_ingresa_a_la_página_de_compraya() {

        CompraYaPage compraYaPage = new CompraYaPage(DriverManager.getDriver());
        compraYaPage.openNavegador();
    }


}
