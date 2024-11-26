package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.InputStream;
import java.util.Properties;

public class Browsers {
    private static WebDriver driver;

    /**
     * Obtiene una instancia de WebDriver según el navegador especificado.
     * Si no está inicializado, lo crea; si ya existe, lo retorna.
     *
     * @param navegador el nombre del navegador (por ejemplo, "chrome").
     * @return la instancia de WebDriver.
     */
    public static WebDriver getDriver(String navegador) {
        if (driver == null) {
            switch (navegador.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
                    ChromeOptions options = getChromeOptions();
                    driver = new ChromeDriver(options);
                    break;
                default:
                    throw new IllegalArgumentException("Navegador no soportado: " + navegador);
            }
        }
        return driver;
    }

    /**
     * Retorna la instancia existente del WebDriver.
     * Si no se inicializó, lanza una excepción.
     *
     * @return la instancia actual de WebDriver.
     */
    public static WebDriver getDriverInstance() {
        if (driver == null) {
            throw new IllegalStateException("El WebDriver no ha sido inicializado. Usa getDriver primero.");
        }
        return driver;
    }

    /**
     * Obtiene la ruta del driver de Chrome según el sistema operativo.
     *
     * @return la ruta del ChromeDriver configurada en config.properties.
     */
    private static String getChromeDriverPath() {
        String os = System.getProperty("os.name").toLowerCase();
        String driverPathKey = os.contains("win") ? "chromedriver.win"
                : os.contains("mac") ? "chromedriver.mac"
                : os.contains("nix") || os.contains("nux") ? "chromedriver.linux"
                : null;

        if (driverPathKey == null) {
            throw new UnsupportedOperationException("Sistema operativo no soportado: " + os);
        }

        try (InputStream input = Browsers.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                throw new RuntimeException("Archivo config.properties no encontrado.");
            }
            prop.load(input);
            String driverPath = prop.getProperty(driverPathKey);
            if (driverPath == null || driverPath.isEmpty()) {
                throw new RuntimeException("Ruta del ChromeDriver no definida en config.properties para " + driverPathKey);
            }
            return driverPath;
        } catch (Exception e) {
            throw new RuntimeException("Error cargando archivo de configuración", e);
        }
    }

    /**
     * Configura las opciones específicas para el navegador Chrome.
     *
     * @return una instancia de ChromeOptions con las configuraciones necesarias.
     */
    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win") || os.contains("mac")) {
            options.addArguments("--start-maximized");
        } else if (os.contains("nix") || os.contains("nux")) {
            options.addArguments("--disable-dev-shm-usage", "--no-sandbox");
        }

        options.addArguments("--disable-notifications");
        return options;
    }

    /**
     * Cierra el navegador y libera los recursos del WebDriver.
     */
    public static void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
