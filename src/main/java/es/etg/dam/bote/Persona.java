package es.etg.dam.bote;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private char tipo;

    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    private final char NINO = 'N';

    public char determinarTipo() {
        Random random = new Random();
        switch (random.nextInt(3) + 1) {
            case 1 -> tipo = MUJER;
            case 2 -> tipo = HOMBRE;
            case 3 -> tipo = NINO;
            default -> throw new AssertionError();
        }
        return tipo;
    }
}
