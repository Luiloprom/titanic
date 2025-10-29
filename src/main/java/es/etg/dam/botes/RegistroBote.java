package es.etg.dam.botes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistroBote {
    private String id;
    private int total;
    private int mujeres;
    private int hombres;
    private int niños;
}
