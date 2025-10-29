package es.etg.dam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServicioEmergencia {
    private static final String JAVA = "java";
    private static final String CP = "-cp";
    private static final String CLASSPATH = "target/classes";
    private static final String BOTE = "es.etg.dam.botes.Bote";

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 20; i++) {
            String id = String.format("B%02d", i);
            String[] comando = construirComando(id);
            Process bote = Runtime.getRuntime().exec(comando);
            System.out.println(leer(bote));
        }
    }

    private static String[] construirComando(String id) {
        return new String[] { JAVA, CP, CLASSPATH, BOTE, id };
    }

    private static String leer(Process p) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String linea = reader.readLine();
            return linea;
        }
    }

}