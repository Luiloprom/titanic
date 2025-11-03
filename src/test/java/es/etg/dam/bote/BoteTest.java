package es.etg.dam.bote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;

public class BoteTest {

    @InjectMocks
    private Bote bote = new Bote("Test");

    @Test
    public void testComunicarDatos() {
        bote.setTotal(7);
        bote.setMujeres(2);
        bote.setHombres(4);
        bote.setNinos(1);

        assertEquals("Test\n7\n2\n4\n1", bote.comunicarDatos());
    }

    @Test
    public void testGenerarPersonas() throws Exception {
        Bote spyBote = spy(bote);
        doNothing().when(spyBote).simularConteo();

        spyBote.generarPersonas();

        int total = spyBote.getHombres() + spyBote.getMujeres() + spyBote.getNinos();
        assertEquals(spyBote.getTotal(), total);
        assertTrue(total > 0);
    }

}
