package steps.sesion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageFactory.pages.sesion.LoginPage;
import utils.Browsers;
import utils.Credencial;
import utils.ListadoCredencialesPorCsv;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("Ingreso a Sagcom2 con el usuario {string}")
    public void ingreso_a_sagcom2_con_el_usuario(String usuario) throws InterruptedException {
        if (ListadoCredencialesPorCsv.getCredenciales().isEmpty()) {
            ListadoCredencialesPorCsv.procesarCSV();
        }
        Credencial credencial = ListadoCredencialesPorCsv.getCredenciales().get(usuario);

        if (credencial == null) {
            throw new RuntimeException("El usuario no está registrado en el archivo CSV: " + usuario);
        }
        driver = Browsers.getDriver(credencial.getNavegador());
        driver.get(credencial.getUrl());
        loginPage = new LoginPage(driver);
        loginPage.ingresarCredenciales(credencial.getUsuario(), credencial.getPassword());
    }

    @Then("Cierro el navegador")
    public void cerrarNavegador() {
        try {
            Browsers.cerrarNavegador();
            System.out.println("El navegador se cerró correctamente.");
        } catch (Exception e) {
            System.err.println("Error al cerrar el navegador: " + e.getMessage());
        }
    }
}
