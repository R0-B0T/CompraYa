package pages;

import locators.IzivendoLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class IzivendoPage
{

    private WebDriver driver;
    private IzivendoLocators izivendoMap;
    private WebDriverWait wait;
    String contrasena;
    String nombreUsuario;
    String nomCupon;

    // Constructor
    public IzivendoPage()
    {
        this.driver = DriverManager.getDriver();
        this.izivendoMap = new IzivendoLocators(driver);

        this.driver = driver;
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
            // Detener la prueba si no se encuentra el usuario o contraseña
            throw new RuntimeException("Validación : " + nombreUsuario + " o " + contrasena + " es incorrecto."); // Detener la ejecución del caso de prueba
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
            // Detener la prueba si no se encuentra la Categoria
            throw new RuntimeException(" Validación : La categoria " + nombreCategoria + " no existe en izivendo. ");
        }
    }

    public boolean seleccionarTarjeta(String nombreTarjeta)
    {
        By locatorTarjeta = By.xpath("//span[text()='" + nombreTarjeta + "']");
        String originalHandle = driver.getWindowHandle();

        try {
            WebElement tarjeta =  wait.until(ExpectedConditions.elementToBeClickable(locatorTarjeta));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tarjeta);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tarjeta);
        } catch (TimeoutException e) {
            throw new RuntimeException("Validación: No se encontró la tarjeta " + nombreTarjeta + ".");
        }

        try {
            // Espera a que se abra una nueva pestaña (PDF)
            new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> handles = driver.getWindowHandles();
            handles.remove(originalHandle);
            String pdfHandle = handles.iterator().next();
            driver.switchTo().window(pdfHandle);

            String urlActual = driver.getCurrentUrl();
            if (urlActual.endsWith(".pdf") || urlActual.contains("amazonaws.com"))
            {
                throw new RuntimeException(" Validación : Se abrio correctamente el PDF de la tarjeta" + nombreTarjeta + ".");
            }
            return true; // Era un PDF

        } catch (TimeoutException e) {
            // No se abrió nueva pestaña → flujo de cupones
            driver.switchTo().window(originalHandle);
            return false;
        }
    }

    public void agregarCupon(String cupon)
    {

        izivendoMap.cupon.clear();
        izivendoMap.cupon.sendKeys(cupon);


        this.nomCupon=cupon;
        validarCupon();
    }

    public void validarCupon() {
        By cuponInvalido = By.xpath("//div[contains(@class,'error-validate') and contains(text(),'Cupón inválido')]");
        By cuponInactivo = By.xpath("//div[contains(@class,'error-validate') and contains(text(),'El cupón no está activo')]");
        By cuponExpirado = By.xpath("//div[contains(@class,'error-validate') and contains(text(),'El cupón ha expirado')]");

        try {
            WebElement mensajeVisible = wait.until(driver -> {
                long stableTime = System.currentTimeMillis();
                String lastText = "";

                while (System.currentTimeMillis() - stableTime < 300) {
                    List<WebElement> errores = new ArrayList<>();
                    errores.addAll(driver.findElements(cuponInvalido));
                    errores.addAll(driver.findElements(cuponInactivo));
                    errores.addAll(driver.findElements(cuponExpirado));

                    for (WebElement el : errores) {
                        try {
                            if (el.isDisplayed() && !el.getText().trim().isEmpty()) {
                                String currentText = el.getText().trim();
                                if (currentText.equals(lastText)) {
                                    return el;
                                } else {
                                    lastText = currentText;
                                    stableTime = System.currentTimeMillis(); // reinicia el contador
                                }
                            }
                        } catch (StaleElementReferenceException ignored) {}
                    }
                }
                return null;
            });

            if (mensajeVisible != null) {
                String mensaje = mensajeVisible.getText().toLowerCase();
                if (mensaje.contains("inválido")) {
                    throw new RuntimeException("Validación: El cupón '" + nomCupon + "' es inválido.");
                } else if (mensaje.contains("activo")) {
                    throw new RuntimeException("Validación: El cupón '" + nomCupon + "' no está activo.");
                } else if (mensaje.contains("expirado")) {
                    throw new RuntimeException("Validación: El cupón '" + nomCupon + "' ha expirado.");
                }
            }

        } catch (TimeoutException ignored) {
            // No apareció mensaje de error
        }
    }

    public void agregarCorreo(String correo)
    {
        wait.until(ExpectedConditions.visibilityOf(izivendoMap.correo));
        izivendoMap.correo.clear();
        izivendoMap.correo.sendKeys(correo);
    }

    public void agregarCelular(String celular)
    {
        wait.until(ExpectedConditions.visibilityOf(izivendoMap.celular));
        izivendoMap.celular.clear();
        izivendoMap.celular.sendKeys(celular);
    }

    public void grabarTarjeta()
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.izivendoMap.btnGrabar));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", this.izivendoMap.btnGrabar);
    }
}

