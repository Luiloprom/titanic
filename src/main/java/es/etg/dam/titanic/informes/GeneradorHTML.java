package es.etg.dam.titanic.informes;

import java.util.List;

public class GeneradorHTML implements GeneradorInforme {
    private final String MSG_NO_IMPLEMENTADO = "Esta funcionalidad no esta implementada todavia";

    @Override
    public String generar(List<String> contenido) throws Exception {
        throw new UnsupportedOperationException(MSG_NO_IMPLEMENTADO);
    }

    @Override
    public void guardar(String contenido, String ruta) throws Exception {
        throw new UnsupportedOperationException(MSG_NO_IMPLEMENTADO);
    }
}
