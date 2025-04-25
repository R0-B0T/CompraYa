package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CompraYaPage;
import utils.DriverManager;

import java.time.Duration;

public class CompraYaSteps
{
    private CompraYaPage cyPage;

    @Given("que el usuario ingresa a la página de Compraya")
    public void que_el_usuario_ingresa_a_la_página_de_compraya()
    {

        cyPage = new CompraYaPage(DriverManager.getDriver());
        cyPage.abrirNavegador();
    }

    @When("el usuario selecciona el producto {string}")
    public void el_usuario_selecciona_el_producto(String producto)
    {
        cyPage.elegirProducto(producto);
    }

    @When("el usuario elige el tipo de documento {string}")
    public void el_usuario_elige_el_tipo_de_documento(String tipoDocumento)
    {
        cyPage.seleccionarTpDocumento(tipoDocumento);
    }

    @When("el usuario elige el documento  {string}")
    public void el_usuario_elige_el_documento(String documento)
    {
        cyPage.seleccionarDocumento(documento);
    }

    @When("el usuario ingresa el {string} como número de RUC y el {string} como número de documento")
    public void el_usuario_ingresa_el_como_número_de_ruc_y_el_como_número_de_documento(String RUC, String nDocumento)
    {
        cyPage.ingresarDocumento(RUC, nDocumento);
    }

    @When("el usuario ingresa el {string}")
    public void el_usuario_ingresa_el(String string)
    {

    }



}
