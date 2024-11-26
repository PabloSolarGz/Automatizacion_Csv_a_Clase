Feature: Valido flujo ingresar solicitudes de Tpo - AFP

  Scenario: Iniciar sesión con usuarios del archivo csv
    Given Ingreso a Sagcom2 con el usuario "operador1@previred.com"
    Then  Cierro el navegador