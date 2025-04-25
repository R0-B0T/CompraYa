package pages;

import locators.CompraYaLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CompraYaPage {

    private WebDriver driver;
    private CompraYaLocators locatorMap;
    private String tipDocumentoSeleccionado;

    public CompraYaPage(WebDriver driver) {
        this.driver = driver;
        this.locatorMap = new CompraYaLocators(driver);
    }

    public void abrirNavegador() {
        String url = utils.PropertiesReader.getProperty("compraya.url.qa");
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void elegirProducto(String producto) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        switch (producto) {
            case "POS android P2 Mini" -> {
                locatorMap.androidP2Mini.click();
            }
            case "POS android P2 SE" -> {
                locatorMap.androidP2SE.click();
            }
            case "POS Android P2 Lite SE" -> {
                locatorMap.androidP2LiteSE.click();
            }
            case "QR Parlante" -> {
                locatorMap.qrSpeaker.click();
            }
            case "App izipay" -> {
                locatorMap.appIzipay.click();
            }
            default -> {
                System.out.println("Producto no reconocido");
            }
        }
    }

    public void seleccionarTpDocumento(String tipoDocumento) {
        if (tipoDocumento.equals("DNI/CE")) {
            this.locatorMap.tipoDocumentoDNI.click();
        } else if (tipoDocumento.equals("RUC")) {
            this.locatorMap.tipoDocumentoRUC.click();
        } else {
            System.out.println("Tipo de documento no encontrado: " + tipoDocumento);
        }

    }

    public void seleccionarDocumento(String documento) {
        // Abrir el menú desplegable
        WebElement dropdown = this.locatorMap.tipoDocumento;
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (documento.equals("DNI")) {
            this.locatorMap.dni.click();
        } else if (documento.equals("CE")) {
            this.locatorMap.ce.click();
        } else {
            System.out.println("No se encontro documento: " + documento);
        }
        tipDocumentoSeleccionado = documento;
    }

    public void ingresarDocumento(String RUC, String nDocumento) {
        if (RUC != null && !RUC.isEmpty()) {
            this.locatorMap.numeroRUC.sendKeys(RUC);
        }
        if (tipDocumentoSeleccionado.equals("DNI")) {
            this.locatorMap.numeroDNI.sendKeys(nDocumento);
        } else if (tipDocumentoSeleccionado.equals("CE")) {
            this.locatorMap.numeroCE.sendKeys(nDocumento);
        }
        this.locatorMap.btnConfirmar.click();
    }


}
