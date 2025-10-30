package es.etg.dam.titanic.informes;

public class GeneradorInformeFactory {

    private static GeneradorInforme generadorInforme;

    private static void inicializar(Formato formato) {

        if (Formato.MARKDOWN.equals(formato)) {
            generadorInforme = new GeneradorMarkdown();
        } else {
            generadorInforme = new GeneradorHTML();
        }
    }

    public static GeneradorInforme obtener(Formato formato) {
        if (generadorInforme == null) {
            inicializar(Formato.MARKDOWN);
        }
        return generadorInforme;
    }
}
