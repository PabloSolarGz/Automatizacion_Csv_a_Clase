package steps.dashboard;

import io.cucumber.java.en.Then;
import pageFactory.dashboard.DashboardPage;
import steps.BaseSteps;

public class DashboardSteps extends BaseSteps {
    private DashboardPage dashboardPage;

    public DashboardSteps() {
        super();
        this.dashboardPage = new DashboardPage(getDriverInstance());
    }

    @Then("Cierro sesión desde el Dashboard")
    public void cerrarSesionDesdeDashboard() throws InterruptedException {
        dashboardPage.cerrarSesionActiva();
        System.out.println("Sesión cerrada exitosamente.");
    }
}
