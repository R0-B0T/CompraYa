package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.IzivendoPage;


public class IzivendoSteps
{
    private IzivendoPage izivendoPage;

    @Given("que el usuario navega a la página de IZIVENDO")
    public void que_el_usuario_navega_a_la_página_de_izivendo()
    {   izivendoPage = new IzivendoPage();
        izivendoPage.abrirNavegadorIzivendo();
    }

    @When("ingresa su usuario {string}")
    public void ingresa_su_usuario(String usuario)
    {
        izivendoPage.ingresarUsuario(usuario);
    }

    @When("coloca su clave {string}")
    public void coloca_su_clave(String clave)
    {
        izivendoPage.ingresarClave(clave);
    }

    @When("presiona el botón Ingresar")
    public void presiona_el_botón_ingresar()
    {
        izivendoPage.hacerClicBtnIngresar();
        izivendoPage.validarLogin();
    }

    @When("selecciona la categoría {string}")
    public void selecciona_la_categoría(String categoria)
    {
        izivendoPage.seleccionarCategoria(categoria);
    }

    @When("selecciona la tarjeta {string}")
    public void selecciona_la_tarjeta(String nombreTarjeta)
    {
        izivendoPage.seleccionarTarjeta(nombreTarjeta);
    }

    @When("escribe el nombre del cupon {string}")
    public void escribe_el_nombre_del_cupon(String cupon)
    {
        izivendoPage.agregarCupon(cupon);
    }

    @When("escribe el correo {string}")
    public void escribe_el_correo(String correo)
    {
        izivendoPage.agregarCorreo(correo);
    }

    @When("escribe el celular {string}")
    public void escribe_el_celular(String celular) {
        izivendoPage.agregarCelular(celular);
    }

    @When("selecciona el boton Grabar diseño")
    public void selecciona_el_boton_grabar_diseño() {
        izivendoPage.grabarTarjeta();
    }
}
