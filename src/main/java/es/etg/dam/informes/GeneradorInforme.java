package es.etg.dam.informes;

public interface GeneradorInforme {
    public void generar() throws Exception;

    public void guardar(String contenido, String ruta) throws Exception;
}
