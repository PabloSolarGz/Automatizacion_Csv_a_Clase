package pageFactory.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/header/div[1]/div/div[4]/div/div/div[1]/span/span")
    WebElement btnPerfil;

    @FindBy(xpath = "/html/body/div[2]/div/div/ul/li[2]/span")
    WebElement opcionCerrarSesion;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Cambiado para usar Duration
        PageFactory.initElements(driver, this);
    }

    public void clickPerfil() {
        wait.until(ExpectedConditions.elementToBeClickable(btnPerfil)).click();
    }

    public void clickCerrarSesion() {
        wait.until(ExpectedConditions.elementToBeClickable(opcionCerrarSesion)).click();
    }

    public void cerrarSesionActiva() throws InterruptedException {
        clickPerfil();
        Thread.sleep(1000);
        clickCerrarSesion();
        Thread.sleep(1000);
    }
}
