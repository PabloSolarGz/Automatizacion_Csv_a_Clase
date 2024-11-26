package utils;

import java.util.HashMap;
import java.util.Map;

public class Credenciales {
    private static final Map<String, Credencial> credenciales = new HashMap<>();

    static {
        credenciales.put("operador1@previred.com", new Credencial.Builder()
                .usuario("operador1@previred.com")
                .navegador("chrome")
                .ambiente("uat")
                .password("Claves4#")
                .perfilUsuario("Operador Previred")
                .comision("Sin Comisión")
                .url("https://uat.sagcom.cl/acceso?from=/")
                .build());

        credenciales.put("ejecutivo.ips1@ips.cl", new Credencial.Builder()
                .usuario("ejecutivo.ips1@ips.cl")
                .navegador("chrome")
                .ambiente("uat")
                .password("Claves4#")
                .perfilUsuario("Ejecutivo IPS")
                .comision("Sin Comisión")
                .url("https://uat.sagcom.cl/acceso?from=/")
                .build());
    }

    public static Map<String, Credencial> getCredenciales() {
        return credenciales;
    }
}
