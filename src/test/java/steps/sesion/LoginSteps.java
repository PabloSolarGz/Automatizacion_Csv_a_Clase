package steps.sesion;

import io.cucumber.java.en.Given;
import pageFactory.pages.sesion.LoginPage;
import steps.BaseSteps;
import utils.Credencial;
import utils.ListadoCredencialesPorCsv;

public class LoginSteps extends BaseSteps {
    private LoginPage loginPage;

    @Given("Ingreso a Sagcom2 con el usuario {string}")
    public void ingreso_a_sagcom2_con_el_usuario(String usuario) throws InterruptedException {
        // Procesar credenciales si es necesario.
        if (ListadoCredencialesPorCsv.getCredenciales().isEmpty()) {
            ListadoCredencialesPorCsv.procesarCSV();
        }

        // Busca la credencial del usuario especificado.
        Credencial credencial = ListadoCredencialesPorCsv.getCredenciales().get(usuario);
        if (credencial == null) {
            throw new RuntimeException("El usuario no está registrado en el archivo CSV: " + usuario);
        }

        // Obtén el WebDriver inicializado.
        driver = getDriverInstance();

        // Carga la URL en el navegador.
        driver.get(credencial.getUrl());
        System.out.println("Navegador cargó la URL: " + credencial.getUrl());

        // Realiza el login.
        loginPage = new LoginPage(driver);
        loginPage.ingresarCredenciales(credencial.getUsuario(), credencial.getPassword());
        System.out.println("Credenciales ingresadas correctamente para el usuario: " + usuario);
    }
}
