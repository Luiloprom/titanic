package es.etg.dam.botes;

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

    private static final Random RANDOM = new Random();
    private static final String SALTO = "\n";

    public static void main(String[] args) throws Exception {
        Bote bote = new Bote(args[0]);
        bote.generarDatos();
        bote.simularEmbarque();
        System.out.println(bote.construir());
    }

    private void simularEmbarque() throws Exception {
        int delay = 2000 + RANDOM.nextInt(4000);
        Thread.sleep(delay);
    }

    private void generarDatos() {
        total = RANDOM.nextInt(100) + 1;
        mujeres = RANDOM.nextInt(total + 1);
        hombres = RANDOM.nextInt(total - mujeres + 1);
        ninos = total - mujeres - hombres;
    }

    private String construir() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(SALTO);
        sb.append(total).append(SALTO);
        sb.append(mujeres).append(SALTO);
        sb.append(hombres).append(SALTO);
        sb.append(ninos);
        return sb.toString();
    }

}
