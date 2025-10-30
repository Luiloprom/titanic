package es.etg.dam.titanic.informes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeneradorMarkdown implements GeneradorInforme {

    private static final String ENCABEZADO = "# SERVICIO DE EMERGENCIAS";
    private static final String FECHA = "dd/MM/yyyy 'a las' HH:mm:ss";
    private static final String SEPARADOR = "\n\n";

    private static final String ETIQUETA_TOTAL_SALVADOS = "Total Salvados";
    private static final String ETIQUETA_MUJERES = "Mujeres";
    private static final String ETIQUETA_HOMBRES = "Hombres";
    private static final String ETIQUETA_NINOS = "Niños";

    private static final String FORMATO_BLOQUE_BOTE = "## Bote %s\n- %s %d\n  - %s %d\n  - %s %d\n  - %s %d\n\n";
    private static final String FORMATO_RESUMEN = "## Total\n- %s %d\n  - %s %d\n  - %s %d\n  - %s %d";

    @Override
    public String generar(List<String> datos) {
        StringBuilder sb = new StringBuilder();

        sb.append(ENCABEZADO).append(SEPARADOR);
        sb.append("Ejecución realizada el día ")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(FECHA))).append(SEPARADOR);

        int totalSalvados = 0, totalMujeres = 0, totalHombres = 0, totalNinos = 0;

        for (int i = 0; i < datos.size(); i += 5) {
            String id = datos.get(i);
            int total = Integer.parseInt(datos.get(i + 1));
            int mujeres = Integer.parseInt(datos.get(i + 2));
            int hombres = Integer.parseInt(datos.get(i + 3));
            int ninos = Integer.parseInt(datos.get(i + 4));

            sb.append(String.format(FORMATO_BLOQUE_BOTE,
                    id,
                    ETIQUETA_TOTAL_SALVADOS, total,
                    ETIQUETA_MUJERES, mujeres,
                    ETIQUETA_HOMBRES, hombres,
                    ETIQUETA_NINOS, ninos));

            totalSalvados += total;
            totalMujeres += mujeres;
            totalHombres += hombres;
            totalNinos += ninos;
        }

        sb.append(String.format(FORMATO_RESUMEN,
                ETIQUETA_TOTAL_SALVADOS, totalSalvados,
                ETIQUETA_MUJERES, totalMujeres,
                ETIQUETA_HOMBRES, totalHombres,
                ETIQUETA_NINOS, totalNinos));

        return sb.toString();
    }

    @Override
    public void guardar(String contenido, String nombreArchivo) throws Exception {
        try (java.io.FileWriter fw = new java.io.FileWriter(nombreArchivo)) {
            fw.write(contenido);
        }
    }
}
