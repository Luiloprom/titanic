package es.etg.dam.titanic.informe;

import java.util.List;

public interface GeneradorInforme {
    public String generar(List<String> datos) throws Exception;

    public void guardar(String contenido, String ruta) throws Exception;
}
