package es.etg.dam.titanic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import es.etg.dam.titanic.informes.Formato;
import es.etg.dam.titanic.informes.GeneradorInforme;
import es.etg.dam.titanic.informes.GeneradorInformeFactory;

public class ServicioEmergencia {

    private static final String JAVA = "java";
    private static final String CP = "-cp";
    private static final String CLASSPATH = "target/classes";
    private static final String BOTE = "es.etg.dam.botes.Bote";
    private static final String FORMATO = "B%02d";
    private static final String RUTA = "src/main/resources/informe.md";
    private static final String MSG_FINAL = "Informe generado y redactado correctamente en " + RUTA;

    public static void llamar() throws Exception {
        List<String> datos = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            String id = String.format(FORMATO, i);
            String[] comando = construirComando(id);
            Process bote = Runtime.getRuntime().exec(comando);

            datos.addAll(leer(bote));

            System.out.println(id + " generado correctamente");
        }

        readactarInforme(datos, Formato.MARKDOWN, RUTA);
        System.out.println(MSG_FINAL);

    }

    private static String[] construirComando(String id) {
        return new String[] { JAVA, CP, CLASSPATH, BOTE, id };
    }

    private static List<String> leer(Process p) throws Exception {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }
        p.waitFor();
        return lineas;
    }

    private static void readactarInforme(List<String> datos, Formato formato, String ruta) throws Exception {
        GeneradorInforme generadorInforme = GeneradorInformeFactory.obtener(formato);
        String contenido = generadorInforme.generar(datos);
        generadorInforme.guardar(contenido, ruta);
    }

}