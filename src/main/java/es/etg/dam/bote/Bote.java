package es.etg.dam.bote;

import java.util.Random;

import lombok.Data;

@Data
public class Bote {
    private final String id;
    private int total;
    private int mujeres;
    private int hombres;
    private int ninos;

    public Bote(String id) {
        this.id = id;
    }

    private final String SALTO = "\n";
    private static final int PRIMER_PARAMETRO = 0;
    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    private final char NINO = 'N';

    private static final Persona persona = new Persona('H');
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws Exception {
        Bote bote = new Bote(args[PRIMER_PARAMETRO]);
        bote.generarPersonas();
        System.out.println(bote.comunicarDatos());
    }

    protected void simularConteo() throws Exception {
        int delay = 2000 + RANDOM.nextInt(4000);
        Thread.sleep(delay);
    }

    protected void generarPersonas() throws Exception {
        total = RANDOM.nextInt(100) + 1;
        for (int i = 0; i < total; i++) {
            switch (persona.determinarTipo()) {
                case MUJER -> mujeres += 1;
                case HOMBRE -> hombres += 1;
                case NINO -> ninos += 1;
                default -> throw new AssertionError();
            }
        }
        simularConteo();
    }

    protected String comunicarDatos() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(SALTO);
        sb.append(total).append(SALTO);
        sb.append(mujeres).append(SALTO);
        sb.append(hombres).append(SALTO);
        sb.append(ninos);
        return sb.toString();
    }

}
