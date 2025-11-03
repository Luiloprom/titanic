package es.etg.dam.bote;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    private Persona persona = new Persona('A');

    @Test
    public void testDeterminarTipo() {
        char tipo = persona.determinarTipo();
        assertTrue(tipo == 'H' || tipo == 'M' || tipo == 'N');
    }

}
