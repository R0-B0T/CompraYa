package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CompraYaPage;
import utils.DriverManager;

public class CompraYaSteps
{
    private CompraYaPage cyPage;

    @Given("que el usuario ingresa a la página de Compraya")
    public void que_el_usuario_ingresa_a_la_página_de_compraya()
    {

        cyPage = new CompraYaPage(DriverManager.getDriver());
        cyPage.openNavegator();
    }

    @When("el usuario selecciona el producto {string}")
    public void el_usuario_selecciona_el_producto(String producto)
    {
        cyPage.selectProduct(producto);
    }



}
