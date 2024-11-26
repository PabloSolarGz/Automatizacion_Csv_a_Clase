package steps;

import io.cucumber.java.Before;

public class BeforeSteps {
    @Before
    public void configurarEntorno() {
        System.out.println("Preparando entorno para la ejecución de pruebas...");
    }
}
