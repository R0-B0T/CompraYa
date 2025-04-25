package pages;

import locators.IzivendoLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class IzivendoPage
{

    private WebDriver driver;
    private IzivendoLocators izivendoMap;
    private WebDriverWait wait;
    String contrasena;
    String nombreUsuario;
    String nomCupon;

    // Constructor
    public IzivendoPage(WebDriver driver)
    {
        this.driver = driver;
        this.izivendoMap = new IzivendoLocators(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrirNavegadorIzivendo()
    {
        String envKey = utils.PropertiesReader.getProperty("env.izivendo");
        String url = utils.PropertiesReader.getProperty(envKey);
        driver.get(url);
    }

    public void ingresarUsuario(String usuario)
    {
        wait.until(ExpectedConditions.visibilityOf(this.izivendoMap.nombreUsuario));
        this.izivendoMap.nombreUsuario.clear();
        this.izivendoMap.nombreUsuario.sendKeys(usuario);
        this.nombreUsuario = usuario;
    }

    public void ingresarClave(String clave)
    {
        wait.until(ExpectedConditions.visibilityOf(this.izivendoMap.claveUsuario));
        this.izivendoMap.claveUsuario.clear();
        this.izivendoMap.claveUsuario.sendKeys(clave);
        this.contrasena = clave;
    }

    //Espera al botón esté disponible para clic, luego utiliza JavaScript para simular un clic en ese botón
    public void hacerClicBtnIngresar()
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.izivendoMap.btnIngresar));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", this.izivendoMap.btnIngresar);
    }

    public void validarLogin()
    {
        if (mensajeErrorVisible()) {
            driver.quit();
            throw new RuntimeException("Prueba fallida: " + nombreUsuario + " o " + contrasena + " es incorrecto."); // Detener la ejecución del caso de prueba
        }
    }

    // Metodo para verificar si el mensaje de error "Usuario / Password incorrecto" es visible
    private boolean mensajeErrorVisible()
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(this.izivendoMap.mensajeError));
            return this.izivendoMap.mensajeError.isDisplayed(); // Verifica si el mensaje de error está presente en la página
        } catch (Exception e) {
            // Si el mensaje no aparece después de la espera, significa que no ocurrió un error
            return false;
        }
    }

    public void seleccionarCategoria(String nombreCategoria)
    {
        By locator = By.xpath("//p[text()='" + nombreCategoria + "']");

        try {
            WebElement categoria = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", categoria);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", categoria);

        } catch (TimeoutException e) {
            // Detener la prueba si no se encuentra la categoría
            driver.quit();
            throw new RuntimeException(" Prueba Fallida : No se encontro la categoria: " + nombreCategoria + " ");
        }
    }

    public void seleccionarTarjeta(String nombreTarjeta)
    {
        By locatorTarjeta = By.xpath("//span[text()='" + nombreTarjeta + "']"); //span[text()='test']

        try {
            WebElement tarjeta = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTarjeta));
            wait.until(ExpectedConditions.elementToBeClickable(tarjeta));
            tarjeta.click();

        } catch (TimeoutException e) {
            // Detener la prueba si no se encuentra la tarjeta
            driver.quit();
            throw new RuntimeException(" Prueba Fallida : No se encontro la tarjeta: " + nombreTarjeta + " ");
        }
    }

    public void ingresarCupon(String cupon)
    {
        wait.until(ExpectedConditions.visibilityOf(izivendoMap.cupon));
        izivendoMap.cupon.clear();
        izivendoMap.cupon.sendKeys(cupon);
    }




}

