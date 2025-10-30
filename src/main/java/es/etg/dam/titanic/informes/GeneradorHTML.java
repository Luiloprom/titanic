package es.etg.dam.titanic.informes;

import java.util.List;

public class GeneradorHTML implements GeneradorInforme {

    @Override
    public String generar(List<String> contenido) throws Exception {

        return "hola";
    }

    @Override
    public void guardar(String contenido, String ruta) throws Exception {

    }
}
