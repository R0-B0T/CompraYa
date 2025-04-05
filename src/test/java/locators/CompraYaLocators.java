package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraYaLocators
{
    //Productos de Compraya
    @FindBy(id = "//input[@id='pos8']")
    public WebElement appIzipay;

    @FindBy(id = "//input[@id='pos14']")
    public WebElement androidP2Mini;

    @FindBy(xpath = "//input[@id='pos21']")
    public WebElement androidP2SE;

    @FindBy(xpath = "//input[@id='pos24']")
    public  WebElement qrSpeaker;

    @FindBy(xpath = "//input[@id='pos26']")
    public WebElement androidP2LiteSE;


    //Tipo de documento de Afiliación
    @FindBy(xpath = "//input[@value=\"TICKET\"]")
    public WebElement tipoDocumentoDNI;

    @FindBy(xpath = "//input[@value=\"INVOICE\"]")
    public WebElement tipoDocumentoRUC;

    @FindBy(xpath = "//select[@class='select-text']")
    public WebElement tipoDocumento;

    //Documento de Afiliación
    @FindBy(xpath = "//div//parent::option[@value='DNI']")
    public WebElement dni;

    @FindBy(xpath = "//div//parent::option[@value='CE']")
    public WebElement ce;

    @FindBy(xpath = "//input[@name='Nº de doc']")
    public WebElement numeroDNI;

    @FindBy(xpath = "//input[@name='Nº de carné']")
    public WebElement numeroCE;

    @FindBy(xpath = "//input[@name='RUC']")
    public WebElement numeroRUC;

    @FindBy(xpath = "//button[contains(text(), 'Confirmar')]")
    public WebElement btnConfirmar;

    @FindBy(xpath = "//div[contains(text(), '¡DNI verificado correctamente!')]]")
    public WebElement mensajeDNI;

    @FindBy(xpath = "//div[contains(text(), '¡CE verificado correctamente!')]")
    public WebElement mensajeCE;

    //Datos Personales
    @FindBy()
    public WebElement nombres;

    @FindBy()
    public WebElement apellidoPat;

    @FindBy()
    public WebElement apellidoMat;

    @FindBy(xpath = "//input[@name='celular']")
    public WebElement celular;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement correo;

    @FindBy(xpath = "//input[@name='email2']")
    public WebElement confirmarCorreo;

    public CompraYaLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
