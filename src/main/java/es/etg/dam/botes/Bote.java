package es.etg.dam.botes;

import java.util.Random;

public class Bote {
    private String id;
    private RegistroBote registro;
    private static final Random RANDOM = new Random();

    public Bote(String id) {
        this.id = id;
    }

    public static void main(String[] args) throws Exception {
        Bote bote = new Bote(args[0]);
        bote.simularEmbarque();
        System.out.println(bote.construir());
    }

    public void simularEmbarque() throws Exception {
        int delay = 2000 + RANDOM.nextInt(4000);
        Thread.sleep(delay);
    }

    public RegistroBote generarDatos() {
        int total = RANDOM.nextInt(100) + 1;
        int mujeres = RANDOM.nextInt(total + 1);
        int varones = RANDOM.nextInt(total - mujeres + 1);
        int niños = total - mujeres - varones;
        return new RegistroBote(id, total, mujeres, varones, niños);
    }

    public String construir() {
        if (registro == null) {
            registro = generarDatos();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(registro.getId()).append(" ");
        sb.append(registro.getTotal()).append(" ");
        sb.append(registro.getMujeres()).append(" ");
        sb.append(registro.getHombres()).append(" ");
        sb.append(registro.getNiños());
        return sb.toString();
    }

}
