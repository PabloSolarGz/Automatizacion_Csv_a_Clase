package steps;

import org.openqa.selenium.WebDriver;
import utils.Browsers;

public class BaseSteps {
    protected static WebDriver driver;

    /**
     * Inicializa el WebDriver si no está creado.
     */
    public static WebDriver getDriver(String navegador) {
        if (driver == null) {
            driver = Browsers.getDriver(navegador);
            System.out.println("Navegador inicializado: " + navegador);
        }
        return driver;
    }

    /**
     * Retorna el WebDriver existente o lanza una excepción si no está inicializado.
     */
    public static WebDriver getDriverInstance() {
        if (driver == null) {
            throw new IllegalStateException("El WebDriver no ha sido inicializado. Usa getDriver primero.");
        }
        return driver;
    }

    /**
     * Cierra el WebDriver.
     */
    public static void cerrarDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Navegador cerrado.");
        }
    }
}
