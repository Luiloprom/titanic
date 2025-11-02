package es.etg.dam.bote;

import java.util.Random;

import lombok.Data;

@Data
public class Persona {
    private char tipo;

    public char determinarTipo() {
        Random random = new Random();
        switch (random.nextInt(3) + 1) {
            case 1 -> tipo = 'M';
            case 2 -> tipo = 'H';
            case 3 -> tipo = 'N';
            default -> throw new AssertionError();
        }
        return tipo;
    }
}
