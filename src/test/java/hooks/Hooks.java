package hooks;
import io.cucumber.java.After;
import utils.DriverManager;

public class Hooks
{
        @After
        public void cerrarNavegador()
        {
            DriverManager.quitDriver();
        }
}
