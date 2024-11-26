package steps;

import io.cucumber.java.After;

public class AfterSteps extends BaseSteps {

    @After
    public void cerrarNavegador() {
        cerrarDriver();
    }
}
