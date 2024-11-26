package steps;

import io.cucumber.java.Before;
import utils.Credencial;
import utils.ListadoCredencialesPorCsv;

public class BeforeSteps extends BaseSteps {

    @Before
    public void configurarNavegador() {
        // Procesar credenciales si no están cargadas.
        if (ListadoCredencialesPorCsv.getCredenciales().isEmpty()) {
            ListadoCredencialesPorCsv.procesarCSV();
        }

        // Obtén una credencial para inicializar el navegador.
        Credencial credencial = ListadoCredencialesPorCsv.getCredenciales()
                .values()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No hay credenciales disponibles."));

        // Inicializa el navegador.
        getDriver(credencial.getNavegador());
    }
}
