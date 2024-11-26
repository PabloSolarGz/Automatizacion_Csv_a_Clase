package steps;

import io.cucumber.java.After;
import utils.Browsers;

public class AfterSteps {
    @After
    public void cerrarNavegadores() {
        Browsers.cerrarNavegador();
        System.out.println("Todos los navegadores han sido cerrados.");
    }
}
