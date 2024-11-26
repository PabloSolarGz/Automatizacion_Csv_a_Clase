package pageFactory.pages.sesion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "normal_login_username")
    private WebElement textUsuario;

    @FindBy(id = "normal_login_password")
    private WebElement textPassword;

    @FindBy(xpath = "//div/button[contains(@class, 'ant-btn ant-btn-primary ant-btn-block btn-form')]")
    private WebElement botonLogin;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void ingresarCredenciales(String usuario, String password) throws InterruptedException {
        textUsuario.clear();
        textUsuario.sendKeys(usuario);
        textPassword.clear();
        textPassword.sendKeys(password);
        botonLogin.click();
        Thread.sleep(10000);
    }
}
