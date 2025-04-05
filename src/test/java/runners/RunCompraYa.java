package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps"},
        tags = "@afiliacionFisico",
        publish = true
)

public class RunCompraYa
{
    public RunCompraYa()
    {

    }
}
