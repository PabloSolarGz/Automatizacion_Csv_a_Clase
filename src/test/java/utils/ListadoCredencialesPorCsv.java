package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ListadoCredencialesPorCsv {
    private static final Map<String, Credencial> credenciales = new HashMap<>();
    private static final String ARCHIVO_CSV = "src/test/resources/features/csv/sesion/datos_sesion.csv";

    public static void procesarCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(ARCHIVO_CSV))) {
            String[] encabezados = reader.readNext(); // Leer encabezados
            if (encabezados == null) {
                System.out.println("El archivo CSV no tiene encabezados.");
                return;
            }

            String[] fila;
            while ((fila = reader.readNext()) != null) {
                if (fila.length < 6) {
                    System.err.println("Fila con datos incompletos: " + String.join(", ", fila));
                    continue;
                }

                String usuario = fila[0].trim();
                String navegador = fila[1].trim();
                String ambiente = fila[2].trim();
                String password = fila[3].trim();
                String perfilUsuario = fila[4].trim();
                String comision = fila[5].trim();
                String url = Ambientes.seleccionarUrl(ambiente);

                Credencial credencial = new Credencial.Builder()
                        .usuario(usuario)
                        .navegador(navegador)
                        .ambiente(ambiente)
                        .url(url)
                        .password(password)
                        .perfilUsuario(perfilUsuario)
                        .comision(comision)
                        .build();

                credenciales.put(usuario, credencial);
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    public static Map<String, Credencial> getCredenciales() {
        return credenciales;
    }
}
