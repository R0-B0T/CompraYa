package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IzivendoLocators
{
    @FindBy(xpath = "//input[@type='text']")
    public WebElement nombreUsuario;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement claveUsuario;

    @FindBy(xpath = "//button[text()='Ingresar']")
    public WebElement btnIngresar;

    @FindBy(xpath = "//span[text()='Usuario / Password incorrecto']")
    public WebElement mensajeError;

    @FindBy(xpath = "//input[@id='coupon']")
    public WebElement cupon;

    @FindBy(xpath = "//div[ contains(@class,'error-validate')\n" +
            "      and preceding-sibling::*[1][ self::input[@id='coupon'] ] ]")
    public List<WebElement> mensajeCupon;



    public IzivendoLocators(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
