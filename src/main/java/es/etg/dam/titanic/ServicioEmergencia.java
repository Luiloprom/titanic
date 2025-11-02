package es.etg.dam.titanic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import es.etg.dam.titanic.informe.Formato;
import es.etg.dam.titanic.informe.GeneradorInforme;
import es.etg.dam.titanic.informe.GeneradorInformeFactory;

public class ServicioEmergencia {

    private static final String JAVA = "java";
    private static final String CP = "-cp";
    private static final String CLASSPATH = "target/classes";
    private static final String BOTE = "es.etg.dam.bote.Bote";
    private static final String FORMATO = "B%02d";
    private static final String RUTA = "src/main/resources/informe.md";
    private static final String MSG_FINAL = "Informe generado y redactado correctamente en " + RUTA;
    private static final String MSG_CONTEO = " Conteo realizado correctamente";

    public static void gestionarEmergencia() throws Exception {
        List<String> datos = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            String id = String.format(FORMATO, i);
            String[] comando = construirComando(id);
            Process bote = desplegar(comando);
            datos.addAll(recogerInfo(bote));

            System.out.println(id + MSG_CONTEO);
        }

        readactarInforme(datos, Formato.MARKDOWN, RUTA);
        System.out.println(MSG_FINAL);

    }

    private static String[] construirComando(String id) {
        return new String[] { JAVA, CP, CLASSPATH, BOTE, id };
    }

    private static Process desplegar(String[] comando) throws Exception {
        Process bote = Runtime.getRuntime().exec(comando);
        return bote;
    }

    private static List<String> recogerInfo(Process bote) throws Exception {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(bote.getInputStream()))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }
        bote.waitFor();
        return lineas;
    }

    private static void readactarInforme(List<String> datos, Formato formato, String ruta) throws Exception {
        GeneradorInforme generadorInforme = GeneradorInformeFactory.obtener(formato);
        String contenido = generadorInforme.generar(datos);
        generadorInforme.guardar(contenido, ruta);
    }

}