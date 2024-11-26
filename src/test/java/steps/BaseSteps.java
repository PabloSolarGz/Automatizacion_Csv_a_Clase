package steps;

import org.openqa.selenium.WebDriver;
import utils.Browsers;

public class BaseSteps {
    protected WebDriver driver;

    public WebDriver getDriver(String navegador) {
        if (driver == null) {
            driver = Browsers.getDriver(navegador);
        }
        return driver;
    }
}
