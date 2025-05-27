package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibroReclamacionesLocators
{
    //Elementos de Opciones para Libro de reclamaciones
    @FindBy(xpath = "//a[@href='/libro-de-reclamaciones']")
    public WebElement itemLB;

    @FindBy(xpath = "//input[@id='input-2']")
    public WebElement rdoProceso;

    @FindBy(xpath = "//input[@id='input-3']")
    public WebElement rdoSinCliente;

    @FindBy(xpath = "//button[text()='Continuar']")
    public WebElement btnContinuar;

    @FindBy(xpath = "//input[@placeholder='Código de comercio']")
    public WebElement txtComercio;

    @FindBy(xpath = "//button[text()='Validar']")
    public WebElement btnValidar;

    @FindBy(xpath = "//a[text()='aquí']")
    public WebElement lnkAqui;

    @FindBy(xpath = "//button[text()='Regresar al home']")
    public WebElement btnHome;

    @FindBy(xpath = "//button[text()='Regresar al home']")
    public WebElement btnFormulario;

    //Elementos del Formulario para Libro de reclamaciones
    @FindBy(xpath = "//input[@placeholder='Número de documento']")
    public WebElement txtNumeroDocumento;

    @FindBy(xpath = "//input[@placeholder='Razón social']")
    public WebElement txtRazonSocial;

    @FindBy(xpath = "//input[@placeholder='Nombres']")
    public WebElement txtNombres;

    @FindBy(xpath = "//input[@placeholder='Apellido paterno']")
    public WebElement txtApellidoPaterno;

    @FindBy(xpath = "//input[@placeholder='Apellido materno']")
    public WebElement txtApellidoMaterno;

    @FindBy(xpath = "//input[@placeholder='Teléfono']")
    public WebElement txtTelefono;

    @FindBy(xpath = "//input[@placeholder='Correo']")
    public WebElement txtCorreo;

    @FindBy(xpath = "//input[@placeholder='Dirección']")
    public WebElement txtDireccion;

    @FindBy(xpath = "//input[@id='input-1']")
    public WebElement rdoQueja;

    @FindBy(xpath = "//input[@id='input-2']")
    public WebElement rdoReclamo;

    @FindBy(xpath = "//textarea[@placeholder='Escribe aquí tu solicitud']")
    public WebElement txtAreaSolicitud;

    @FindBy(xpath = "//article[@class='libro-de-reclamaciones-formulario-files-search mx-auto']")
    public WebElement inpArchivo;

    @FindBy(xpath = "//button[text()='Enviar']")
    public WebElement btnEnviar;

    public LibroReclamacionesLocators(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
