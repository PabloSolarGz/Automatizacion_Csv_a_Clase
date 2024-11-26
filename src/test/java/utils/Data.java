package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Data {

    private static final String ARCHIVO_CSV = "src/test/resources/features/csv/sesion/datos_sesion.csv";

    public static void procesarCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(ARCHIVO_CSV))) {
            String[] encabezados = reader.readNext();
            if (encabezados == null) {
                System.err.println("El archivo CSV no tiene encabezados.");
                return;
            }

            String[] fila;
            while ((fila = reader.readNext()) != null) {
                if (fila.length < 7) {
                    System.err.println("Fila con datos incompletos: " + Arrays.toString(fila));
                    continue;
                }

                String usuario = fila[0].trim();
                String navegador = fila[1].trim();
                String ambiente = fila[2].trim();
                String url = fila[3].trim();
                String password = fila[4].trim();
                String perfilUsuario = fila[5].trim();
                String comision = fila[6].trim();

            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
